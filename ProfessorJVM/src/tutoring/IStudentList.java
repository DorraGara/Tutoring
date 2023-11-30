package tutoring;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStudentList extends Remote {

	IStudent addStudent(String name) throws RemoteException;

}
