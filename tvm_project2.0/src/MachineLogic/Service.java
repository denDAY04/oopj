package MachineLogic;

import Interface.UserInterface;

/**
 *   +Service() : void
 *
 *  Module description:   
 *  - Create ticket templates, by using +addTicket(type, zoneprice) method in CreatedTickets
 *  - Change Ink (call ST and use the method +ResetInk()  )
 *  - Add paper   (call ST and use the method +ResetPaper()  )
 *  - Show statistics (call ST and use the method  +ShowStastics()  )
 *  - Log out  (end loop and return control to caller)
 *  
 * @version 1
 */
//test

public class Service

{
    private UserInterface UI;
    private Statistics ST;
    private CreatedTickets CT;
    private ShoppingBasket SB;
       
    public Service(UserInterface UI,Statistics ST,CreatedTickets CT,ShoppingBasket SB)
    {
        this.UI=UI;
        this.ST=ST;
        this.CT=CT;
        this.SB=SB;
    }
    
     /**
     * Service menu method.
     *
     */
    public void menu()
    {
        long startTime = System.currentTimeMillis();
        while(true)
        {
            int valg = UI.serviceMenu(); // call to userinterface

            //            1 : Vis dagsstatistik 
            //            2 : Skift billetrulle 
            //            3 : Skift blækpatron
            //            4 : Udskriv og nulstil salgs statestik 
            //            5 : Sæt ud af drift
            //            6 : Standard service besøg 
            //            7 : Vis total statestik 
            //            0 : Log ud 
                       

            if ((System.currentTimeMillis() - startTime) < (1*60*1000))               // Auto time out
            {

                if (valg==1)   // 1 : Vis dagsstatistik
                {
                    UI.printLn("Antal biletter solgt : "+ST.TicketSoldDay()+" stk.");        
                    UI.printLn("Antal print tilbage : "+Math.min(ST.CheckPaper(),ST.CheckInk())+" stk.");
                    UI.printLn("Omsat for : "+ST.MoneyDay()+" kr.");
                    UI.printLn("Dagens salg:");
                    ST.ShowDayLog();
                }

                if (valg==2)   // 2 : Skift billetrulle
                {
                    UI.printLn("Nulstiller papir variabel... OK.");                          
                    ST.ResetPaper();   
                }

                if (valg==3)  // 3 : Skift blækpatron
                {
                    UI.printLn("Nulstiller blæk variabel... OK.");                           
                  ST.ResetInk();           
                }

                if (valg==4)  // 4 : Udskriv og nulstil salgs statestik"
                {
                  UI.printLn("Dagens salg:");
                  ST.ShowDayLog();
                  UI.printLn("Statistik for dagens salg.");
                  UI.printLn("Omsat for "+ST.MoneyDay()+" kr.");
                  UI.printLn("Solgt "+ST.TicketSoldDay()+" billetter"); 
                  UI.printLn("Nulstiller statestik... OK.");                               
                  ST.ResetDayStatistics();
                }

                if (valg==5) // 5 : Sæt ud af drift
                {
                    UI.printLn("OUT OF ORDER");                                             
                    UI.printLn("UDE AF DRIFT");
                    System.exit(0);                                                                 // Exit program        
                }

                if (valg==6)  // 6 : Standard Service besøg
                {
                    ST.ResetInk();
                    ST.ResetPaper();
                    UI.printLn("Nulstiller forbrugs variable........ OK.");                       
                    ST.ResetDayStatistics();
                    UI.printLn("Nulstiller statestik........... OK.");
                }     
                
                if (valg==7)  // 7 : Vis total statestik
                {
                  UI.printLn("Total salg:");                    
                  UI.printLn("Omsat for "+ST.MoneyTotal()+" kr.");
                  UI.printLn("Solgt "+ST.TicketSoldTotal()+" billetter"); 
                  UI.printLn("Total salg:");
                  ST.ShowLog();
                }                     
                if (valg==8)  // 8 : Udskriv test billetter.
                {
                   
                    for (int n=1; n<CT.getArray().size()+1;n++)                                               // get the array of all possibel tickets
                    {
                     SB.addToCart(n,2,1);       // add one of each ticket to the shopping cart
                     SB.printTicket(0,1,8888);  // prints the ticket from the cart in danish
                     SB.printTicket(0,2,8888);  // prints the ticket from the cart in english
                     ST.testPrint();            // updates the ticket machine variabels.
                     ST.testPrint();
                     SB.clearCart();            // empty the shopping basket.
                    } 

                     
                   
                }                      

                if (valg==0)  //0 : Log ud 
                {  
                    break;
                } 
            }
            else
            {
                UI.printLn("Time Out");
                return;
            }

        }
        
    }
    
    /**
     * Initialize TVM
     *
     * @return
     * @param
     */
    public int setup()
    {
                       
                     UI.printLn("-- Opsæt automaten --"); 
                     int hardwareID = UI.setHardwareID();
                     UI.printLn("Indtast start zone");
                     int z = UI.getInt();
                     while (z == -1) {
                         UI.printLn("Fejl: Ingen heltal fundet. ");
                         UI.printLn("Prøv igen.");
                         z = UI.getInt();
                     } 
                     while(true)
                     {
                         String newtypeDK = UI.setTypeDK();
                         String newtypeEN = UI.setTypeEN();

                         int zp = UI.setZonePrice();
                         CT.addTicket(zp, newtypeDK, newtypeEN, z);
                         UI.printLn("Skal der tilføjes flere billetter ? ");
                         UI.printLn("Tryk '1' for at gemme og afslutte opsætningen.");
                         UI.printLn("Tryk '2' for at tilføje flere billetter."); 
                         int x = UI.getInt();
                         while (x != 1&&x != 2) {
                         UI.printLn("Fejl: forkert indtastning.");
                         UI.printLn("Prøv igen.");
                         x = UI.getInt();
                          }
                        if (x==1) break;
                    }
                                 
           
        return hardwareID;   
        }
    }