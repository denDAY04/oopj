package PaymentModule;
import Interface.UserInterface;

public class CreditCard extends Payment
{
    //test
    private int pinCode;
    private String cardPinCode;
    
    public CreditCard(UserInterface UI)
    {
        super(UI);
    }
    
    @Override
    public boolean MakePayment(int totalPrice, int language)
    {
        if (language == 1)
        {
            UI.printLn("At betale: "+totalPrice+" DKK");
            UI.printLn("Indsæt betalingskort og indtast PIN-kode.");
            UI.printLn("Tast 99999 for at annullere købet.");
            
            pinCode = UI.getInt(); // check for invalid value
            cardPinCode = ((Integer) pinCode).toString();

            while (cardPinCode.length() != 4)
            {
                UI.printLn("Fejl: Forkert PIN-kode.");
                UI.printLn("Prøv igen.");
                pinCode = UI.getInt();
                cardPinCode = ((Integer) pinCode).toString();
            }

            if (pinCode==99999) 
            {   //cancel purchase
                UI.printLn("Køb afbrudt.");
                return false;
            }
            
            UI.printLn("Venter på godkendelse...");
            
            try 
            {
                Thread.sleep(4000);
            }
            catch(InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }

            UI.printLn("Betaling gennemført!");
        }
        else if (language == 2)
        {
            UI.printLn("Required payment: "+totalPrice+" DKK");
            UI.printLn("Insert Creditcard and enter PIN-code.");
            UI.printLn("Press 99999 to cancel the purchase.");
            
            pinCode = UI.getInt(); // check for invalid value
            cardPinCode = ((Integer) pinCode).toString();

            while (cardPinCode.length() != 4)
            {
                UI.printLn("Error: Wrong PIN-code.");
                UI.printLn("Try again.");
                pinCode = UI.getInt();
                cardPinCode = ((Integer) pinCode).toString();
            }

            if (pinCode==99999) 
            {   //cancel purchase
                UI.printLn("Purchase canceled.");
                return false;
            }
            
            UI.printLn("Waiting for confirmation...");
            
            try 
            {
                Thread.sleep(4000);
            }
            catch(InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }

            UI.printLn("Purchase completed!");
        }
        return true;
    }
}
