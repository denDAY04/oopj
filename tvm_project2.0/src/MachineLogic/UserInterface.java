package MachineLogic;
import java.util.*;
public class UserInterface {
    private int language;       //1 danish, 2 english 
    
    // User input is string in all cases; if int or double is needed-
    // a call to InputValidation is usedd 
    Scanner userInputStr = new Scanner(System.in);

    
    /**
    * Standard constructor.
    */
    public UserInterface() {
    }
    
    
    /**
    * Print a received string to display.
    * @param s
    */
    public void printLn(String s) {
        System.out.println(s);
    }
    
    /**
     * Print empty line and string on new line.
     * @param s 
     */
    public void printLnSpace(String s) {
        System.out.println();
        System.out.println(s);
    }
    
    /**
    * Let user select language for menus. 
    */
    public void setLanguage() {
        String temp;            // Temp string to hold user input
        int tempInt;            // Temp int for evaluation
        
        System.out.println();
        System.out.println("Select language / vælg sprog ");
        System.out.println("1 : Danish / Dansk");
        System.out.println("2 : English / Engelsk");
        System.out.print("Choice / valg: ");
        temp = userInputStr.nextLine();
        tempInt = this.isInterger(temp);
        while (tempInt != 1  && tempInt != 2 && tempInt != 1337) {
            System.out.println("Error: Undefined input / Fejl: Udefineret indtastning.");
            System.out.print("Try again / Prøv igen: ");
            temp = userInputStr.nextLine();
            tempInt= this.isInterger(temp); 
        }
        this.language=tempInt;
        System.out.println();
    }
    
    
    /**
    * Let user select amount of given tickets.
    * @return
    */
    public int getAmount() {
        int ticketAmount;
        String temp;            // Temporary string to hold user input
        
        if (language == 1) {
            System.out.print("Vælg antal billetter: ");
        } else {
            System.out.print("Choose amount of tickets: ");
        }
        temp = userInputStr.nextLine();
        ticketAmount = this.isInterger(temp);
        while (ticketAmount == -1  || ticketAmount>100 || ticketAmount==0 ) {
            if (language == 1) {
                System.out.println("Fejl i indtastningen.");
                System.out.print("Prøv igen: ");
                temp = userInputStr.nextLine();
                ticketAmount = this.isInterger(temp);
            } else {
                System.out.println("Input error.");
                System.out.print("Try again: ");
                temp = userInputStr.nextLine();
                ticketAmount = this.isInterger(temp);
            }
        }
        System.out.println();
        return ticketAmount;
    }
   
        /**
     * Let user select the number of zones a given ticket will be valid for.
     * @return 
     */
    public int getZones() {
            int amountZones;            // #zones the ticket will be valid for
        String temp;                // Temporary string to hold user input
                 
        System.out.println();
        if (language == 1) {
            System.out.print("Hvor mange zoner: ");
        } else {
            System.out.print("How many zones: ");
        }
        temp = userInputStr.nextLine();
        amountZones = this.isInterger(temp);
        if (amountZones < 2) {
           return 2;
        } else if (amountZones > 8) {
            return 8;
        } else {
            return amountZones;
        }
    }

    
        /**
    * Display the sale to user, and ask for accept.
    * @return 
    */
    public int addToCart() {
        int addToCart = 0;       // 0 cancel, 1 accept
        String addToCartString;
        
        if (language == 1) {
            System.out.print("Tilføj til din kurv? (J/N): ");
            addToCartString = userInputStr.nextLine();
            if (addToCartString.equals("j") || addToCartString.equals("J")) {
                addToCart = 1;
            } else {
                System.out.println("Du har afbrudt købet.");
            }
        } else {
            System.out.print("Add to cart? (Y/N): ");
            addToCartString = userInputStr.nextLine();
            if (addToCartString.equals("y") || addToCartString.equals("Y")) {
                addToCart = 1;
            } else {
                System.out.println("You have canceled the sale.");
            }
        }
        System.out.println();
        return addToCart;
    }
    
    
    /**
    * Display the sale to user, and ask for accept.
    * @return 
    */
    public int acceptSale() {
        int saleAccepted = 0;       // 0 cancel, 1 accept
        String saleAcceptedString;
        
        if (language == 1) {
          System.out.print("Accepterer du købet? (J/N): ");
            saleAcceptedString = userInputStr.nextLine();
            if (saleAcceptedString.equals("j") || saleAcceptedString.equals("J")) {
                saleAccepted = 1;  
            } else {
                System.out.println("Du har afbrudt købet.");
            }
        } else {
            System.out.print("Do you accept the sale? (Y/N): ");
            saleAcceptedString = userInputStr.nextLine();
            if (saleAcceptedString.equals("y") || saleAcceptedString.equals("Y")) {
                saleAccepted = 1;
            } else {
                System.out.println("You have canceled the sale.");
            }
        }
        System.out.println();
        return saleAccepted;
    }
    
    public int SelectPaymentType(int language)
    {
        if (language == 1)
        {
            System.out.println("Vælg betalingsmetode:");
            System.out.println("Tryk 1: Kontant betaling");
            System.out.println("Tryk 2: Betalingskort");
            System.out.println("Tryk 3: Betal med SMS");
        }
        else if (language == 2)
        {
            System.out.println("Choose desired payment method: ");
            System.out.println("Press 1: Pay with cash");
            System.out.println("Press 2: Creditcard payment");
            System.out.println("Press 3: Pay by SMS");
        }
        int input = this.getInt();
        while (input <= 0 || input>3)
        {
            if (language == 1) System.err.println("Fejl 40 - Indtast et tal mellem 1 og 3.");
            else if (language == 2) System.err.println("Error 40 - Enter a number between 1 and 3.");
            input = this.getInt();
        }
        return input;
    }
    
    
    /**
     * Show menu of active tickets in the machine. Get index from user to buy.
     * @param t
     * @return 
     */
    public int ticketsMenu(ArrayList<Ticket> t) {
        int n = 0;              // normal counter
        int ticketIndex;        // index on the ticket user selects
        String temp;            //temp string with user input for validation
        
        if (language == 1) {
            System.out.println("Der er følgende typer billetter:");
            for (Ticket element : t) {
                System.out.println("Billet nr. "+(n+1)+" : "+element.getTypeDA()+" per zone "+element.getPricePerZone()+" kr. minimum 2 zoner.");
                n++;
            }
            System.out.println();
            System.out.print("Vælg billet nr: ");
        } else {
            System.out.println("There are following types of tickets:");
            for (Ticket element : t) {
                System.out.println("Ticket nr. "+(n+1)+" : "+element.getTypeENG()+" per zone "+element.getPricePerZone()+" DKK. minimum, 2 zones.");
                n++;
            }
            System.out.println();
            System.out.print("Choose ticket nr: ");
        }
        
        temp = userInputStr.nextLine();
        ticketIndex = this.isInterger(temp);
        while (true) {
            if ((ticketIndex <= 0 || ticketIndex>t.size()) && language == 1 ) {
                System.out.println("Fejl: forkert indtastning.");
                System.out.print("Prøv igen: ");
                temp = userInputStr.nextLine();
                ticketIndex = this.isInterger(temp);
            } else if ((ticketIndex <= 0 || ticketIndex>t.size()) && language == 2 ) {
                System.out.println("Error: invalid input.");
                System.out.print("Try again: ");
                temp = userInputStr.nextLine();
                ticketIndex = this.isInterger(temp);
            } else {
                break;
            }
        }
        System.out.println();
        return ticketIndex;
    }
    
    
        /**
     * Show Shopping cart.
     * @param t
     * @return
     */
    public int showCart(ArrayList<Ticket> t) {
        int n = 0;              // normal counter
        int totalprice=0;       // counter for price
        int moretickets=0;      // counter for more tickets or not
        String temp;            //temp string with user input for validation
        
        if (language == 1) {
            System.out.println("Der er følgende billetter i din kurv:");
            for (Ticket element : t) {
                int ticketprice = (element.getPricePerZone()*element.getZones());
                int subtotal = ticketprice*element.getAmountTickets();
                System.out.println(element.getAmountTickets()+" stk. "+ element.getTypeDA()+" "+element.getZones()+ "-zoners billet á " +ticketprice+" kr. subtotal: "+subtotal+" kr.");
                totalprice = totalprice + subtotal;
                n++;
            }
            System.out.println("Total: " +totalprice+" kr.");
            System.out.println();
            System.out.print("Vil du købe flere billetter? (J/N):");
        } else {
            System.out.println("Your cart contains the following tickets:");
            for (Ticket element : t) {
                int ticketprice = (element.getPricePerZone()*element.getZones());
                int subtotal = ticketprice*element.getAmountTickets();
                System.out.println(element.getAmountTickets()+" "+ element.getTypeENG()+ " ticket(s), "+element.getZones()+ "-zones, each " +ticketprice+" kr. subtotal: "+ subtotal+" kr." );
                totalprice = totalprice + subtotal;
                n++;
            }
            System.out.println("Total: " +totalprice);
            System.out.println();
            System.out.print("Do you wish to buy more tickets? (Y/N): ");
        }
        
        String moreticketsString;
        
        if (language == 1) {
            moreticketsString = userInputStr.nextLine();
            if (moreticketsString.equals("j") || moreticketsString.equals("J")) {
                moretickets = 1;
            } else {
                    System.out.println("Går videre til betaling.");
                    }
        } else {
                moreticketsString = userInputStr.nextLine();
                    if (moreticketsString.equals("y") || moreticketsString.equals("Y")) {
                     moretickets = 1;
                    } else {
                           System.out.println("Proceeding to payment.");
                           }
        }
        System.out.println();
        return moretickets;
    }
    
    
    
    /**
     * Show menu for service.
     * @return 
     */
    public int serviceMenu() {
        int serviceChoice;
        String temp;            //temp string with user input for validation
        
        System.out.println("-- Service Menu --");
        System.out.println("1 : Vis dagsstatistik");
        System.out.println("2 : Skift billetrulle");
        System.out.println("3 : Skift blækpatron");
        System.out.println("4 : Udskriv og nulstil salgs statestik");
        System.out.println("5 : Sæt ud af drift");
        System.out.println("6 : Standard service besøg");
        System.out.println("7 : Vis total statestik");      
        System.out.println("8 : Udskriv test billetter");
        System.out.println("0 : Log ud");
        System.out.print("valg: ");
        temp = userInputStr.nextLine();
        serviceChoice = this.isInterger(temp);
        while (true) {
            if (serviceChoice == -1) {
                System.out.println("Fejl: Ingen heltal fundest.");
                System.out.print("Prøv igen: ");
                temp = userInputStr.nextLine();
                serviceChoice = this.isInterger(temp);
            } else if (serviceChoice > 9) {
                System.out.println("Fejl: Udefineret indtstning.");
                System.out.print("Prøv igen: ");
                temp = userInputStr.nextLine();
                serviceChoice = this.isInterger(temp);
            } else {
                break;
            }
        }
        System.out.println();
        return serviceChoice;
    }
    
    
    /**
     * Let an admin set the unique hardware ID for the unit.
     * @return 
     */
    public int setHardwareID() {
        int HardwareID;
        String temp;            //temp string with user input for validation
        
        System.out.println();
        System.out.print("Indtast maskinens unikke ID kode: ");
        temp = userInputStr.nextLine();
        HardwareID = this.isInterger(temp);
        while (HardwareID == -1) {
            System.out.println("Fejl: Ingen heltal fundet.");
            System.out.print("Prøv igen: ");
            temp = userInputStr.nextLine();
            HardwareID = this.isInterger(temp);
        }
        System.out.println();
        return HardwareID;
    }
    
    /**
     * Let an admin create a new ticket type/name in English.
     * @return 
     */
    public String setTypeEN() {
        String ticketType;
        
        System.out.println();
        System.out.print("Indtast typen for en billet på engelsk: ");
        
        ticketType = userInputStr.nextLine();
        while (ticketType.isEmpty())
        {
            System.out.print("Fejl i indtastning, prøv igen: ");
            ticketType = userInputStr.nextLine();
        }
        
        return ticketType;
    }
    
    /**
     * Let an admin create a new ticket type/name in Danish.
     * @return 
     */
    public String setTypeDK() {
        String ticketType;
        
        System.out.println();
        System.out.print("Indtast typen for en billet på dansk: ");
        
        ticketType = userInputStr.nextLine();
        while (ticketType.isEmpty())
        {
            System.out.print("Fejl i indtastning, prøv igen: ");
            ticketType = userInputStr.nextLine();
        }
        
        
        return ticketType;
    }
    
    
    /**
     * Let an admin set the price per zone for the given type.
     * @return 
     */
    public int setZonePrice() {
        int zonePrice;
        int adminAccept = 0;
        String temp;            //temp string with user input for validation
        
        System.out.println();
        System.out.print("Indtast pris pr. zone: ");
        temp = userInputStr.nextLine();
        zonePrice = this.isInterger(temp);
        while (zonePrice == -1) {
            System.out.println("Fejl: Ingen heltal fundet.");
            System.out.print("Prøv igen: ");
            temp = userInputStr.nextLine();
            zonePrice = this.isInterger(temp);
        }
        System.out.println();
        return zonePrice;
    }
    
    /**
     * Return a positive integer given from user.
     * @return 
     */
    public int getInt() {
        String temp;
        int n;
        
        temp = userInputStr.nextLine();
        n = this.isInterger(temp);
        
        return n;
    }
    
    /**
     * Return the language index.
     * @return 
     */
    public int getLanguage() {
        return language;
    }
    
        /**
     * Try make string to int.
     * @param s
     * @return 
     */
    public int isInterger(String s) {
        int temp;
        try {
            temp = Integer.parseInt(s);        // Try make s to int
        } catch (NumberFormatException e) {    //catch exception - return error
            return -1;
        }
        if (temp==0){
            return -1;
        }
        
        if (temp < 0) {                     // invert negatives
            temp *= -1;
        }
        return temp;                        //if no exception, return int
    }
    
    /**
     * Try make string to double.
     * @param s
     * @return 
     */
    public double isDouble(String s) {
        double temp;
        try {
            temp = Double.parseDouble(s);      // Try make s to double
        } catch (NumberFormatException e) {    //catch exception - return error
            return -1;
        }
        if (temp < 0.0) {                     // invert negatives
            temp *= -1;
        }
        return temp;                        // if no exception, return double
    }
}


