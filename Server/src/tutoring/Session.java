package tutoring;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Session extends UnicastRemoteObject implements ISession{
	UUID uuid;
	Modules module;
	Level level;
	int capacity;
	LocalTime startTime;
	LocalTime endTime;
	LocalDate date;
	double price;
	Currency currency;
	
	protected Session(Modules module, Level level, int capacity, LocalTime startTime, LocalTime endTime,LocalDate date, double price, Currency currency) throws RemoteException {
		this.uuid = UUID.randomUUID();
		this.module = module;
		this.capacity = capacity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.price = price;
		this.currency = currency;	
		this.level = level;
	}

    // Getters
    public UUID getUUID() {
        return uuid;
    }
    
    /**
    public Modules getModule() {
        return module;
    }
    
    public Level getLevel() {
        return level;
    }
    public int getCapacity() {
        return capacity;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    // Setters
    public void setModule(Modules module) {
        this.module = module;
    }
    
    public void setLevel(Level level) {
        this.level = level;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    } 
    **/

}
