package MachineLogic;

public class Printer 
{
    //Creates a new instance of the object UseGraphicalTicket named test
     UseGraphicalTicket useGTicket;
    /**
    * Printing method to simulate printing hardware.
    */
    public boolean print(String type, String typeENG, String startZone, String amountZones, 
                                   String amountTickets, String totalPrice, 
                           String timeStamp, String ticketID, int language)
    {
        useGTicket = new UseGraphicalTicket();
        if (language == 1)
        {
            System.out.println("###############################");
            System.out.println("#-----BlueJ Trafikselskab-----#");
            System.out.println("#            Billet           #");
            System.out.println("#                             #");
            System.out.println("# Type:       "+amountTickets+type+"    #");
            System.out.println("#                             #");
            System.out.println("# Fra zone:   "+startZone+"            #");
            System.out.println("#                             #");
            System.out.println("# Antal zoner:"+amountZones+"            #");
            System.out.println("#                             #");
            System.out.println("#                             #");
            System.out.println("#        "+totalPrice+ " DKK         #");
            System.out.println("#                             #");
            System.out.println("#                             #");
            System.out.println("#          "+timeStamp+"   #");
            System.out.println("#                             #");
            System.out.println("#    Gyldig 2 timer fra køb   #");
            System.out.println("#                             #");
            System.out.println("# >>"+ticketID+"<<          #");
            System.out.println("###############################");
            System.out.println();
        }
        else if (language == 2)
        {
            System.out.println("###############################");
            System.out.println("#-----BlueJ Trafikselskab-----#");
            System.out.println("#            Ticket           #");
            System.out.println("#                             #");
            System.out.println("# Type:         "+amountTickets+typeENG+"  #");
            System.out.println("#                             #");
            System.out.println("# From zone:    "+startZone+"          #");
            System.out.println("#                             #");
            System.out.println("# Amount zones: "+amountZones+"          #");
            System.out.println("#                             #");
            System.out.println("#                             #");
            System.out.println("#        "+totalPrice+ " DKK         #");
            System.out.println("#                             #");
            System.out.println("#                             #");
            System.out.println("#          "+timeStamp+"   #");
            System.out.println("#                             #");
            System.out.println("# Valid 2 hours from purchase #");
            System.out.println("#                             #");
            System.out.println("# >>"+ticketID+"<<          #");
            System.out.println("###############################");
            System.out.println();

        }
       
        
        /*Calls the printTicket(); method on the object test, which should
          show a ticket on the screen*/
        useGTicket.printTicket(type, typeENG, amountTickets, startZone, amountZones, totalPrice, timeStamp, ticketID,language);
        
        
        return true;  // can test printer error

        
        
        
    }
    
}
