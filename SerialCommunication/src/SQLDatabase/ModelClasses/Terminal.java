/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.ModelClasses;

import java.io.Serializable;

/**
 *
 * @author ibr
 */
public class Terminal implements Serializable {
    private String hardwareNumb;
    private String road;
    private String zipCode;
    private String ipAddress;
    private String installStatus;
    private String chargingStatus;

    public Terminal(String hardwareNumb, String road, String zipCode, String ipAddress, String installStatus, String chargingStatus) {
        this.hardwareNumb = hardwareNumb;
        this.road = road;
        this.zipCode = zipCode;
        this.ipAddress = ipAddress;
        this.installStatus = installStatus;
        this.chargingStatus = chargingStatus;

    }

      public String getHardwareNumb() {
        return hardwareNumb;
    }

    public void setHardwareNumb(String hardwareNumb) {
        this.hardwareNumb = hardwareNumb;
    }
    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }    
    
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getInstallStatus() {
        return installStatus;
    }

    public void setInstallStatus(String installStatus) {
        this.installStatus = installStatus;
    }

    public String getChargingStatus() {
        return chargingStatus;
    }

    public void setChargingStatus(String chargingStatus) {
        this.chargingStatus = chargingStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash =
                71 * hash +
                (this.hardwareNumb != null ? this.hardwareNumb.hashCode() : 0);
        hash = 71 * hash + (this.road != null ? this.road.hashCode() : 0);
        hash = 71 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash =
                71 * hash +
                (this.ipAddress != null ? this.ipAddress.hashCode() : 0);
        hash =
                71 * hash +
                (this.installStatus != null ? this.installStatus.hashCode() : 0);
        hash =
                71 * hash +
                (this.chargingStatus != null ? this.chargingStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Terminal other = (Terminal) obj;
        if ((this.hardwareNumb == null) ? (other.hardwareNumb != null)
                : !this.hardwareNumb.equals(other.hardwareNumb)) {
            return false;
        }
        if ((this.road == null) ? (other.road != null)
                : !this.road.equals(other.road)) {
            return false;
        }
        if ((this.zipCode == null) ? (other.zipCode != null)
                : !this.zipCode.equals(other.zipCode)) {
            return false;
        }
        if ((this.ipAddress == null) ? (other.ipAddress != null)
                : !this.ipAddress.equals(other.ipAddress)) {
            return false;
        }
        if ((this.installStatus == null) ? (other.installStatus != null)
                : !this.installStatus.equals(other.installStatus)) {
            return false;
        }
        return true;
    }

    
}
