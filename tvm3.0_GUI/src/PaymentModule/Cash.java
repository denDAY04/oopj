package PaymentModule;

public class Cash extends Payment
{
    int moneyNeeded = 0;
    int totalInsertedMoney = 0;
    
    /**
     * Constructor. Stores the total price in a field variable.
     * @param totalPrice The total price that needs to be paid.
     */
    public Cash(int totalPrice)
    {
        this.moneyNeeded = totalPrice;
    }
    
    /**
     * Is empty and should not be used.
     * @return False at all time due to empty body.
     */
    public boolean MakePaymentBool() {
        return false;
    }
    
    /**
     * Subtracts the parameter int from the price needed to be paid.
     * @param insertedMoney The number in integer to be subtracted.
     * @return The new value of the money needed to be paid.
     */
    public int MakePaymentInt(int insertedMoney) {
        totalInsertedMoney += insertedMoney; 
        moneyNeeded -= insertedMoney;
        return moneyNeeded;
    }
    
    /**
     * Get the total amount of money inserted.
     * @return Integer.
     */
    public int getInsertedMoney() {
        return totalInsertedMoney;
    }
}
    
   