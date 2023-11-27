package tutoring;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IProfessorList extends Remote{
	public IProfessor addProf(String name, Modules[] modules) throws RemoteException;
	public IProfessor deleteProf(UUID uuid) throws RemoteException;
	public IProfessor findProf(String searchKey) throws RemoteException;

}
