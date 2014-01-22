package Payment;

/**
 * Abstract class used as superclass for inheritance and polymorphing 
 * for payment simulation modules. All methods are abstract. 
 */
public abstract class Payment {
    // Abstract methods for inheritance
    public abstract boolean makePaymentBool(String s);
    public abstract int makePaymentInt(int insertedMoney);
    public abstract int getInsertedMoney();
    
}
