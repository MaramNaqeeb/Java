public class CafeJava {
    public static void main(String[] args) {
        
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        String cindhuriMessage = "Cindhur,you ordered a coffee";
        String samMessage = " Sam, the total price of the 2 latte is 9";
        String jimmyMessage = " Jimmy, I ordered a latte not coffee, so you owe me 4.5$ instead of 2.5$";
        
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double coffee= 2.5;
        double latte= 4.5;
        double cappuccino= 3.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;

        boolean isReadyOrder2 = false;
        if (isReadyOrder2){
            System.out.println("your order is ready");
        }
        else{
            System.out.println("youre order is not ready yet ");
        }

        boolean isReadyOrder3 = false;

        boolean isReadyOrder4 = true;
        if (isReadyOrder4){
            System.out.println("  Noah, your order is ready ");
             System.out.println("Noah,your total is 3.5$");
        }
        else{
            System.out.println(" your order is ready");
           
        }
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); 
        System.out.println(cindhuriMessage);
        System.out.println(samMessage);
        System.out.println(jimmyMessage);
    	// ** Your customer interaction print statements will go here ** //
        

        
    }
}
