package PaymentModule;

/**
 * Cash simulation class that extends Payment.
 */
public class Cash extends Payment {
    int moneyNeeded = 0;
    int totalInsertedMoney = 0;
    
    /**
     * Constructor. Stores the total price in a field variable.
     * @param totalPrice The total price that needs to be paid.
     */
    public Cash(int totalPrice) {this.moneyNeeded = totalPrice;}
    
    /**
     * Is empty and should not be used.
     * @return False at all time due to empty body.
     */
    public boolean MakePaymentBool() {
        System.err.println("Warning! This method call is not costumized and"
                + "only returns false!");
        return false;
    }
    
    /**
     * Subtracts the parameter int from the price needed to be paid.
     * Negative values are converted to positive. 
     * @param insertedMoney The number in integer to be subtracted.
     * @return The new value of money needed to be paid.
     */
    public int MakePaymentInt(int insertedMoney) {
        // If negative value, convert to positive
        if (insertedMoney < 0) 
            insertedMoney *= -1;
        // Update variables
        totalInsertedMoney += insertedMoney; 
        return moneyNeeded -= insertedMoney;
    }
    
    /**
     * Accessor method.
     * @return An int denoting the total amount of money inserted.
     */
    public int getInsertedMoney() {return totalInsertedMoney;}
}
    
   