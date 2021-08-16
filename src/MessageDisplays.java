/**
 * The MessageDisplays class contains bunch of the messages to be displayed
 * during the execution of the program.y It overall contains the menus and
 * buttons for the client.
 */
public class MessageDisplays {
	/**
	 * Displays the welcome message to the client
	 */
	public void displayWelcomeMessage() {
		System.out.println("*******************************************************************************");
		System.out.println("Welcome to pizza order delivery System");
		System.out.println("*******************************************************************************");
	}

	/**
	 * Displays the available size options available to the client
	 */
	public void displaySizeOptions() {
		System.out.println("0>Small \t 1> Medium  \t 2>Large");
	}

	/**
	 * Displays the available topings options available to the client
	 */
	public void displayTopingOptions() {
		System.out.println("0> Bacon \t 1> Olives \t 2>Ham \t 3>Mushrooms");
		System.out.println("4> Pineapple \t 5>Salami \t 6>Anchovies \t 7>noToping ");
	}

	/**
	 * Displays the option if the client wants to continue ordering more pizzas
	 */
	public void displayContinueOptions() {
		System.out.println("0>Yes (anything_else)>No");
	}

	/**
	 * Displays the option if the pizza needs to be collected or it is to be
	 * delivered
	 */
	public void displayDeliveryOptions() {
		System.out.println("0>To be Delivered \t 1>To be Collected");
	}
}
