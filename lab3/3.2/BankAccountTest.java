import java.util.Scanner;

public class BankAccountTest {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      
      // Read in Savings Parameters
      String savingsName = scn.next();
      double savingsBalance = scn.nextDouble();
      double savingsInterest = scn.nextDouble();
      
      // Read in Checkings Parameters
      String checkingsName = scn.next();
      double checkingsBalance = scn.nextDouble();
      
      /* Type your code here. */
      SavingsAccount savings = new SavingsAccount(savingsName, savingsBalance, savingsInterest);
      CheckingAccount checkings = new CheckingAccount(checkingsName, checkingsBalance);
      savings.deposit(1000);
      checkings.withdraw(100);
      savings.transfer(checkings, 200);
      checkings.deductFees();
      savings.addInterest();
      System.out.println(savings);
      System.out.println(checkings);
      
   }
}
