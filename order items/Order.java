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
 

  public Order() {
    this.name="";
    this.ready=false;
    
    myItems = new ArrayList<Item>();
  }




  public void addItem(Item item) {
    myItems.add(item);
    total += item.price;
  }




  public void print() {
    System.out.printf("Name: %s\n", this.name);
    System.out.printf("Total: %s\n", this.total);
    System.out.printf("Ready: %s\n", this.ready);
  }
}
