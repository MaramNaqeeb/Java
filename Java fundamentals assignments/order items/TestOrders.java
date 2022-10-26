import java.util.ArrayList;
public class TestOrders{

public static void main(String[] args){

Item item1 =new Item();
Item item2 =new Item();
Item item3 =new Item();
Item item4 =new Item();

item1.name="coffee";
item1.price=2.5;
item2.name="latte";
item2.price=4.5;
item3.name="cappacino";
item3.price=1.5;
item4.name="mocha";
item4.price=3.5;


Order order1= new Order();
order1.name="Sam";
order1.myItem.add(item1);
order1.total+=item1.price;
order1.ready=true;

Order order2= new Order();
order2.name="Jimmy";
order2.myItem.add(item2);
order2.total+=item2.price;
order2.ready=false;

Order order3=new Order();
order3.name="Noah";
order3.myItem.add(item3);
order3.total+=item3.price;
order3.ready=true;

Order order4=new Order();
order4.name="Jane";
order4.myItem.add(item4);
order4.total+=item4.price;
order4.ready=false;





System.out.printf("Name: %s\n", order1.name);
System.out.printf("Total: %s\n", order1.total);
System.out.printf("Ready: %s\n", order1.ready);

System.out.printf("Name: %s\n", order2.name);
System.out.printf("Total: %s\n", order2.total);
System.out.printf("Ready: %s\n", order2.ready);

System.out.printf("Name: %s\n", order3.name);
System.out.printf("Total: %s\n", order3.total);
System.out.printf("Ready: %s\n", order3.ready);

System.out.printf("Name: %s\n",order4.name);
System.out.printf("Total: %s\n",order4.total);
System.out.printf("Ready: %s\n",order4.ready);
}



    }



