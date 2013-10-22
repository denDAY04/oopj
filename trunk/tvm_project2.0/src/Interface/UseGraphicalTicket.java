package Interface;
import MachineLogic.*;
import javax.swing.*;               //Importing the required classes
public class UseGraphicalTicket 
//test
{
    GraphicalTicket gticket;
    
    //Adding a constructor for UseGraphicalTicket
    public UseGraphicalTicket()
    {
        
    }
    
    //This is the method call to use in the main order to print a ticket     
    public void printTicket(String type,String typeENG, String amountTickets, String startZone, String amountZones, String totalPrice ,String timeStamp,String ticketID,int language)
    {
        JFrame frame = new JFrame("BlueJ Trafikselskab"); //Creates a new frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,570);

        //Creates a new instance of the object GraphicalTicket to use
        gticket = new GraphicalTicket(type,typeENG, amountTickets, startZone, amountZones, totalPrice ,timeStamp, ticketID, language);
        frame.setContentPane(gticket); 
        frame.setVisible(true); 
    }
}
