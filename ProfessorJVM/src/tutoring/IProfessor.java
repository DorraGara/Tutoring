package tutoring;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IProfessor extends Remote{
	public UUID getUUID() throws RemoteException;
	public String getName() throws RemoteException;
	public Modules[] getModules() throws RemoteException;
}
