import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * The pizzaShop class instantiats an object which is responsible for handling
 * the overall business logic of the pizza shop like asking user for pizza size,
 * topings, client information etc
 */
public class PizzaShop {

    /**
     * Contains the main logic of the program, it displays welcome message, take the
     * pizza order, provides input for delivery option, checks if delivery charges
     * has to be set or not, takes the client information and finally prints the
     * order information
     */
    public void runPizzaShop() {
        menuDisplay.displayWelcomeMessage();
        makePizzaOrder();
        System.out.println("Do you want the pizza to be collected or to be delivered? please select");
        menuDisplay.displayDeliveryOptions();
        selectDeliveryOption();
        Client newClient = getCustomerInfo(order.getDeliveryInfo());
        // Check if bill amount exceeds 30 dollar or not
        if (order.getBillAmount() < 30) {
            order.setDeliveryCharge(8);
        }
        order.displayOrderInfo(newClient);
        sc.close();
        System.out.println("Thanks for using our service");
    }

    /**
     * Checks if the delivery has to be made or not
     */
    private void selectDeliveryOption() {
        String choice = sc.nextLine();
        int num_choice = -99;
        try {
            num_choice = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
        }
        while (num_choice < 0 || num_choice > 1) {
            System.out.println("Select the appropriate value from the following");
            menuDisplay.displayDeliveryOptions();
            System.out.println("Enter your choice");
            choice = sc.nextLine();
            try {
                num_choice = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
            }
        }
        if (num_choice == 1) {
            order.setDeliveryInfo(false);
        }
    }

    /**
     * Takes pizza orders as desired by the client if he/she continues to order the
     * pizza
     */
    private void makePizzaOrder() {
        System.out.println("Enter the pizza requirements\n");
        System.out.println("*******************************************************************");
        while (true) {
            System.out.println("*******************************************************************");
            System.out.println("Requirements for pizza -" + (order.getPizzaOrderCount() + 1));
            System.out.println("Type the number corresponding to size , for example, type 0 for small");
            System.out.println("*******************************************************************");
            menuDisplay.displaySizeOptions();
            System.out.println("Enter your choice");
            String choice = sc.nextLine();
            int num_choice = -99;
            try {
                num_choice = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
            }
            while (num_choice < 0 || num_choice > sizeMap.size() - 1) {
                System.out.println("Select the appropriate value from the following");
                menuDisplay.displaySizeOptions();
                System.out.println("Enter your choice");
                choice = sc.nextLine();
                try {
                    num_choice = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                }
            }
            Pizza orderedPizza = new Pizza(sizeMap.get(num_choice));

            System.out.println(
                    "Enter the number corresponding to the topings,You can add topings up to 4, Press --noToping-- if you want to cancel the topings");
            orderedPizza = addTopingsInformation(orderedPizza);
            order.addPizza(orderedPizza);
            System.out.println("Do you Still want to continue ordering Pizza ?");
            menuDisplay.displayContinueOptions();
            System.out.println("Enter your choice");
            choice = sc.nextLine();
            if (!choice.equals("0"))
                break;
        }
        System.out.println("*******************************************************************");
    }

    /**
     * Adds the topings as selected by the client on the pizxa
     * 
     * @param orderedPizza the pizza whose topings has to be added
     * @return the pizza after the toping has been added
     */
    private Pizza addTopingsInformation(Pizza orderedPizza) {
        int num_choice = -99;
        while (true) {
            if (orderedPizza.getAdditionalTopingsCount() >= 4) {
                System.out.println("You Cannot add additional topings more than 4");
                System.out.println("*******************************************************************");
                break;
            }
            System.out.println("Please make selection from the following");
            menuDisplay.displayTopingOptions();
            String choice = sc.nextLine();
            num_choice = -99;
            try {
                num_choice = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
            }
            while (num_choice < 0 || num_choice > topingsMap.size()) {
                System.out.println("Select the appropriate value from the following");
                menuDisplay.displayTopingOptions();
                System.out.println("Enter your choice");
                choice = sc.nextLine();
                try {
                    num_choice = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                }
            }
            // this is the selection value of notopings
            if (num_choice == exitTopingSelection) {
                System.out.println("Ending the topings order");
                System.out.println("*******************************************************************");
                break;
            }
            System.out.println("You have added " + topingsMap.get(num_choice));
            orderedPizza.addTopings(topingsMap.get(num_choice));
        }
        return orderedPizza;
    }

    /**
     * Gets the customer information such as name, phone number and address
     * 
     * @param isPizzaToBeDelivered Boolean value to see if the delivery is required.
     *                             if false, no address is asked
     * @return Client object consisting of the user information
     */
    private Client getCustomerInfo(boolean isPizzaToBeDelivered) {
        System.out.println("Enter Your name- ");
        String name = sc.nextLine();
        while (!Validators.validateName(name)) {
            System.out.println("Please Enter Valid Name- ");
            name = sc.nextLine();
        }

        System.out.println("Enter your phone Number - ");
        String phoneNumber = sc.nextLine();
        while (!Validators.validatePhone(phoneNumber)) {
            System.out.println("Please Enter Valid PhoneNumber");
            phoneNumber = sc.nextLine();
        }

        String address = " ";
        if (isPizzaToBeDelivered) {
            System.out.println("Enter your Address");
            address = sc.nextLine();
            while (!Validators.validateAddress(address)) {
                System.out.println("Please Enter Valid Addresss- ");
                name = sc.nextLine();
            }
        }
        return new Client(name, phoneNumber, address);

    }

    /**
     * HashMap to represent the available pizza topings on the shop
     * 
     * @return topings map consiting of the string value of the available topings
     */
    private Map<Integer, String> availableTopings() {
        Map<Integer, String> topingsMap = new HashMap<Integer, String>();
        topingsMap.put(Integer.valueOf(0), "Bacon");
        topingsMap.put(Integer.valueOf(1), "Olives");
        topingsMap.put(Integer.valueOf(2), "Ham");
        topingsMap.put(Integer.valueOf(3), "Mushrooms");
        topingsMap.put(Integer.valueOf(4), "Pineapple");
        topingsMap.put(Integer.valueOf(5), "Salami");
        topingsMap.put(Integer.valueOf(6), "Anchovies");
        return topingsMap;
    }

    /**
     * HashMap to represent the available pizza sizes of the shop
     * 
     * @return size map consisting of the string value of the available pizza sizes
     */
    private Map<Integer, String> availablePizzaSize() {
        Map<Integer, String> pizzaSizeMap = new HashMap<Integer, String>();
        pizzaSizeMap.put(Integer.valueOf(0), "small");
        pizzaSizeMap.put(Integer.valueOf(1), "medium");
        pizzaSizeMap.put(Integer.valueOf(2), "large");
        return pizzaSizeMap;
    }

    /* Private instance variables */
    Order order = new Order(); /* instance of a single order */
    MessageDisplays menuDisplay = new MessageDisplays(); /* instance of menu display to present the messages */
    Scanner sc = new Scanner(System.in); /* scanner class to take input from user */
    Map<Integer, String> sizeMap = availablePizzaSize(); /* hashmap associating number with the size */
    Map<Integer, String> topingsMap = availableTopings(); /* hashmap associating number with the topings */
    final int exitTopingSelection = 7;
}
