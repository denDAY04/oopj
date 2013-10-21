package tvm_project;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Main
{
                     static  Main m;
                     private CreatedTickets cTickets;
                     private Payment Paym;
                     private UserInterface UserInt;
                     private Statistics Stat;
                     private Service Ser;
                     private ShoppingBasket sBasket;

    /**
     * Main program.
     *
     *
     * 
     */
    //Code
    public void Main()
                 {
        

    // Create objects
     cTickets = new CreatedTickets();
     UserInt = new UserInterface();
     Paym = new Payment(UserInt);
     Stat = new Statistics(UserInt); 
     sBasket = new ShoppingBasket(cTickets,Stat);
     Ser = new Service(UserInt,Stat,cTickets,sBasket);   // creates a service module, and supplying refrences to the allready created objects, so it can call methoeds in these.

    // Variabels: 
    
    
    int hardwareID=0;
    
    
       while (cTickets.getArray().isEmpty()) 
           hardwareID = Ser.setup();                    //sets up the machine the first time it is run, and aslong as there are no tickets created.

       while (true){ // loop start
       int language=0;
       int moretickets =1;
       int ticketAmount;
       int amountZones;
       int ticketIndex;
       boolean payed=false;
       UserInt.printLn("Welcome to the BlueJ Trafikselskab");
       UserInt.printLn("Velkommen til BlueJ Trafikselskab");
        
       while (language==1337 || language==0)
       {
       UserInt.setLanguage();                           // shows the lanuage menu
       language = UserInt.getLanguage();                // gets the language variable
       if (language==1337)                              // service menu code
       Ser.menu();    
       }
       while (moretickets==1)
          {
             ticketIndex = UserInt.ticketsMenu(cTickets.getArray());      // shows the menu and lets the user select a ticket
             amountZones = UserInt.getZones();                            // lets the user select a number of zones to buy
             ticketAmount = UserInt.getAmount();                          // lets the user select a number of tickets to buy
             if (UserInt.addToCart()==1)                                  // asks user to confirm adding the tickets to the basket
                {
                sBasket.addToCart(ticketIndex,amountZones,ticketAmount);  // adds a ticket to the shopping cart 
                }
             else
                 break;
             if (!sBasket.getCart().isEmpty())
             moretickets = UserInt.showCart(sBasket.getCart());           // shows the basket and asks user if we wants to add additional tickets to his basket
               
         }
       int saleAccepted=0;
       if (!sBasket.getCart().isEmpty())                                  // if there are items in the shopping cart.
       saleAccepted = UserInt.acceptSale();                               // asks user to confirm the sale
       if (saleAccepted == 1)
       payed = Paym.Pay(sBasket.getTotalPrice(),language);                //sends total price and language to payment module.
       boolean printError = false;
       int returnmoney=0;
       if (payed == true)                                                 // if user payed
       {
           for (int index=0;index<(sBasket.getCart().size());index++)     // run this loop once, for each ticket in the basket.
           {    
             if (sBasket.printTicket(index,language,hardwareID)== false)  // if the printer returns false, its a error during printing.
                {printError = true;}
                if (printError == true)
                   {
                   if (language==1) UserInt.printLn("Fejl ved udskrift af billetter."); 
                   else UserInt.printLn("Error printing tickets.");
                       for (int index2=index;index2<(sBasket.getCart().size());index2++)                 // run through the remaining tickets that did not print
                       {
                       returnmoney = returnmoney + (sBasket.getCart().get(index2).getAmountTickets()) *  // calculate the value of all remainign tickets.
                                                   (sBasket.getCart().get(index2).getPricePerZone() * 
                                                   (sBasket.getCart().get(index2).getZones()));
                       }
                     if (language==1)  UserInt.printLn("Modtag venligst retur " + returnmoney + " kr."); // return the money owed to the costumer. maybe call to finance module?
                     else UserInt.printLn("Please accept return" + returnmoney + " DKK.");
                     sBasket.clearCart();                                                                // clear shopping basket after error.
                     UserInt.printLn("OUT OF ORDER");                                             
                    UserInt.printLn("UDE AF DRIFT");
                    System.exit(0);               
                  }
                else{
                Stat.LogSale(sBasket.getCart().get(index));                 // send the ticket to the statistics module
                }
                if (printError == true) break;                              // break loop here if there was a printing error.
           } 
       }
       sBasket.clearCart();                                                 // clear shopping basket after successful printing
       
       if ((Math.min(Stat.CheckPaper(),Stat.CheckInk()))<10)                 // if paper or ink is low put machine out of order
       {
       UserInt.printLn("OUT OF ORDER");                                             
       UserInt.printLn("UDE AF DRIFT");
       System.exit(0);  
       }
       }
                 
                 
                 }
    
        public static void main(String[] arg)
                     {
        m = new Main();
        m.Main();
        }

    }         
