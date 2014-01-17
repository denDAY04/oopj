package Payment;

/**
 * Interface class used as superclass for inheritance and polymorphing 
 * with payment simulations
 */
public interface Payment {
    // Interface method calls
    public boolean makePaymentBool(String s);
    public int makePaymentInt(int insertedMoney);
    public int getInsertedMoney();
    
}
