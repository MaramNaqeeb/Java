public class BankAccount {

  private double checkingBalance;
  private double savingBalance;
  public static int totalMoney;
  public static int numberOfAccounts = 0;

  public void count(double checkingBalance, double savingBalance) {
    this.checkingBalance = checkingBalance;
    this.savingBalance = savingBalance;
  }

  public double getCheckingBalance() {
    return this.checkingBalance;
  }

  public double getSavingBalance() {
    return savingBalance;
  }

  public void deposite(double amount) {
    this.savingBalance += amount;
    totalMoney++;
  }

  public void withDraw(double amount) {
    if (amount <= checkingBalance) {
      this.checkingBalance -= amount;
      totalMoney--;
    }
    System.out.println(" you cannot withdraw");
  }

  public double getAmount() {
    return this.checkingBalance + this.savingBalance;
  }

  public void display() {
    System.out.println(this.checkingBalance);
    System.out.println(this.savingBalance);
    System.out.println(this.totalMoney);
    System.out.println(this.getAmount());
  }
}
