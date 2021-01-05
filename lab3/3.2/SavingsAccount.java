/* Define class SavingsAccount here. */
public class SavingsAccount extends BankAccount {
   
   private double interest;
   
   public SavingsAccount(String name, double balance, double interest) {
      super(name, balance);
      this.interest = interest;
   }
   
   public void addInterest () {
      double curr_interest = (interest / 100) * getBalance();
      deposit(curr_interest);
      
   }
}
   