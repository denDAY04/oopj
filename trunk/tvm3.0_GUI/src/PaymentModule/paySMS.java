package PaymentModule;
import Interface.UserInterface;

public class paySMS extends Payment
{
    private int cellNumber;
    private String phoneNumber;
    private String confirmationSMS;
    private String confirmSMS;
    private String cancelSMS;
    
    public paySMS()
    {
        
    }
    
    
    public boolean MakePaymentBool()
    {
        return false;
    }
}
