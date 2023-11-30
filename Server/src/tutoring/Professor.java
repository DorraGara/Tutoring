package tutoring;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public class Professor extends UnicastRemoteObject implements IProfessor {
	UUID uuid;
	String name;
	EnumSet<Modules> modules;
	List<Session> sessions = new ArrayList<>();
	
	protected Professor(String name, EnumSet<Modules> modules) throws RemoteException {
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
	public EnumSet<Modules> getModules() throws RemoteException {
		return this.modules;
	}
	public List<ISession> getSessions() throws RemoteException {
		List<ISession> sessions = new ArrayList<>(this.sessions);
		return sessions;	
	}
	public boolean createSession(Modules module, Level level, int capacity, LocalTime startTime, LocalTime endTime,LocalDate date, double price, Currency currency) throws RemoteException {
		Session session = new Session(module,level,capacity,startTime,endTime,date,price,currency);
		try {
			boolean ack = this.sessions.add(session);
			return ack;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean deleteSession(UUID uuid) throws RemoteException {
		for(Session sess : sessions) {
			if(sess.getUUID() == uuid) {
				return true;
		    }
		}
		return false;
	}
	
	public List<ISession> getNextSessions(LocalDate date) throws RemoteException {
		List<ISession> sessions = new ArrayList<>();
		for(Session sess : this.sessions) {
			LocalDate localdate = sess.getDate();
			if(localdate.isAfter(date)) {
				sessions.add(sess);
		    }
		}
		return sessions;	
	}	
	
	public List<ISession> getNextSessionsMod(LocalDate date, Modules mod) throws RemoteException {
		List<ISession> sessions = new ArrayList<>();
		for(Session sess : this.sessions) {
			LocalDate localdate = sess.getDate();
			Modules localMod = sess.getModule();
			if(localdate.isAfter(date) && (localMod == mod) ) {
				sessions.add(sess);
		    }
		}
		return sessions;	
	}
}
