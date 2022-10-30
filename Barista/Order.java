import java.util.ArrayList;

public class Order {

  private String name;
  private double total;
  private boolean ready;
  private ArrayList<Item> myItems;

  public Order(String name, boolean ready) {
    this.name = name;
    this.ready = ready;
    myItems = new ArrayList<Item>();
  }

  public Order(String name) {
    this.name = name;
    this.ready = false;
    myItems = new ArrayList<Item>();
  }

  public Order() {
    this.name = "";
    this.ready = false;
    myItems = new ArrayList<Item>();
  }

  public String getStatusMessage(boolean status) {
    if (status == true) {
      return " your order is ready";
    }
    return " your order is not ready";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public boolean getReady() {
    return ready;
  }

  public void setReady(boolean ready) {
    this.ready = ready;
  }

  /*
  {%for one in myItems:%}
  {{one.name}}-item{one.price}price
  {% endfor %}
    
  */

  public void displayItAll() {
    int count = 0;
    System.out.println("customer :" + this.name);
    for (Item one : myItems) {
      System.out.println(count + "-item " + one.name + " price" + one.price);
      count++;
    }
  }

  public void addItem(Item item) {
    myItems.add(item);
    total += item.price;
  }

  public void print() {
    System.out.printf("Total: %s\n", this.total);
    System.out.printf("Ready: %s\n", this.ready);
    System.out.printf("Ready: %s\n", this.getStatusMessage(this.ready));
  }
}
