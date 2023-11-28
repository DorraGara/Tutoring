package tutoring;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public interface IProfessorList extends Remote{
	public IProfessor addProf(String name, EnumSet<Modules> modules) throws RemoteException;
	public IProfessor deleteProf(UUID uuid) throws RemoteException;
	public List<IProfessor> findProf(String searchKey) throws RemoteException;
	public List<IProfessor> findProfModule(Modules module) throws RemoteException;
}
