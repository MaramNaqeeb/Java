import java.util.ArrayList;

public class CoffeeKiosk {

  ArrayList<Item> menu;
  ArrayList<Order> orders;

  public CoffeeKiosk() {
    menu = new ArrayList<Item>();
    orders = new ArrayList<Order>();
  }

  public void addMenuItem(String name, double price) {
    Item item = new Item(name, price);
    menu.add(item);
    int i = menu.indexOf(item);
    item.index = i;
  }

  public void displayMenu() {
    for ( int i = 0; i < menu.size(); i++) {
      System.out.println(
        menu.get(i).index + " " + menu.get(i).name + " -- " + menu.get(i).price
      );
    }
  }
}
