package Interface;

import java.awt.*;      
import javax.swing.*;

/**
 * Class simulating a physical printer to create graphical tickets.
 */
public class Printer {
    GraphicalTicket gticket;

    /**
     * Creates a frame and constructs an instance of an inner class in order to
     * paint all data and a background image on the JFrame.
     * @param typeDA String denoting the Danish name of the ticket.
     * @param typeENG String denoting the English name of the ticket.
     * @param startZone String denoting the startzone from which the ticket
     * is valid.
     * @param amountZones String denoting the amount of zones the ticket is 
     * valid for.
     * @param amountTickets String denoting the amount of tickets that should 
     * be represented by this one physical ticket.
     * @param totalPrice String denoting the total price of the ticket.
     * @param timeStamp String denoting the time at which the ticket was bought.
     * @param ticketID String denoting the unique ID of the ticket. 
     * @param language Int denoting the language that the ticket should be 
     * printed in.
     * @return True if the ticket is printed successfully; false otherwhise.
     */
    public boolean print(String typeDA, String typeENG, String startZone
            , String amountZones, String amountTickets, String totalPrice
            , String timeStamp, String ticketID, int language) {
        JFrame frame = new JFrame("BlueJ Trafikselskab");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 570);
        // Paint the data on the background
        gticket = new GraphicalTicket(typeDA, typeENG, amountTickets, startZone,
                amountZones, totalPrice, timeStamp, ticketID, language);
        frame.setContentPane(gticket);
        frame.setVisible(true);
        return true; 
    }
    
/**
 * Inner class used to paint all data and the background image on the ticket.
 */    
public class GraphicalTicket extends JPanel {
    //Declaration of the various variables used
    Image image; //Image variable to store the background image
    //Rest is ticket variables
    String type; 
    String amountTickets;
    String startZone;
    String amountZones;
    String totalPrice;
    String timeStamp;
    String ticketID;
    String typeENG;
    int language;

    /**
     * Custom constructor.
     * @param typeDA String denoting the Danish name of the ticket.
     * @param amountTickets String denoting the amount of tickets that should 
     * be represented by this one physical ticket.
     * @param startZone String denoting the startzone from which the ticket
     * is valid.
     * @param amountZones String denoting the amount of zones the ticket is 
     * valid for.
     * @param totalPrice String denoting the total price of the ticket.
     * @param timeStamp String denoting the time at which the ticket was bought.
     * @param ticketID String denoting the unique ID of the ticket. 
     * @param language Int denoting the language that the ticket should be 
     * printed in.
     * @param typeENG String denoting the English name of the ticket.
     */
    public GraphicalTicket(String typeDA,String typeENG, String amountTickets
            , String startZone, String amountZones, String totalPrice
            , String timeStamp,String ticketID,int language) {
        super();
        // Set background image
        image = Toolkit.getDefaultToolkit().getImage("background.png");
        this.type = typeDA;
        this.amountTickets = amountTickets;
        this.startZone = startZone;
        this.amountZones = amountZones;
        this.totalPrice = totalPrice;
        this.timeStamp = timeStamp;
        this.ticketID = ticketID;
        this.language = language;
        this.typeENG = typeENG;
  }

    /**
     * Paints all of the data onto the graphical ticket
     * @param g {@link Graphics} object denoting the content of the graphical 
     * ticket.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Paints the image onto the pane
        g.drawImage(image, 0, 0, 400, 533, this);
        //Setting the desired font for the text following
        Font ticketFont = new Font("Calibri", Font.BOLD, 18);
        g.setFont(ticketFont);
        /*Text painted on the ticket with the font ticketFont
          the 2 numbers at the end like ...type, 75, 135); are X and Y 
          coordinates for the first letter of the text)*/
        // If Danish
        if (language == 1) {
            g.drawString("Type:                                " 
                    + amountTickets + " " + type, 75, 135);
            g.drawString("Fra zone:                                       " 
                    + startZone, 75, 183);
            g.drawString("Antal zoner:                                 " 
                    + amountZones, 75, 234);
            g.drawString("Billet pris:", 163, 288);
            //Setting a new font called ticketFont2 for the following text
            Font ticketFont2 = new Font("Calibri", Font.BOLD, 28);
            g.setFont(ticketFont2);
            //Text painted on the ticket with the font ticketFont2
            g.drawString(totalPrice + " DKK", 126, 313);
            g.setFont(ticketFont);
            g.drawString("Billetten er gyldig 2 timer fra køb", 75, 362);
        } else {    // Else English
            g.drawString("Type:                                " 
                    + amountTickets + " " + typeENG, 75, 135);
            g.drawString("From zone:                                  " 
                    + startZone, 75, 183);
            g.drawString("Number of zones:                     " 
                    + amountZones, 75, 234);
            g.drawString("Ticket price:", 160, 288);
            //Setting a new font called ticketFont2 for the following text
            Font ticketFont2 = new Font("Calibri", Font.BOLD, 28);
            g.setFont(ticketFont2);
            //Text painted on the ticket with the font ticketFont2
            g.drawString(totalPrice + " DKK", 128, 313);
            g.setFont(ticketFont);
            g.drawString("Valid 2 hours from purchase", 90, 362);
        }
        g.drawString(timeStamp, 190, 412);
        //Setting a 3rd font called ticketFont2 for the following text
        Font ticketFont3 = new Font("Calibri", Font.BOLD, 12);
        g.setFont(ticketFont3);
        //Text painted on the ticket with the font ticketFont3
        g.drawString(ticketID, 70, 473);
        g.dispose();
    }
} // End of Inner class
    
}