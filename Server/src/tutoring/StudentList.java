package tutoring;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class StudentList extends UnicastRemoteObject implements IStudentList{

	List<Student> database = new ArrayList<>();

	protected StudentList() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public IStudent addStudent(String name) throws RemoteException {
		// TODO Auto-generated method stub
		Student student = new Student(name);
		this.database.add(student);
		return student;
	}

}
