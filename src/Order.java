import java.util.List;
import java.util.ArrayList;

/**
 * The Order class keeps track of the multiple pizza orders, delivery info and
 * total bill amount to be paid. It also has responsibility of displaying the
 * order info made by specific client
 */
public class Order {
	/**
	 * Initializes the order where the bill amount and delivery charge is
	 * initialized to be zero and the default value for to be delivered is true
	 */
	public Order() {
		this.billAmount = 0;
		this.deliveryCharge = 0;
		this.tobeDelivered = true;
	}

	/**
	 * Updates the delivery status, if false then no home delivery as client wishes
	 * to collect the order
	 * 
	 * @param value Boolean value representing if the delivery has to be made
	 */
	public void setDeliveryInfo(boolean value) {
		this.tobeDelivered = value;
	}

	/**
	 * sets the delivery charge if required
	 * 
	 * @param amount The extra delivery fee
	 */
	public void setDeliveryCharge(int amount) {
		this.deliveryCharge += amount;
	}

	/**
	 * Gets the delivery info if the order is to be delivered or to be collected
	 */
	public boolean getDeliveryInfo() {
		return this.tobeDelivered;
	}

	/**
	 * Get the total number of pizza that has been ordered
	 * 
	 * @return returns the total number of the pizza ordered in integer
	 */
	public int getPizzaOrderCount() {
		return this.pizzaOrder.size();
	}

	/**
	 * Adds the pizza to the order list
	 * 
	 * @param orderedPizza New pizza object whose order has been made
	 */
	public void addPizza(Pizza orderedPizza) {
		this.pizzaOrder.add(orderedPizza);
		this.billAmount += orderedPizza.getPizzaCost();
	}

	/**
	 * Get the total bill amount created by the pizza
	 * 
	 * @return pizza bill amount as in integer
	 */
	public int getBillAmount() {
		return this.billAmount;
	}

	/**
	 * Displays the order information purchased by the client
	 * 
	 * @param client Client object who has made an order
	 */
	public void displayOrderInfo(Client client) {
		System.out.println("********************************************");
		System.out.println("Printing Order Info");
		System.out.println("********************************************");
		client.printDetails(getDeliveryInfo());
		System.out.println("Total Pizza Ordered : " + getPizzaOrderCount());
		for (int i = 0; i < this.pizzaOrder.size(); i++) {
			System.out.println("*******************************************************************************");
			System.out.println("Pizza Info for Pizza No " + (i + 1));
			this.pizzaOrder.get(i).displayPizzaInfo();
		}
		System.out.println("*******************************************************************************");
		System.out.println("*******************************************************************************");
		System.out.println("Total Pizza Charge : " + this.billAmount);
		System.out.println("Delivery Charge :" + this.deliveryCharge);
		System.out.println("Total Charge :  " + (this.billAmount + this.deliveryCharge));
	}

	/* Private instance variables */
	private int billAmount; /* Total Bill amount that has been created by pizza */
	private int deliveryCharge; /* Optional delivery charge fee seperated from bill amount */
	private boolean tobeDelivered; /* Option whether client wants home delivery or client wants to pick up */
	private List<Pizza> pizzaOrder = new ArrayList<>(); /* List of pizza client orders */
}
