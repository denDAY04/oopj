package MachineLogic;
import java.awt.*;      //Importing the required classes for this program
import javax.swing.*;

public class GraphicalTicket extends JPanel
{
  //Declaration of the various variables used
  Image image; //Image variable to store the background image
  String type; //Rest is ticket variables
  String amountTickets;
  String startZone;
  String amountZones;
  String totalPrice;
  String timeStamp;
  String ticketID;
  String typeENG;
  int language;
  
  //Class responsible of loading up the image

    /**
     * @param type
     * @param amountTickets
     * @param startZone
     * @param amountZones
     * @param totalPrice
     * @param timeStamp
     * @param ticketID
     * @param language
     * @param typeENG
     */
    public GraphicalTicket(String type,String typeENG, String amountTickets, String startZone, String amountZones, String totalPrice ,String timeStamp,String ticketID,int language)
  {
    super();
    image = Toolkit.getDefaultToolkit().getImage("background.png");
    this.type=type;
    this.amountTickets=amountTickets;
    this.startZone=startZone;
    this.amountZones=amountZones;
    this.totalPrice=totalPrice;
    this.timeStamp=timeStamp;    
    this.ticketID=ticketID;
    this.language=language;
    this.typeENG=typeENG;
        
    
    //Image MUST be placed in the root projectfolder, not under src!
  }
  //Class responsible of painting text on top of the image

    /**
     * @param g
     */
    @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    //Paints the image onto the pane
    g.drawImage(image,0,0,400,533, this);
    
    //Setting the desired font for the text following
    Font ticketFont = new Font("Calibri", Font.BOLD, 18);
    g.setFont(ticketFont);
    
    //Text painted on the ticket with the font ticketFont
    /*the 2 numbers at the end like ...type, 75, 135); are X and Y 
      coordinates for the first letter of the text)*/
    
    if (language==1){
    g.drawString("Type:                                "+amountTickets+" "+type, 75, 135);
    g.drawString("Fra zone:                                       "+startZone, 75, 183);
    g.drawString("Antal zoner:                                   "+amountZones, 75, 234);
    g.drawString("Billet pris:", 163, 288);
    
    //Setting a new font called ticketFont2 for the following text
    Font ticketFont2 = new Font("Calibri", Font.BOLD, 28);
    g.setFont(ticketFont2);
    
    //Text painted on the ticket with the font ticketFont2
    g.drawString(totalPrice+" DKK", 157, 313);
    g.setFont(ticketFont);
    g.drawString("Billetten er gyldig 2 timer fra køb", 75, 362);
    }
    else{
    g.drawString("Type:                                "+amountTickets+" "+typeENG, 75, 135);
    g.drawString("From zone:                                     "+startZone, 75, 183);
    g.drawString("Number of zones:                          "+amountZones, 75, 234);
    g.drawString("Ticket price:", 163, 288);
    
    //Setting a new font called ticketFont2 for the following text
    Font ticketFont2 = new Font("Calibri", Font.BOLD, 28);
    g.setFont(ticketFont2);
    
    //Text painted on the ticket with the font ticketFont2
    g.drawString(totalPrice+" DKK", 157, 313);
    g.setFont(ticketFont);
    g.drawString("Valid 2 hours from purchase", 75, 362);
    }
    
    g.drawString(timeStamp, 190, 412);
    
    //Setting a 3rd font called ticketFont2 for the following text
    Font ticketFont3 = new Font("Calibri", Font.BOLD, 12);
    g.setFont(ticketFont3);
    
    //Text painted on the ticket with the font ticketFont3
    g.drawString(ticketID, 70, 473);
    
    g.dispose();
  }

}