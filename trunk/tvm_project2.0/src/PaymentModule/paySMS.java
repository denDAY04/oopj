package PaymentModule;
import Interface.UserInterface;

public class paySMS extends Payment
{
    private int cellNumber;
    private String phoneNumber;
    private String confirmationSMS;
    private String confirmSMS;
    private String cancelSMS;
    
    public paySMS(UserInterface UI)
    {
        super(UI);
    }
    
    @Override
    public boolean MakePayment(int totalPrice, int language)
    {
        if (language == 1)
        {
            UI.printLn("At betale: "+totalPrice+" DKK");
            UI.printLn("Venligst indtast dit telefonnummer.");
            UI.printLn("Tast 99999 for at annullere købet.");
            
            cellNumber = UI.getInt(); // check for invalid value
            phoneNumber = ((Integer) cellNumber).toString();

            while (phoneNumber.length() != 8)
            {
                UI.printLn("Fejl: Ikke et gyldigt telefonnummer.");
                UI.printLn("Prøv igen.");
                cellNumber = UI.getInt();
                phoneNumber = ((Integer) cellNumber).toString();
            }

            if (cellNumber==9999) 
            {   //cancel purchase
                UI.printLn("Køb afbrudt.");
                return false;
            }
            
            UI.printLn("Sender ordrebekræftelse...");
            
            try 
            {
                Thread.sleep(4000);
            }
            catch(InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
            
            UI.printLn("##################ORDREBEKRÆFTELSE##################");
            UI.printLn("Besvar med teksten JA, for at bekræfte køb af billet");
            UI.printLn("eller besvar med teksten NEJ, for at annulere købet.");
            
            confirmationSMS = UI.getString();
            confirmSMS = "JA";
            cancelSMS = "NEJ";
            
            while (!(confirmSMS.equals(confirmationSMS) || cancelSMS.equals(confirmationSMS)))
            {
                //test
                UI.printLn("Fejl: Ikke et gyldigt svar.");
                UI.printLn("Besvar beskeden med enten JA eller NEJ.");
                confirmationSMS = UI.getString();
            }
            
            if (confirmationSMS.equals(confirmSMS))
            {
                UI.printLn("Betaling gennemført!");                 
            }
            else if (confirmationSMS.equals(cancelSMS))
            {
                UI.printLn("Køb afbrudt.");
            }
        }
        else if (language == 2)
        {
            UI.printLn("Payment required: "+totalPrice+" DKK");
            UI.printLn("Please enter your phonenumber.");
            UI.printLn("Press 9999 to cancel the purchase.");
            
            cellNumber = UI.getInt(); // check for invalid value
            phoneNumber = ((Integer) cellNumber).toString();

            while (phoneNumber.length() != 8)
            {
                UI.printLn("Error: Not a valid phonenumber.");
                UI.printLn("Try again.");
                cellNumber = UI.getInt();
                phoneNumber = ((Integer) cellNumber).toString();
            }

            if (cellNumber==9999) 
            {   //cancel purchase
                UI.printLn("Purchase canceled.");
                return false;
            }
            
            UI.printLn("Sending orderconfirmation...");
            
            try 
            {
                Thread.sleep(4000);
            }
            catch(InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
            
            UI.printLn("####################ORDERCONFIRMATION###################");
            UI.printLn("Respond with the text YES, to confirm purchase of ticket");
            UI.printLn("or respond with the text NO, to cancel purchase.");
            
            confirmationSMS = UI.getString();
            
            while (!"YES".equals(confirmationSMS) || !"NO".equals(confirmationSMS))
            {
                UI.printLn("Error: Not a valid response.");
                UI.printLn("Respond with either YES or NO.");
                confirmationSMS = UI.getString();
            }
            
            if (confirmationSMS.equals("JA"))
            {
                UI.printLn("Purchase completed!");
            }
        }
        return true;
    }
}
