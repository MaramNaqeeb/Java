import java.util.ArrayList;

public class TestItems {

  public static void main(String[] args) {
    Item item1 = new Item("coffee", 2.5);
    Item item2 = new Item("latte", 4.5);
    Item item3 = new Item("cappacino", 1.5);
    Item item4 = new Item("mocha", 3.5);

    // Order order= new Order();
    // order.addItem(item1);
    // order.addItem(item2);

    Order order1 = new Order();
    order1.addItem(item1);
    order1.addItem(item2);

    Order order2 = new Order();
    order2.addItem(item2);
    order2.addItem(item3);

    Order order3 = new Order("Noah", true);
    order3.addItem(item3);
    order3.addItem(item1);

    Order order4 = new Order("Jane", false);
    order4.addItem(item4);
    order4.addItem(item2);

    Order order5 = new Order("ALin", true);
    order5.addItem(item2);
    order5.addItem(item3);

    order1.displayItAll();
    order1.print();
    order2.displayItAll();
    order2.print();
    order3.displayItAll();
    order3.print();
    order4.displayItAll();
    order4.print();
    order5.displayItAll();
    order5.print();
  }
}
