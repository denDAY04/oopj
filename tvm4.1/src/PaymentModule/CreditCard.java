package PaymentModule;

public class CreditCard extends Payment
{
    private int pinCode;
    private String wrongPin;
    
    /**
     * Make a credit card simulation instance. The parameter simulates a
     * pin that will trigger a wrong-pin simulation.
     * @param wrontPin Integer to trigger a failed payment instance.
     */
    public CreditCard(String wrongPin)
    {
        this.wrongPin = wrongPin;
    }
    
    
    public boolean MakePaymentBool(String pin)
    {
        if (pin.length() != 4) {     //If pin is too short or too long
            return false;
        } 
        
        if (pin.equals(wrongPin)) {  //Simulate a wrong pin-instance
            return false;
        } else {
            try {
                Integer.parseInt(wrongPin);
            } catch (NumberFormatException e) {     // pin contains non-int
                return false;
            }
            return true;    //Simulate correct pin
        }
    }
}
