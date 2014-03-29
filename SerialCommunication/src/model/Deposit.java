package model;

import java.io.Serializable;

public class Deposit implements Serializable {
    private String DepositsNumb;
    private String CustomerNumb; // forgin key
    private String DepositsDate;
    private double DepositAmount;
    private double NewBalanceDeposit;
    private String ExternalRefNumb;
    private String last4CardNumb;
    //

    public Deposit(String DepositsNumb, String CustomerNumb, String DepositsDate, double DepositAmount, double NewBalanceDeposit, String ExternalRefNumb,
                    String last4CardNumb) {
        this.DepositsNumb = DepositsNumb;
        this.CustomerNumb = CustomerNumb;
        this.DepositsDate = DepositsDate;
        this.DepositAmount = DepositAmount;
        this.NewBalanceDeposit = NewBalanceDeposit;
        this.ExternalRefNumb = ExternalRefNumb;
        this.last4CardNumb = last4CardNumb;


    }

    public String getDepositsNumb() {
        return DepositsNumb;
    }

    public void setDepositsNumb(String DepositsNumb) {
        this.DepositsNumb = DepositsNumb;
    }

    public String getCustomerNumb() {
        return CustomerNumb;
    }

    public void setCustomerNumb(String CustomerNumb) {
        this.CustomerNumb = CustomerNumb;
    }

    public String getDepositsDate() {
        return DepositsDate;
    }

    public void setDepositsDate(String DepositsDate) {
        this.DepositsDate = DepositsDate;
    }

    public double getDepositAmount() {
        return DepositAmount;
    }

    public void setDepositAmount(double DepositAmount) {
        this.DepositAmount = DepositAmount;
    }

    public double getNewBalanceDeposit() {
        return NewBalanceDeposit;
    }

    public void setNewBalanceDeposit(double NewBalanceDeposit) {
        this.NewBalanceDeposit = NewBalanceDeposit;
    }

    public String getExternalRefNumb() {
        return ExternalRefNumb;
    }

    public void setExternalRefNumb(String ExternalRefNumb) {
        this.ExternalRefNumb = ExternalRefNumb;
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
                (this.DepositsNumb != null ? this.DepositsNumb.hashCode() : 0);
        hash =
                61 * hash +
                (this.CustomerNumb != null ? this.CustomerNumb.hashCode() : 0);
        hash =
                61 * hash +
                (this.DepositsDate != null ? this.DepositsDate.hashCode() : 0);
        hash =
                61 * hash +
                (int) (Double.doubleToLongBits(this.DepositAmount) ^
                (Double.doubleToLongBits(this.DepositAmount) >>> 32));
        hash =
                61 * hash +
                (int) (Double.doubleToLongBits(this.NewBalanceDeposit) ^
                (Double.doubleToLongBits(this.NewBalanceDeposit) >>> 32));
        hash =
                61 * hash +
                (this.ExternalRefNumb != null ? this.ExternalRefNumb.hashCode()
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
        if ((this.DepositsNumb == null) ? (other.DepositsNumb != null)
                : !this.DepositsNumb.equals(other.DepositsNumb)) {
            return false;
        }
        if ((this.CustomerNumb == null) ? (other.CustomerNumb != null)
                : !this.CustomerNumb.equals(other.CustomerNumb)) {
            return false;
        }
        if ((this.DepositsDate == null) ? (other.DepositsDate != null)
                : !this.DepositsDate.equals(other.DepositsDate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.DepositAmount) !=
                Double.doubleToLongBits(other.DepositAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.NewBalanceDeposit) !=
                Double.doubleToLongBits(other.NewBalanceDeposit)) {
            return false;
        }
        if ((this.ExternalRefNumb == null) ? (other.ExternalRefNumb != null)
                : !this.ExternalRefNumb.equals(other.ExternalRefNumb)) {
            return false;
        }
        if ((this.last4CardNumb == null) ? (other.last4CardNumb != null)
                : !this.last4CardNumb.equals(other.last4CardNumb)) {
            return false;
        }
        return true;
    }

    
}
