package PaymentModule;
import Interface.UserInterface;
public class Payment 
{
    UserInterface UI;
    public Payment(UserInterface UI)
    {
        this.UI = UI;
    }
    
    public int paid = 0;
    
    public boolean MakePayment(int totalPrice, int language)
    {
        System.out.println("Error 21 - Running master class, must run sub class.");
        return false;
    }
    
    /*public void CancelPayment(int totalPrice, int language)
    {
        System.out.println("Error 22 - Running master class, must run sub class.");
    }   */ 
}
