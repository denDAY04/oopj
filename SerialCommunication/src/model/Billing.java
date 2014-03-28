package model;

import java.io.Serializable;

public class Billing implements Serializable {
    private String TransactionNumb;
    private String CustomerNumb;  // forgin key
    private String HardwareNumb; // forgin key
    private String StartCharge;
    private String EndCharge;
    private String Recieved;
    private String BillingAmount;
    private String BillingRate;
    private String BillingKWH;
    private String NewBalanceBilling;
    

    public Billing(String TransactionNumb, String CustomerNumb, String HardwareNumb, String StartCharge, String EndCharge, String Recieved,
                   String BillingAmount,String BillingRate, String BillingKWH, String NewBalanceBilling) {
        this.TransactionNumb = TransactionNumb;
        this.CustomerNumb = CustomerNumb;
        this.HardwareNumb = HardwareNumb;
        this.StartCharge = StartCharge;
        this.EndCharge = EndCharge;
        this.Recieved = Recieved;
        this.BillingAmount = BillingAmount;
        this.BillingRate = BillingRate;
        this.BillingKWH = BillingKWH;
        this.NewBalanceBilling = NewBalanceBilling;
    }

    public String getTransactionNumb() {
        return TransactionNumb;
    }

    public void setTransactionNumb(String TransactionNumb) {
        this.TransactionNumb = TransactionNumb;
    }

    public String getCustomerNumb() {
        return CustomerNumb;
    }

    public void setCustomerNumb(String CustomerNumb) {
        this.CustomerNumb = CustomerNumb;
    }

    public String getHardwareNumb() {
        return HardwareNumb;
    }

    public void setHardwareNumb(String HardwareNumb) {
        this.HardwareNumb = HardwareNumb;
    }

    public String getStartCharge() {
        return StartCharge;
    }

    public void setStartCharge(String StartCharge) {
        this.StartCharge = StartCharge;
    }

    public String getEndCharge() {
        return EndCharge;
    }

    public void setEndCharge(String EndCharge) {
        this.EndCharge = EndCharge;
    }

    public String getRecieved() {
        return Recieved;
    }

    public void setRecieved(String Recieved) {
        this.Recieved = Recieved;
    }

    public String getBillingAmount() {
        return BillingAmount;
    }

    public void setBillingAmount(String BillingAmount) {
        this.BillingAmount = BillingAmount;
    }

    public String getBillingRate() {
        return BillingRate;
    }

    public void setBillingRate(String BillingRate) {
        this.BillingRate = BillingRate;
    }

    public String getBillingKWH() {
        return BillingKWH;
    }

    public void setBillingKWH(String BillingKWH) {
        this.BillingKWH = BillingKWH;
    }

    public String getNewBalanceBilling() {
        return NewBalanceBilling;
    }

    public void setNewBalanceBilling(String NewBalanceBilling) {
        this.NewBalanceBilling = NewBalanceBilling;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash =
                53 * hash +
                (this.TransactionNumb != null ? this.TransactionNumb.hashCode()
                : 0);
        hash =
                53 * hash +
                (this.CustomerNumb != null ? this.CustomerNumb.hashCode() : 0);
        hash =
                53 * hash +
                (this.HardwareNumb != null ? this.HardwareNumb.hashCode() : 0);
        hash =
                53 * hash +
                (this.StartCharge != null ? this.StartCharge.hashCode() : 0);
        hash =
                53 * hash +
                (this.EndCharge != null ? this.EndCharge.hashCode() : 0);
        hash =
                53 * hash +
                (this.Recieved != null ? this.Recieved.hashCode() : 0);
        hash =
                53 * hash +
                (this.BillingAmount != null ? this.BillingAmount.hashCode() : 0);
        hash =
                53 * hash +
                (this.BillingRate != null ? this.BillingRate.hashCode() : 0);
        hash =
                53 * hash +
                (this.BillingKWH != null ? this.BillingKWH.hashCode() : 0);
        hash =
                53 * hash +
                (this.NewBalanceBilling != null
                ? this.NewBalanceBilling.hashCode() : 0);
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
        final Billing other = (Billing) obj;
        if ((this.TransactionNumb == null) ? (other.TransactionNumb != null)
                : !this.TransactionNumb.equals(other.TransactionNumb)) {
            return false;
        }
        if ((this.CustomerNumb == null) ? (other.CustomerNumb != null)
                : !this.CustomerNumb.equals(other.CustomerNumb)) {
            return false;
        }
        if ((this.HardwareNumb == null) ? (other.HardwareNumb != null)
                : !this.HardwareNumb.equals(other.HardwareNumb)) {
            return false;
        }
        if ((this.StartCharge == null) ? (other.StartCharge != null)
                : !this.StartCharge.equals(other.StartCharge)) {
            return false;
        }
        if ((this.EndCharge == null) ? (other.EndCharge != null)
                : !this.EndCharge.equals(other.EndCharge)) {
            return false;
        }
        if ((this.Recieved == null) ? (other.Recieved != null)
                : !this.Recieved.equals(other.Recieved)) {
            return false;
        }
        if ((this.BillingAmount == null) ? (other.BillingAmount != null)
                : !this.BillingAmount.equals(other.BillingAmount)) {
            return false;
        }
        if ((this.BillingRate == null) ? (other.BillingRate != null)
                : !this.BillingRate.equals(other.BillingRate)) {
            return false;
        }
        if ((this.BillingKWH == null) ? (other.BillingKWH != null)
                : !this.BillingKWH.equals(other.BillingKWH)) {
            return false;
        }
        if ((this.NewBalanceBilling == null) ? (other.NewBalanceBilling != null)
                : !this.NewBalanceBilling.equals(other.NewBalanceBilling)) {
            return false;
        }
        return true;
    }
    
    
}
