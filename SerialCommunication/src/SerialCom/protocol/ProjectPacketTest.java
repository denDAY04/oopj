/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SerialCom.protocol;
import SerialCom.*;

/**
 *
 * @author Qess
 */
public class ProjectPacketTest {
    

    
    
static public void main(String args[]){
    ProjectPacket packet = new ProjectPacket("02", "01", "VC", "test");
    System.out.println(packet.getChecksum());
    
}

}


