/* Define class CheckingAccount here */
public class CheckingAccount extends BankAccount {
   
   private int transactionCount = 0;
   static final double TRANSACTION_FEE = 3.0;
   
   public CheckingAccount (String name, double balance) {
      super (name, balance);
   }
   
   @Override
   public void deposit(double amount) {
      super.deposit(amount);
      transactionCount++;
   }
   
   @Override
   public void withdraw(double amount) {
      super.withdraw(amount);
      transactionCount++;
   }
   
   public void deductFees () {
      double fees = transactionCount * TRANSACTION_FEE;
      transactionCount = 0;
      withdraw(fees);
   }
}
      