package Interface;

import java.awt.*;      //Importing the required classes for this program
import javax.swing.*;

public class Printer extends JPanel {
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
    public void GraphicalTicket(String type, String typeENG, String amountTickets, String startZone, String amountZones, String totalPrice, String timeStamp, String ticketID, int language) {

        image = Toolkit.getDefaultToolkit().getImage("background.png");
        this.type = type;
        this.amountTickets = amountTickets;
        this.startZone = startZone;
        this.amountZones = amountZones;
        this.totalPrice = totalPrice;
        this.timeStamp = timeStamp;
        this.ticketID = ticketID;
        this.language = language;
        this.typeENG = typeENG;

        //Image MUST be placed in the root projectfolder, not under src!
    }
    //Class responsible of painting text on top of the image

    /**
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Paints the image onto the pane
        g.drawImage(image, 0, 0, 400, 533, this);

        //Setting the desired font for the text following
        Font ticketFont = new Font("Calibri", Font.BOLD, 18);
        g.setFont(ticketFont);

        //Text painted on the ticket with the font ticketFont
    /*the 2 numbers at the end like ...type, 75, 135); are X and Y 
         coordinates for the first letter of the text)*/

        if (language == 1) {
            g.drawString("Type:                                " + amountTickets + " " + type, 75, 135);
            g.drawString("Fra zone:                                         " + startZone, 75, 183);
            g.drawString("Antal zoner:                                     " + amountZones, 75, 234);
            g.drawString("Billet pris:", 163, 288);

            //Setting a new font called ticketFont2 for the following text
            Font ticketFont2 = new Font("Calibri", Font.BOLD, 28);
            g.setFont(ticketFont2);

            //Text painted on the ticket with the font ticketFont2
            g.drawString(totalPrice + " DKK", 126, 313);
            g.setFont(ticketFont);
            g.drawString("Billetten er gyldig 2 timer fra køb", 75, 362);
        } else {
            g.drawString("Type:                                " + amountTickets + " " + typeENG, 75, 135);
            g.drawString("From zone:                                  " + startZone, 75, 183);
            g.drawString("Number of zones:                       " + amountZones, 75, 234);
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

    //This is the method call to use in the main order to print a ticket     
    public void printTicket(String type, String typeENG, String amountTickets, String startZone, String amountZones, String totalPrice, String timeStamp, String ticketID, int language)
        { 
        this.type = type;
        this.amountTickets = amountTickets;
        this.startZone = startZone;
        this.amountZones = amountZones;
        this.totalPrice = totalPrice;
        this.timeStamp = timeStamp;
        this.ticketID = ticketID;
        this.language = language;
        this.typeENG = typeENG;

        JFrame frame = new JFrame("BlueJ Trafikselskab"); //Creates a new frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 570);

        //Creates a new instance of the object GraphicalTicket to use
        this.GraphicalTicket(type, typeENG, amountTickets, startZone, amountZones, totalPrice, timeStamp, ticketID, language);
        frame.setContentPane(this);
        frame.setVisible(true);
    }

    //Creates a new instance of the object UseGraphicalTicket named test
    /**
     * Printing method to simulate printing hardware.
     */
    public boolean print(String type, String typeENG, String startZone, String amountZones,
            String amountTickets, String totalPrice,
            String timeStamp, String ticketID, int language) {
        if (language == 1) {
            /*System.out.println("###############################");
            System.out.println("#-----BlueJ Trafikselskab-----#");
            System.out.println("#            Billet           #");
            System.out.println("#                             #");
            System.out.println("# Type:       " + amountTickets + type + "    #");
            System.out.println("#                             #");
            System.out.println("# Fra zone:   " + startZone + "            #");
            System.out.println("#                             #");
            System.out.println("# Antal zoner:" + amountZones + "            #");
            System.out.println("#                             #");
            System.out.println("#                             #");
            System.out.println("#        " + totalPrice + " DKK         #");
            System.out.println("#                             #");
            System.out.println("#                             #");
            System.out.println("#          " + timeStamp + "   #");
            System.out.println("#                             #");
            System.out.println("#    Gyldig 2 timer fra køb   #");
            System.out.println("#                             #");
            System.out.println("# >>" + ticketID + "<<          #");
            System.out.println("###############################");
            System.out.println();*/
        } else if (language == 2) {
            /*System.out.println("###############################");
            System.out.println("#-----BlueJ Trafikselskab-----#");
            System.out.println("#            Ticket           #");
            System.out.println("#                             #");
            System.out.println("# Type:         " + amountTickets + typeENG + "  #");
            System.out.println("#                             #");
            System.out.println("# From zone:    " + startZone + "          #");
            System.out.println("#                             #");
            System.out.println("# Amount zones: " + amountZones + "          #");
            System.out.println("#                             #");
            System.out.println("#                             #");
            System.out.println("#        " + totalPrice + " DKK         #");
            System.out.println("#                             #");
            System.out.println("#                             #");
            System.out.println("#          " + timeStamp + "   #");
            System.out.println("#                             #");
            System.out.println("# Valid 2 hours from purchase #");
            System.out.println("#                             #");
            System.out.println("# >>" + ticketID + "<<          #");
            System.out.println("###############################");
            System.out.println();*/

        } 

        /*Calls the printTicket(); method on the object test, which should
         show a ticket on the screen*/
        printTicket(type, typeENG, amountTickets, startZone, amountZones, totalPrice, timeStamp, ticketID, language);
        
        return true;  // can test printer error

    }
}
