package SQLDatabase.ModelClasses;

import java.io.Serializable;

/**
 * Model class with the purpose of containing the data that constitutes a
 * billing instance in the database. This class only has standard getters and
 * setters, and thus there are not written Jdoc to them.
 */
public class Billing implements Serializable {

    private String transactionNumb;
    private String customerNumb;
    private String hardwareNumb;
    private String startCharge;
    private String endCharge;
    private String recieved;
    private double billingAmount;
    private double billingRate;
    private double billingKWH;
    private double newBalanceBilling;

    /**
     * Custom constructor that simple assigns every field. 
     * 
     * @param transactionNumb
     * @param customerNumb
     * @param hardwareNumb
     * @param startCharge
     * @param endCharge
     * @param recieved
     * @param billingAmount
     * @param billingRate
     * @param billingKWH
     * @param newBalanceBilling 
     */
    public Billing(String transactionNumb, String customerNumb,
            String hardwareNumb, String startCharge, String endCharge,
            String recieved,
            double billingAmount, double billingRate, double billingKWH,
            double newBalanceBilling) {
        this.transactionNumb = transactionNumb;
        this.customerNumb = customerNumb;
        this.hardwareNumb = hardwareNumb;
        this.startCharge = startCharge;
        this.endCharge = endCharge;
        this.recieved = recieved;
        this.billingAmount = billingAmount;
        this.billingRate = billingRate;
        this.billingKWH = billingKWH;
        this.newBalanceBilling = newBalanceBilling;
    }

    public String getTransactionNumb() {
        return transactionNumb;
    }

    public void setTransactionNumb(String TransactionNumb) {
        this.transactionNumb = TransactionNumb;
    }

    public String getCustomerNumb() {
        return customerNumb;
    }

    public void setCustomerNumb(String CustomerNumb) {
        this.customerNumb = CustomerNumb;
    }

    public String getHardwareNumb() {
        return hardwareNumb;
    }

    public void setHardwareNumb(String HardwareNumb) {
        this.hardwareNumb = HardwareNumb;
    }

    public String getStartCharge() {
        return startCharge;
    }

    public void setStartCharge(String StartCharge) {
        this.startCharge = StartCharge;
    }

    public String getEndCharge() {
        return endCharge;
    }

    public void setEndCharge(String EndCharge) {
        this.endCharge = EndCharge;
    }

    public String getRecieved() {
        return recieved;
    }

    public void setRecieved(String Recieved) {
        this.recieved = Recieved;
    }

    public double getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(double BillingAmount) {
        this.billingAmount = BillingAmount;
    }

    public double getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(double BillingRate) {
        this.billingRate = BillingRate;
    }

    public double getBillingWH() {
        return billingKWH;
    }

    public void setBillingKWH(double BillingKWH) {
        this.billingKWH = BillingKWH;
    }

    public double getNewBalanceBilling() {
        return newBalanceBilling;
    }

    public void setNewBalanceBilling(double NewBalanceBilling) {
        this.newBalanceBilling = NewBalanceBilling;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash
                = 37 * hash
                + (this.transactionNumb != null ? this.transactionNumb.
                hashCode()
                : 0);
        hash
                = 37 * hash
                + (this.customerNumb != null ? this.customerNumb.hashCode() : 0);
        hash
                = 37 * hash
                + (this.hardwareNumb != null ? this.hardwareNumb.hashCode() : 0);
        hash
                = 37 * hash
                + (this.startCharge != null ? this.startCharge.hashCode() : 0);
        hash
                = 37 * hash
                + (this.endCharge != null ? this.endCharge.hashCode() : 0);
        hash
                = 37 * hash
                + (this.recieved != null ? this.recieved.hashCode() : 0);
        hash
                = 37 * hash
                + (int) (Double.doubleToLongBits(this.billingAmount)
                ^ (Double.doubleToLongBits(this.billingAmount) >>> 32));
        hash
                = 37 * hash
                + (int) (Double.doubleToLongBits(this.billingRate)
                ^ (Double.doubleToLongBits(this.billingRate) >>> 32));
        hash
                = 37 * hash
                + (int) (Double.doubleToLongBits(this.billingKWH)
                ^ (Double.doubleToLongBits(this.billingKWH) >>> 32));
        hash
                = 37 * hash
                + (int) (Double.doubleToLongBits(this.newBalanceBilling)
                ^ (Double.doubleToLongBits(this.newBalanceBilling) >>> 32));
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
        if ((this.transactionNumb == null) ? (other.transactionNumb != null)
                : !this.transactionNumb.equals(other.transactionNumb)) {
            return false;
        }
        if ((this.customerNumb == null) ? (other.customerNumb != null)
                : !this.customerNumb.equals(other.customerNumb)) {
            return false;
        }
        if ((this.hardwareNumb == null) ? (other.hardwareNumb != null)
                : !this.hardwareNumb.equals(other.hardwareNumb)) {
            return false;
        }
        if ((this.startCharge == null) ? (other.startCharge != null)
                : !this.startCharge.equals(other.startCharge)) {
            return false;
        }
        if ((this.endCharge == null) ? (other.endCharge != null)
                : !this.endCharge.equals(other.endCharge)) {
            return false;
        }
        if ((this.recieved == null) ? (other.recieved != null)
                : !this.recieved.equals(other.recieved)) {
            return false;
        }
        if (Double.doubleToLongBits(this.billingAmount)
                != Double.doubleToLongBits(other.billingAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.billingRate)
                != Double.doubleToLongBits(other.billingRate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.billingKWH) != Double.doubleToLongBits(
                other.billingKWH)) {
            return false;
        }
        if (Double.doubleToLongBits(this.newBalanceBilling)
                != Double.doubleToLongBits(other.newBalanceBilling)) {
            return false;
        }
        return true;
    }
}
