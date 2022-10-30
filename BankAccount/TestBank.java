public class TestBank {

  public static void main(String[] args) {
    BankAccount myAccount1 = new BankAccount();
    myAccount1.withDraw(30);
    myAccount1.deposite(20);
    myAccount1.display();

    BankAccount myAccount2 = new BankAccount();
    myAccount2.withDraw(40);
    myAccount2.deposite(10);
    myAccount2.display();
  }
}
