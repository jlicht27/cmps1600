#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include "FinancialSimulation.h"

int main(int argc, char **argv) {

  float initialDebt;
  float yearlySalary;
  int addlPay;
  float loanInterest;
  int housePrice;
  int rentPrice;
  int inputFL;
  bool financiallyLiterate;

  //This sections reads input from input file

  FILE *inFile = fopen(argv[1], "r");
  if (inFile == NULL) {
    printf("Could not open input file\n");
    return -1;
  }

  fscanf(inFile, "%f %f %d %f %d %d %d", &initialDebt, &yearlySalary,
  &addlPay, &loanInterest, &housePrice, &rentPrice, &inputFL);

  fclose(inFile);

  //last number scanned determines whether FL or NFL
  if (inputFL == 1) {
    financiallyLiterate = true;
  }
  else if (inputFL == 0){
    financiallyLiterate = false;
  }
  else {
    printf("Invalid input\n");
    return -1;
  }

  //create simulated person from file input and run simulation
  financialIdentity simulatedPerson = {

    5000.0,  //savings
    0.0,     //checkings
    initialDebt, //debt
    0.0,     //loan
    0,       //years with debt
    0,       //years rented
    0.0,     //debt paid
    false    //owns house

  };

  int* simulationArr = simulate(&simulatedPerson, yearlySalary,
  financiallyLiterate, addlPay, loanInterest, housePrice, rentPrice);

  // This section prints the simulation

  FILE* outFile = fopen(argv[2], "w");
  if (outFile == NULL) {
    printf("Could not open output file\n");
    return -1;
  }

  if (financiallyLiterate == true) {
    fprintf(outFile, "SIMULATING FL\n\n");
  }
  else if (financiallyLiterate == false) {
    fprintf(outFile, "SIMULATING NFL\n\n");
  }

  for (int i = 0; i < 41; i++) {
    if (i < 10) {
      fprintf(outFile, "Year %d ; Wealth: %d\n",i , simulationArr[i]);
    }
    else {
      fprintf(outFile, "Year %d; Wealth: %d\n",i,  simulationArr[i]);
    }
  }
  fclose(outFile);

  free(simulationArr);

  return 0;
}

void savingsPlacement(financialIdentity *person, double interestRate) {
  person->savings *= (1 + interestRate);
}

void debt(financialIdentity *person, double interestRate, double addlPay) {
  const double minPaymentPercent = 0.03;
  double payment;

  //loop over all months
  for (int month = 1; month <= 12; month++) {

    //if person still has debt
    if (person->debt > 0.0) {
      payment = (person->debt * minPaymentPercent) + addlPay;

      //set payment to amount of debt if payment is larger than debt
      if (payment > person->debt) {
        payment = person->debt;
      }

      makePayment(person, payment);
      person->debt -= payment;
      person->debtPaid += payment;
    }

    //person doesn't have debt left
    else {
      person->debt = 0.0;
      person->checkings -= addlPay;
      person->savings += addlPay;
      break;
    }
  }

  //multiply leftover debt by interest rate
  person->debt *= (1 + interestRate);

  person->yearsWithDebt++;
}

void rent(financialIdentity *person, double rentAmount) {

  //loop over each month and pay rent
  for (int month = 1; month <= 12; month++) {
    makePayment(person, rentAmount);
  }
  person->yearsRented++;
}

void house(financialIdentity *person, double mortgageAmount,
double interestRate, int mortgageTerm) {
  const int numOfPayments = mortgageTerm * 12;
  double tempInterestRate = interestRate / 12;
  double discountFactor = (pow((1 + tempInterestRate), numOfPayments) - 1) /
  (tempInterestRate * pow((1 + tempInterestRate), numOfPayments));
  double monthlyPayment = mortgageAmount / discountFactor;

  for (int month = 1; month <= 12; month++) {
    if (monthlyPayment >= person->loan) {
      monthlyPayment = person->loan;
      makePayment(person, monthlyPayment);
      person->loan = 0;
    }
    else {
      makePayment(person, monthlyPayment);
      person->loan -= monthlyPayment;
    }
  }
  person->loan *= (1+ interestRate);

}

int * simulate(financialIdentity *person, double yearlySalary,
bool financiallyLiterate, int addlPay, double loanInterest, int housePrice,
int rentPrice) {

  double savingsInterest;
  double downpaymentPercent;

  if (financiallyLiterate == true) {

    //savingsPlacement interest
    savingsInterest = 0.07;

    //when to buy a house
    downpaymentPercent = 0.2;
  }
  else {

    //savingsPlacement interest
    savingsInterest = 0.01;

    //when to buy a house
    downpaymentPercent = 0.05;

    //increase loan interest
    loanInterest += 0.005;
  }

  int* arr = (int*)malloc(41 * sizeof(int));
  int wealth = person->savings + person->checkings - person->debt - person->loan;
  int downPayment = downpaymentPercent * housePrice;
  int mortgageTerm = 30;

  arr[0] = wealth;
  for (int year = 1; year <= 40; year++) {

    //yearly salaray input
    person->savings += (0.2 * yearlySalary);
    person->checkings += (.3 * yearlySalary);

    //savings and debt
    savingsPlacement(person, savingsInterest);
    debt(person, 0.2, addlPay);

    //owns owns?
    if (person->ownsHouse == false) {

      //if they can afford to buy a house
      if (person->savings >= (downpaymentPercent * housePrice)) {
        person->savings -= downPayment;
        person->loan = housePrice - downPayment;
        person->ownsHouse = true;
      }

      //else pay rent
      else {
        rent(person, rentPrice);
      }

    //else pay mortgage
    }
    else if (person->loan > 0) {
      house(person, housePrice, loanInterest, mortgageTerm);
    }
    wealth = person->savings + person->checkings - person->debt - person->loan;
    arr[year] = wealth;
  }
  return arr;
}

void makePayment(financialIdentity *person, double payment) {
  if (payment > person->checkings) {
    double savingsDraft = payment - person->checkings;
    person->savings -= savingsDraft;
    person->checkings = 0.0;
  }
  else{
    person->checkings -= payment;
  }
}
