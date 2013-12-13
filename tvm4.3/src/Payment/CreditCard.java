package Payment;

/**
 * Credit card simulation class that extends Payment.
 */
public class CreditCard extends Payment {
    private final String wrongPin;
    
    /**
     * Make a credit card simulation instance. The parameter simulates a
     * pin that will trigger a wrong-pin simulation.
     * @param wrongPin Integer to trigger a failed payment instance.
     */
    public CreditCard(String wrongPin){this.wrongPin = wrongPin;}
    
    /**
     * Simulate a transaction with credit card.
     * @param pin String denoting the entered pin-code
     * @return True if and only if the String is four characters long, it 
     * doesn't equal the wrong pin specified in the constructor, and it only
     * contains integers. False otherwise. 
     */
    public boolean makePaymentBool(String pin) {
        //If pin is too short or too long
        if (pin.length() != 4) return false; 
        //Simulate a wrong pin-instance
        if (pin.equals(wrongPin))   
            return false;
        else {
            try {
                Integer.parseInt(wrongPin);
            } catch (NumberFormatException e) {     // pin contains non-int
                return false;
            }
            return true;    //Simulate correct pin
        }
    }
}
