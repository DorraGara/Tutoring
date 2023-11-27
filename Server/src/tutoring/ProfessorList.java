package tutoring;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProfessorList extends UnicastRemoteObject implements IProfessorList {

	List<Professor> database = new ArrayList<>();
	
	protected ProfessorList() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Professor addProf(String name, Modules[] modules) throws RemoteException {
		// TODO Auto-generated method stub
		Professor prof = new Professor(name, modules);
		this.database.add(prof);
		return prof;
	}
	
	@Override
	public Professor deleteProf(UUID uuid) throws RemoteException {
		for(Professor prof : database) {
			if(prof.getUUID() == uuid) {
				return prof;
		    }
		}
		return null;
	}
	
	public Professor findProf(String searchKey) throws RemoteException {
		for(Professor prof : database) {
			if(prof.getName().equals(searchKey) ) {
		        return prof;
		    }
		}
		    return null;	
	}
}
