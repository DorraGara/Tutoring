package tutoring;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;

public class Student extends UnicastRemoteObject implements IStudent {
	UUID uuid;
	String name;
	
	protected Student(String name) throws RemoteException {
		this.uuid = UUID.randomUUID();
		this.name = name;
	}
	public UUID getUUID() throws RemoteException {
		return this.uuid;
	}
	
	public String getName() throws RemoteException {
		return this.name;
	}
	
	//We can try to return an Alert dunno if it exist in JAVAFX
	public ISession notifyStudent(ISession session) throws RemoteException {
		return session;
	}
}
