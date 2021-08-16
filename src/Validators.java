import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The validator class contains bunch of static members that are used for string
 * validation purpose
 */
public class Validators {

    /**
     * This method checks if the phone number is valid or not
     * 
     * @param phoneString phone number provided by user in string
     * @return if valid returns true
     */
    public static boolean validatePhone(String phoneString) {
        String regex = "^\\+?[0-9. ()-]{10,25}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneString);
        boolean isValid = matcher.matches();
        return isValid;
    }

    /**
     * This method checks if name is valid or not. current implementation only
     * checks if the length of the name is greater than 3 or not
     * 
     * @param nameString name provided by the user in string
     * @return if valid returns true
     */
    public static boolean validateName(String nameString) {
        boolean isValid = (nameString.length() >= 3);
        return isValid;
    }

    /**
     * This method checks if address is valid or not.Current implementation only
     * checks if the length of the name is greater than 3 or not
     * 
     * @param addressString address provided by the user in string
     * @return if valid returns true
     */
    public static boolean validateAddress(String addressString) {
        boolean isValid = (addressString.length() >= 3);
        return isValid;
    }

}
