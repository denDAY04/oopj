package PaymentModule;
import Interface.UserInterface;

public class Cash extends Payment
{
    public Cash(UserInterface UI)
    {
        super(UI);
    }
    
    @Override
    public boolean MakePayment(int totalPrice, int language)
    {
        if (language == 1)
        {
            UI.printLn("At betale: "+totalPrice+" DKK.");
            UI.printLn("Indkast penge!");
            UI.printLn("Tast 9999 for at annullere købet.");
            while (totalPrice>0)
            {
                paid = UI.getInt(); // check for invalid value
                
                while (paid <= 0) 
                {
                    UI.printLn("Fejl: forkert indtastning. ");
                    UI.printLn("Prøv igen.");
                    paid = UI.getInt();
                } 
                
                if (paid==9999) 
                {   //cancel purchase
                    UI.printLn("Køb afbrudt.");
                    UI.printLn("Modtag venligst dine penge retur.");
                    return false;
                }
                   
                totalPrice -= paid;
                int totalPrice2 = totalPrice;
                if (totalPrice2 <0) totalPrice2 = 0; 
                UI.printLn("Indkastet: "+paid+" DKK, Mangler: "+totalPrice2+" DKK.");
            }
            if (totalPrice<0)
             UI.printLn("Modtag retur: " + (totalPrice*-1)+" Kr.");

            UI.printLn("Betaling gennemført!");
        }
        else if (language == 2)
        {
            UI.printLn("Required payment: "+totalPrice+" DKK.");
            UI.printLn("Insert cash!");
            UI.printLn("Type 9999 to cancel the purchase.");
            while (totalPrice>0)
            {
                paid = UI.getInt();
                 while (paid <= 0) 
                 {
                   UI.printLn("Error invalid input.");
                   UI.printLn("Try again.");
                   paid = UI.getInt();
                 }
                 
                 if (paid==9999) 
                 {
                   UI.printLn("Purchase canceled.");
                   UI.printLn("Please accept your money back.");
                   return false;
                 }

                 totalPrice -= paid;
                 int totalPrice2 = totalPrice;
                 if (totalPrice2 <0) totalPrice2 = 0; 
                 UI.printLn("Inserted: "+paid+" DKK, Remaining: "+totalPrice2+" DKK.");
            }
             if (totalPrice<0)
             UI.printLn("Accept return: " + (totalPrice*-1)+" DKK");

            UI.printLn("Payment completed!");
        }
        return true;
    }
}
