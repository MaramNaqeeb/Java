import java.util.ArrayList;

public class TestOrders {

  public static void main(String[] args) {
    // Item item1 = new Item("coffee", 2.5);
    // Item item2 = new Item("latte", 4.5);
    // Item item3 = new Item("cappacino", 1.5);
    // Item item4 = new Item("mocha", 3.5);

    // Order order1 = new Order();
    // order1.addItem(item1);

    // Order order2 = new Order();
    // order2.addItem(item2);

    // Order order3 = new Order("Noah", true);
    // order3.addItem(item3);

    // Order order4 = new Order("Jane", false);
    // order4.addItem(item4);

    // Order order5 = new Order("Jone", true);
    // order5.addItem(item4);

    // order1.print();
    // order2.print();
    // order3.print();
    // order4.print();
    // order5.print();
   CoffeeKiosk kiosk = new CoffeeKiosk();
    kiosk.addMenuItem( "coffee", 2.5);
    kiosk.addMenuItem( "lattee", 3.5);

    kiosk.displayMenu();



  }
}
