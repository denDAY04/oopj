package model;

import java.io.Serializable;

public class Billing implements Serializable {
    private String TransactionNumb;
    private String CustomerNumb;  // forgin key
    private String HardwareNumb; // forgin key
    private String StartCharge;
    private String EndCharge;
    private String Recieved;
    private double BillingAmount;
    private double BillingRate;
    private double BillingKWH;
    private double NewBalanceBilling;
    

    public Billing(String TransactionNumb, String CustomerNumb, String HardwareNumb, String StartCharge, String EndCharge, String Recieved,
                   double BillingAmount,double BillingRate, double BillingKWH, double NewBalanceBilling) {
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

    public double getBillingAmount() {
        return BillingAmount;
    }

    public void setBillingAmount(double BillingAmount) {
        this.BillingAmount = BillingAmount;
    }

    public double getBillingRate() {
        return BillingRate;
    }

    public void setBillingRate(double BillingRate) {
        this.BillingRate = BillingRate;
    }

    public double getBillingKWH() {
        return BillingKWH;
    }

    public void setBillingKWH(double BillingKWH) {
        this.BillingKWH = BillingKWH;
    }

    public double getNewBalanceBilling() {
        return NewBalanceBilling;
    }

    public void setNewBalanceBilling(double NewBalanceBilling) {
        this.NewBalanceBilling = NewBalanceBilling;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash =
                37 * hash +
                (this.TransactionNumb != null ? this.TransactionNumb.hashCode()
                : 0);
        hash =
                37 * hash +
                (this.CustomerNumb != null ? this.CustomerNumb.hashCode() : 0);
        hash =
                37 * hash +
                (this.HardwareNumb != null ? this.HardwareNumb.hashCode() : 0);
        hash =
                37 * hash +
                (this.StartCharge != null ? this.StartCharge.hashCode() : 0);
        hash =
                37 * hash +
                (this.EndCharge != null ? this.EndCharge.hashCode() : 0);
        hash =
                37 * hash +
                (this.Recieved != null ? this.Recieved.hashCode() : 0);
        hash =
                37 * hash +
                (int) (Double.doubleToLongBits(this.BillingAmount) ^
                (Double.doubleToLongBits(this.BillingAmount) >>> 32));
        hash =
                37 * hash +
                (int) (Double.doubleToLongBits(this.BillingRate) ^
                (Double.doubleToLongBits(this.BillingRate) >>> 32));
        hash =
                37 * hash +
                (int) (Double.doubleToLongBits(this.BillingKWH) ^
                (Double.doubleToLongBits(this.BillingKWH) >>> 32));
        hash =
                37 * hash +
                (int) (Double.doubleToLongBits(this.NewBalanceBilling) ^
                (Double.doubleToLongBits(this.NewBalanceBilling) >>> 32));
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
        if (Double.doubleToLongBits(this.BillingAmount) !=
                Double.doubleToLongBits(other.BillingAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.BillingRate) !=
                Double.doubleToLongBits(other.BillingRate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.BillingKWH) != Double.doubleToLongBits(other.BillingKWH)) {
            return false;
        }
        if (Double.doubleToLongBits(this.NewBalanceBilling) !=
                Double.doubleToLongBits(other.NewBalanceBilling)) {
            return false;
        }
        return true;
    }
    
    
    
}