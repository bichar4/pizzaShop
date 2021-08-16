import java.util.List;
import java.util.ArrayList;

/**
 * The pizza class keeps track of the following pieces of data about the pizza:
 * the pizza size, added toppings and the pizza cost.The price of the pizza
 * increses propotional to the size and the number of the toppings added on the
 * pizza. Small pizzas cost $5, medium pizzas cost $8 and large pizzas cost
 * $12.each topping adds an additional $1 to the price of the pizza
 */
public class Pizza {
	/**
	 * Creates a new pizza object with the specified size
	 * 
	 * @param size the size of the pizza as string, available sizes are small,medium
	 *             and large
	 */
	public Pizza(String size) {
		this.pizzaCost = 0;
		this.pizzaSize = size;
		switch (size) {
			case "small":
				addPizzaCost(5);
				break;
			case "medium":
				addPizzaCost(8);
				break;
			case "large":
				addPizzaCost(12);
				break;
			default:
				addPizzaCost(0);
		}
	}

	/**
	 * Gets the total cost of the pizza
	 * 
	 * @return the cost of the pizza
	 */
	public int getPizzaCost() {
		return this.pizzaCost;
	}

	/**
	 * Adds the additional cost to the pizza
	 * 
	 * @param price the price to be added to pizza
	 */
	private void addPizzaCost(int price) {
		this.pizzaCost += price;
	}

	/**
	 * Gets the size of the pizza
	 * 
	 * @return the pizza size in string, Options are small, medium and large
	 */
	public String getSize() {
		return this.pizzaSize;
	}

	/**
	 * Gets the total number of additional number of topings added on the pizza
	 * 
	 * @return the additional topings added to pizza
	 */
	public int getAdditionalTopingsCount() {
		return this.topings.size();
	}

	/**
	 * Adds the topings to the pizza
	 * 
	 * @param topings the topings to be added as string
	 */
	public void addTopings(String topings) {
		this.topings.add(topings);
		addPizzaCost(1);
	}

	/**
	 * Simply displays the added topings on the pizza as string
	 * 
	 * @return Additional topings on string.
	 */
	public String getTopingsAsString() {
		String topings = "Cheese"; // default topings for all the pizzas
		for (int i = 0; i < getAdditionalTopingsCount(); i++) {
			topings += ", ";
			topings += this.topings.get(i);
		}
		return topings;
	}

	/**
	 * Displays the overall information of the pizza regarding its size,topings and
	 * cost
	 */
	public void displayPizzaInfo() {
		System.out.println("Size of Pizza: " + getSize());
		System.out.println("Added Topings are: " + getTopingsAsString());
		System.out.println("Total Additional Topings count: " + getAdditionalTopingsCount());
		System.out.println("Pizza Charge: " + getPizzaCost());
	}

	/* Private instance variables */
	private int pizzaCost; /* Total cost of the individual pizza */
	private String pizzaSize; /* The size of the pizza */
	private List<String> topings = new ArrayList<>(); /* List containing the topings on the pizza */

}
