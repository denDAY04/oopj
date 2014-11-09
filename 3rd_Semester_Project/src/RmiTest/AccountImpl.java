package RmiTest;

//Class from which objects will be created 
//and then passed as arguments.

import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.util.concurrent.locks.*;

public class AccountImpl extends UnicastRemoteObject implements Account {

    private int acctNum;
    private String surname;
    private String firstNames;
    private double balance;
    private ReentrantLock lock;

    public AccountImpl(int acctNo, String sname, String fnames, double bal) throws RemoteException {
        acctNum = acctNo;
        surname = sname;
        firstNames = fnames;
        balance = bal;
    }

    public int getAcctNum() throws RemoteException {
        return acctNum;
    }

    public String getName() throws RemoteException {
        return (firstNames + " " + surname);
    }

    public double getBalance() throws RemoteException {
        return balance;
    }

    public double withdraw(double amount) throws RemoteException {
       
        Double tmp = -1.0;
        try {
            lock.lock();
            if (amount <= balance) {tmp = amount;}
            else {tmp = (double) 0;}
            lock.unlock();

        } catch (Exception e) {System.err.println("withdraw error");}
        return tmp;
    }

    public void deposit(double amount) throws RemoteException {
        
        Double tmp = -1.0;
        try {
            lock.lock();
            if (amount > 0) {balance += amount;}
            lock.unlock();
            
        } catch (Exception e) {System.err.println("Deposit error");
        }

    }
}
