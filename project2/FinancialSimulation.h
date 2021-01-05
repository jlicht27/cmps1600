#include <stdbool.h>

typedef struct financialIdentity {
  double savings;
  double checkings;
  double debt;
  double loan;
  int yearsWithDebt;
  int yearsRented;
  double debtPaid;
  bool ownsHouse;
} financialIdentity;

void savingsPlacement(financialIdentity *person, double interestRate);

void debt(financialIdentity *person, double interestRate, double addlPay);

void rent(financialIdentity *person, double rentAmount);

void house(financialIdentity *person, double mortgageAmount,
double interestRate, int mortgageTerm);

int * simulate(financialIdentity *person, double yearlySalary,
bool financiallyLiterate, int addlPay, double loanInterest, int housePrice,
int rentPrice);

void makePayment(financialIdentity *person, double payment);
