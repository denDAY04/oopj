package PaymentModule;
import Interface.UserInterface;

public class CreditCard extends Payment
{
    public CreditCard(UserInterface UI)
    {
        super(UI);
    }
    
    @Override
    public boolean MakePayment(int totalPrice, int language)
    {
