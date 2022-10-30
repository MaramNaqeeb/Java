public class CafeJava {
    public static void main(String[] args) {
        
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = " Your total is $";
        String cindhuriMessage = " ,you ordered a coffee";
        String samMessage = " ,the total price of the latte is ";
        String jimmyMessage = " ,I ordered a latte not coffee, so you owe me ";
        
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double coffeePrice= 2.5;
        double lattePrice= 4.5;
        double cappuccinoPrice= 3.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;

        boolean isReadyOrder2 = false;
        if (isReadyOrder2){
            System.out.println(customer2 + readyMessage);
        }
        else{
            System.out.println(customer2 + pendingMessage);
        }

        boolean isReadyOrder3 = false;

        boolean isReadyOrder4 = true;
        if (isReadyOrder4){
            System.out.println( customer4+ readyMessage);
            System.out.println (customer4+displayTotalMessage+cappuccinoPrice);
        }
        else{
            System.out.println( customer4+pendingMessage);
           
        }
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); 
        System.out.println(customer1 +cindhuriMessage);
        System.out.println(customer2+samMessage+(lattePrice+lattePrice));
        System.out.println(customer3+ jimmyMessage+ (lattePrice-coffeePrice));
    	// ** Your customer interaction print statements will go here ** //
        

        
    }
}
