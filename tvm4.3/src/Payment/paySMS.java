package Payment;

/**
 * SMS simulation class that extends Payment.
 */
public class paySMS extends Payment {
    private final String failedNUM; //Invalid phone number

    /**
     * Constructor with a String argument to create a phone number that will 
     * trigger an error-simulation.
     * @param failedNUM String that resembles the phone number which will 
     * trigger the error-simulation.
     */
    public paySMS(String failedNUM) {this.failedNUM = failedNUM;} 
    
    /**
     * Make a payment transaction with a phone number as the String in the 
     * argument. The String is removed of spaces before being used.
     * @param NUM String representing Phone number to be checked.
     * @return False if length of numbers is not 8. False if it contains
     * non-integer characters. False if it equals the number set in the
     * constructor. True otherwise. 
     */
    public boolean makePaymentBool(String NUM) {
        // Variable to hold modified NUM-String
        String NUMMinusSpaces = "";
        // Trim spaces inside of String
        for (int i = 0; i < NUM.length(); i++) {
            if (NUM.charAt(i) != ' ') {
                NUMMinusSpaces += NUM.charAt(i);
            }
        }
        // Check if string is 8 characters long
        if (NUMMinusSpaces.length() != 8) {
            return false;
        }
        // Check if string cntains letters
        try {
           Integer.parseInt(NUMMinusSpaces);
        } catch (NumberFormatException e) { 
           return false;
        }
        // Compare to number for forced error-simulation
        if (NUMMinusSpaces.equals(failedNUM)) {
            return false;
        } else {
            return true;
        }
    }
}