/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SerialCom.controller;

import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author hbe
 */
public class PortDetection {
    static String getPortTypeName(int portType) {
        // konvertér porttype til tekststreng
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
    
    public static ArrayList<String> getPorts() {
        ArrayList<String> list = new ArrayList();
        Enumeration portEnum =
                CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier portID = (CommPortIdentifier)portEnum.nextElement();
            String name = portID.getName();
            String type = getPortTypeName(portID.getPortType());
            if (type.equals("RS232")) {
                list.add(name);
            }
        }
        return list;
    }
}
