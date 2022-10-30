import java.util.ArrayList;

public class TestOrders {

  public static void main(String[] args) {

   CoffeeKiosk kiosk = new CoffeeKiosk();
    kiosk.addMenuItem( "coffee", 2.5);
    kiosk.addMenuItem( "lattee", 3.5);

    kiosk.displayMenu();



  }
}
