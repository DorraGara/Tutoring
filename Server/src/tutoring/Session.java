package tutoring;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
	List<Student> students = new ArrayList<>();
	List<Student> waitList = new ArrayList<>();

	
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
    
	public List<IStudent> getStudents() throws RemoteException {
		List<IStudent> students = new ArrayList<>(this.students);
		return students;	
	}
	
	public String addStudent(IStudent student) throws RemoteException {
		try {
			if(this.students.size() < this.capacity) {
				boolean ack = this.students.add((Student) student);
				if (ack) return "You have been successfully enrolled";
			} else {
				boolean ack = this.waitList.add((Student) student);
				if (ack) return "You have been successfully added to the wait list. Your rank is " + this.waitList.size() + ".";
			}
			return "There has been some error";
		} catch (Exception e) {
			e.printStackTrace();
			return "There has been some error";		
		}
	}	
	
	public String deleteRegistredStudent(IStudent student) throws RemoteException {
		boolean ack = this.students.remove(student);
		if (ack) {
			Student firstWaitList = this.waitList.get(0);
			firstWaitList.notifyStudent(this);
			this.waitList.remove(0);
			return "You have successfully unregistred for the session.";
		} else {
			return "There has been some error";
		}
	}
	
	
    /**
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
