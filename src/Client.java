/**
 * The Client class keeps track of the following pieces of data about the
 * client: The client's name, phone number and the address of the client.All of
 * the method is entirely private to the class and getter methods are provided
 * to get the required piece of the information.
 */
public class Client {

    /**
     * Creates a new client with the specified name,phone number and address
     * 
     * @param name        The client's name as in string
     * @param phoneNumber The client's phone number as in string
     * @param address     The client's address as in string
     */
    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Gets the name of the client
     * 
     * @return The name of this client
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the phonenumber of this client
     * 
     * @return The phone number of this client
     */
    public String getPhone() {
        return this.phoneNumber;
    }

    /**
     * Gets the address of this client
     * 
     * @return The address of this client
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Prints the detail of the client
     * 
     * @param printDeliveryAddress if provided as boolean, the address if the client
     *                             gets printed, else no address is printed
     */
    public void printDetails(boolean printDeliveryAddress) {
        System.out.println("Name of Client: " + getName());
        System.out.println("Contact Number : " + getPhone());
        if (printDeliveryAddress) {
            System.out.println("Delivery Address: " + getAddress());
            System.out.println("Delivery Type : To be delivered");
        } else {
            System.out.println("Delivery Address: Not Provided");
            System.out.println("Delivery Type : To be collected");
        }

    }

    /* Private instance variables */
    private String name; /* The client's name */
    private String phoneNumber; /* The client's phonenumber */
    private String address; /* The client's address */

}
