package tutoring;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.EnumSet;


public class Main {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		IProfessorList professor_list;
		try {
			professor_list = (IProfessorList) Naming.lookup("rmi://127.0.0.1:1101/professor_list");
			System.out.println("Enroll prof");
			EnumSet<Modules> modules = EnumSet.of(Modules.Mathemathics, Modules.Algorithmic);
			IProfessor prof = professor_list.addProf("Professor 1", modules);
			System.out.println("Prof " + prof.getName() + " with id  " +prof.getUUID() + "is registred. ");
			
			// TODO Auto-generated catch block
		}  catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
