package tutoring;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IProfessorList professor_list;
		try {
			professor_list = (IProfessorList) Naming.lookup("rmi://127.0.0.1:1101/professor_list");

			System.out.println("Find prof with string");
			List<IProfessor> profSearch = professor_list.findProf("Prof");
			for (IProfessor prof : profSearch) {
				System.out.println("Prof " + prof.getName() + " with id  " +prof.getUUID() + "is found. ");
			}
			
			System.out.println("Find prof with modules");
			List<IProfessor> profSearchM = professor_list.findProfModule(Modules.Algorithmic);
			for (IProfessor prof : profSearchM) {
				System.out.println("Prof " + prof.getName() + " with id  " +prof.getUUID() + "is found. ");
			}
			
		}  catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}
}
