package tutoring;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public interface IProfessor extends Remote{
	public UUID getUUID() throws RemoteException;
	public String getName() throws RemoteException;
	public EnumSet<Modules> getModules() throws RemoteException;
	public boolean createSession(Modules module, Level level, int capacity, LocalTime startTime, LocalTime endTime,LocalDate date, double price, Currency currency) throws RemoteException;
	public boolean deleteSession(UUID uuid) throws RemoteException;
	public List<ISession> getSessions() throws RemoteException;
	public List<ISession> getNextSessions(LocalDate date) throws RemoteException;
	public List<ISession> getNextSessionsMod(LocalDate date, Modules mod) throws RemoteException;

}
