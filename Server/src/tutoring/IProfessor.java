package tutoring;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.EnumSet;
import java.util.UUID;

public interface IProfessor extends Remote{
	public UUID getUUID() throws RemoteException;
	public String getName() throws RemoteException;
	public EnumSet<Modules> getModules() throws RemoteException;
}
