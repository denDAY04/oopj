//Class from which objects will be created 
//and then passed as arguments.

package RmiTest;

import java.rmi.*;

public interface customer extends Remote
{
	public int getAcctNum() throws RemoteException;
	public String getName() throws RemoteException;
	public double getBalance() throws RemoteException;
	public double withdraw(double amount) throws RemoteException;
	public void deposit(double amount) throws RemoteException;
}