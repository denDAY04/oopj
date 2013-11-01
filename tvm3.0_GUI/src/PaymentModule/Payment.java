package PaymentModule;
import Interface.UserInterface;
public class Payment 
{
    UserInterface UI;
    public Payment(UserInterface UI)
    {
        this.UI = UI;
    }
    
    protected int paid = 0;
    
    public boolean MakePayment(int totalPrice, int language)
    {
        System.err.println("Error 21 - Running master class, must run sub class.");
        return false;
    }
    
}
