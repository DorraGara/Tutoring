package tutoring;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;

public interface ISession extends Remote {
	
	/**
    // Getter methods
    Modules getModule() throws RemoteException;

    int getCapacity() throws RemoteException;

    LocalTime getStartTime() throws RemoteException;

    LocalTime getEndTime() throws RemoteException;

    LocalDate getDate() throws RemoteException;

    double getPrice() throws RemoteException;

    Currency getCurrency() throws RemoteException;

    // Setter methods
    void setModule(Modules module) throws RemoteException;

    void setCapacity(int capacity) throws RemoteException;

    void setStartTime(LocalTime startTime) throws RemoteException;

    void setEndTime(LocalTime endTime) throws RemoteException;

    void setDate(LocalDate date) throws RemoteException;

    void setPrice(double price) throws RemoteException;

    void setCurrency(Currency currency) throws RemoteException;
    **/

}
