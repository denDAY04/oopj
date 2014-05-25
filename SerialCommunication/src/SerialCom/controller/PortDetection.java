package SerialCom.controller;

import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Use this class for detecting the PORTS active on the PC on which the program
 * is running.
 */
public class PortDetection {

    /**
     * Looks up the PORT type denoted by the argument, as specified by the
     * ComPortIdentifier class, and returns a string with its name.
     *
     * @param portType int denoting a PORT.
     *
     * @return one of the following:
     * <li>I2C
     * <li>IEEE 1284
     * <li>Raw
     * <li>RS485
     * <li>RS232
     * <li>or "Unknown" if the integer does not match any of the previous PORT
     * types.
     */
    public static String getPortTypeName(int portType) {
        /* Convert PORT types to strings */
        switch (portType) {
            case CommPortIdentifier.PORT_I2C:
                return "I2C";
            case CommPortIdentifier.PORT_PARALLEL:
                return "IEEE 1284";
            case CommPortIdentifier.PORT_RAW:
                return "Raw";
            case CommPortIdentifier.PORT_RS485:
                return "RS485";
            case CommPortIdentifier.PORT_SERIAL:
                return "RS232";
            default:
                return "Unknown";
        }
    }

    /**
     * Get a list of all the ports that are currently active in the PC.
     *
     * @return an ArrayList of Strings with the PORT names, as determined by
     *         PortDetection.getPortTypeName.
     *
     * @see getPortTypeName(int portType)
     */
    public static ArrayList<String> getPorts() {
        ArrayList<String> list = new ArrayList();
        Enumeration portEnum
                = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier portID = (CommPortIdentifier) portEnum.
                    nextElement();
            String name = portID.getName();
            String type = getPortTypeName(portID.getPortType());
            if (type.equals("RS232")) {
                list.add(name);
            }
        }
        return list;
    }
}
