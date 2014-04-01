package SQLDatabase.ModelClasses;

import java.io.Serializable;

public class Deposit implements Serializable {
    private String depositsNumb;
    private String customerNumb; // forgin key
    private String depositsDate;
    private double depositAmount;
    private double newBalanceDeposit;
    private String externalRefNumb;
    private String last4CardNumb;
    //

    public Deposit(String depositsNumb, String customerNumb, String depositsDate, double depositAmount, double newBalanceDeposit, String externalRefNumb,
                    String last4CardNumb) {
        this.depositsNumb = depositsNumb;
        this.customerNumb = customerNumb;
        this.depositsDate = depositsDate;
        this.depositAmount = depositAmount;
        this.newBalanceDeposit = newBalanceDeposit;
        this.externalRefNumb = externalRefNumb;
        this.last4CardNumb = last4CardNumb;


    }

    public String getDepositsNumb() {
        return depositsNumb;
    }

    public void setDepositsNumb(String DepositsNumb) {
        this.depositsNumb = DepositsNumb;
    }

    public String getCustomerNumb() {
        return customerNumb;
    }

    public void setCustomerNumb(String CustomerNumb) {
        this.customerNumb = CustomerNumb;
    }

    public String getDepositsDate() {
        return depositsDate;
    }

    public void setDepositsDate(String DepositsDate) {
        this.depositsDate = DepositsDate;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double DepositAmount) {
        this.depositAmount = DepositAmount;
    }

    public double getNewBalanceDeposit() {
        return newBalanceDeposit;
    }

    public void setNewBalanceDeposit(double NewBalanceDeposit) {
        this.newBalanceDeposit = NewBalanceDeposit;
    }

    public String getExternalRefNumb() {
        return externalRefNumb;
    }

    public void setExternalRefNumb(String ExternalRefNumb) {
        this.externalRefNumb = ExternalRefNumb;
    }

    public String getLast4CardNumb() {
        return last4CardNumb;
    }

    public void setLast4CardNumb(String last4CardNumb) {
        this.last4CardNumb = last4CardNumb;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash =
                61 * hash +
                (this.depositsNumb != null ? this.depositsNumb.hashCode() : 0);
        hash =
                61 * hash +
                (this.customerNumb != null ? this.customerNumb.hashCode() : 0);
        hash =
                61 * hash +
                (this.depositsDate != null ? this.depositsDate.hashCode() : 0);
        hash =
                61 * hash +
                (int) (Double.doubleToLongBits(this.depositAmount) ^
                (Double.doubleToLongBits(this.depositAmount) >>> 32));
        hash =
                61 * hash +
                (int) (Double.doubleToLongBits(this.newBalanceDeposit) ^
                (Double.doubleToLongBits(this.newBalanceDeposit) >>> 32));
        hash =
                61 * hash +
                (this.externalRefNumb != null ? this.externalRefNumb.hashCode()
                : 0);
        hash =
                61 * hash +
                (this.last4CardNumb != null ? this.last4CardNumb.hashCode() : 0);
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
        final Deposit other = (Deposit) obj;
        if ((this.depositsNumb == null) ? (other.depositsNumb != null)
                : !this.depositsNumb.equals(other.depositsNumb)) {
            return false;
        }
        if ((this.customerNumb == null) ? (other.customerNumb != null)
                : !this.customerNumb.equals(other.customerNumb)) {
            return false;
        }
        if ((this.depositsDate == null) ? (other.depositsDate != null)
                : !this.depositsDate.equals(other.depositsDate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.depositAmount) !=
                Double.doubleToLongBits(other.depositAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.newBalanceDeposit) !=
                Double.doubleToLongBits(other.newBalanceDeposit)) {
            return false;
        }
        if ((this.externalRefNumb == null) ? (other.externalRefNumb != null)
                : !this.externalRefNumb.equals(other.externalRefNumb)) {
            return false;
        }
        if ((this.last4CardNumb == null) ? (other.last4CardNumb != null)
                : !this.last4CardNumb.equals(other.last4CardNumb)) {
            return false;
        }
        return true;
    }

    
}
