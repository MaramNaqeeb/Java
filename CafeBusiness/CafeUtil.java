import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CafeUtil {

  int getStreakGoal( int numWeeks) {
    int sum = 0;
    for (int i = 0; i <= numWeeks; i++) {
      sum += i;
    }
    return sum;
  }

  double getOrderTotal(double[] prices) {
    double total = 0;
    for (int i = 0; i < prices.length; i++) {
      total = total + prices[i];
    }
    return total;
  }

  void displayMenu(ArrayList<String> menuItems) {
    for (int i = 0; i < menuItems.size(); i++) {
      String item = menuItems.get(i);
      System.out.println(i + " " + item);
    }
  }

  public void addCustomer(ArrayList<String> customers) {
    System.out.println("Please enter your name:");
    String userName = System.console().readLine();
    System.out.println("Hello," + userName);
    System.out.println(
      "there are " + customers.size() + " people in front of you"
    );
    customers.add(userName);
    System.out.println(customers);
  }
}
