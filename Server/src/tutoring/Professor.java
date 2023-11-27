package tutoring;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;

public class Professor extends UnicastRemoteObject implements IProfessor {
	UUID uuid;
	String name;
	Modules[] modules;
	
	protected Professor(String name, Modules[] modules) throws RemoteException {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.modules = modules;
	}
	public UUID getUUID() throws RemoteException {
		return this.uuid;
	}
	
	public String getName() throws RemoteException {
		return this.name;
	}
	public Modules[] getModules() throws RemoteException {
		return this.modules;
	}
}
