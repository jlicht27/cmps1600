public class BankAccount {

   /* Implement class BankAccount here. */
   protected String name;
   protected double balance;
   
   public BankAccount(String name, double balance) {
      this.name = name;
      this.balance = balance;
   }
   
   public String getName () {
      return name;
   }
   
   public double getBalance () {
      return balance;
   }
   
   public void deposit(double userAmount) {
      balance += userAmount;
   }
   
   public void withdraw (double userAmount) {
      balance -= userAmount;
   }
   
   public void transfer (BankAccount bank,double amount) {
      withdraw(amount);
      bank.deposit(amount);
   }
   
   public String toString () {
      return String.format("%s, $%.2f", name, balance);
   }
   
}
