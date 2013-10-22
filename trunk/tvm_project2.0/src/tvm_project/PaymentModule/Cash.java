package tvm_project.PaymentModule;
import tvm_project.UserInterface;

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
            UI.printLn("At betale: "+totalPrice+" DKK");
            UI.printLn("Indkast penge!");
            UI.printLn("Tast 9999 for at annullere købet");
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
                    UI.printLn("Køb afbrudt");
                    UI.printLn("Modtag venligst dine penge retur");
                    return false;
                }
                   
                totalPrice -= paid;
                UI.printLn("Indkastet: "+paid+" DKK, Mangler: "+totalPrice+" DKK");
            }
            
            UI.printLn("Betaling gennemført!");
        }
        else if (language == 2)
        {
            UI.printLn("Required payment: "+totalPrice+" DKK");
            UI.printLn("Insert cash!");
            UI.printLn("Type 9999 to cancel purchase.");
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
                   UI.printLn("Purchase canceled");
                   UI.printLn("Please accept your money back");
                   return false;
                 }

                 totalPrice -= paid;
                 UI.printLn("Inserted: "+paid+" DKK, Remaining: "+totalPrice+" DKK");
            }
            UI.printLn("Payment completed!");
        }
        return true;
    }
}
