package tutoring;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public class ProfessorList extends UnicastRemoteObject implements IProfessorList {

	List<Professor> database = new ArrayList<>();
	
	protected ProfessorList() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Professor addProf(String name, EnumSet<Modules> modules) throws RemoteException {
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
	
	public List<IProfessor> findProf(String searchKey) throws RemoteException {
		List<IProfessor> found_professors = new ArrayList<>();
		for(Professor prof : database) {
			if(prof.getName().contains(searchKey) ) {
		       found_professors.add(prof);
		    }
		}
		    return found_professors;	
	}
	
	public List<IProfessor> findProfModule(Modules module) throws RemoteException {
		List<IProfessor> found_professors = new ArrayList<>();
		for(Professor prof : database) {
			EnumSet<Modules> mod = prof.getModules();
			if(mod.contains(module) ) {
				found_professors.add(prof);
		    }
		}
		    return found_professors;	
	}
}
