package PaymentModule;

public class paySMS extends Payment
{
    String failedNUM;

    /**
     * Constructor with a string argument to create a phone number that will 
     * trigger an error-simulation.
     * @param failedNUM String that resembles the phone number which will 
     * trigger the error-simulation.
     */
    public paySMS(String failedNUM)
    {
        this.failedNUM = failedNUM;
    }
    
    
    /**
     * Make a payment transaction with a phone number as the String in the 
     * argument. The String is removed of spaces before being used.
     * @param NUM Phone number to checked. Is a String
     * @return False if length of numbers is not 8. False if it contains
     * non-integer characters. False if it equals the number set in the
     * construcor. True otherwise. 
     */
    public boolean MakePaymentBool(String NUM)
    {
        String NUMWMinusSpaces = "";
        
        // Trim spaces
        for (int i = 0; i < NUM.length(); i++) {
            if (NUM.charAt(i) != ' ') {
                NUMWMinusSpaces += NUM.charAt(i);
            }
        }
        
        // Check if string is 8 characters long
        if (NUMWMinusSpaces.length() != 8) {
            return false;
        }
        
        // Check if string cntains letters
        try {
           Integer.parseInt(NUMWMinusSpaces);
        } catch (NumberFormatException e) { 
           return false;
        }
        
        // Compare to number for forced error-simulation
        if (NUMWMinusSpaces.equals(failedNUM)) {
            return false;
        } else {
            return true;
        }
    }
}
