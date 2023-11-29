package tutoring;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.EnumSet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main  extends Application{
	
	 private IProfessorList professorList; 
	 @Override
	    public void start(Stage primaryStage) {
	        primaryStage.setTitle("Simple JavaFX App");

	        // Create labels and text fields for tutor name and family name
	        Label tutorLabel = new Label("Tutor name");
	        tutorLabel.getStyleClass().add("label");
	        Label familyLabel = new Label("Family name");
	        Label label = new Label("");

	        TextField tutorTextField = new TextField();
	        tutorTextField.setPromptText("Enter tutor name");
	        tutorTextField.getStyleClass().add("text-field");

	        TextField familyTextField = new TextField();
	        familyTextField.setPromptText("Enter family name");
	        familyTextField.getStyleClass().add("text-field");
	        ObservableList<Modules> modulesList = FXCollections.observableArrayList(Modules.values()); 
	        ComboBox<Modules> moduleComboBox = new ComboBox<>(modulesList);
	        moduleComboBox.setPromptText("Select Module");
	        moduleComboBox.getStyleClass().add("combo-box");
	        

	        Button submitButton = new Button("Submit");
	        submitButton.setOnAction(e -> {
	            String tutorName = tutorTextField.getText();
	            String familyName = familyTextField.getText();
	            Modules selectedModule = moduleComboBox.getSelectionModel().getSelectedItem(); 

	            if (selectedModule != null) {
	                    
	                    try {
	                    	professorList = (IProfessorList) Naming.lookup("rmi://127.0.0.1:1101/professor_list");
	            			System.out.println("Enroll prof");
	            			EnumSet<Modules> modules = EnumSet.of(selectedModule);
	            			 IProfessor prof = professorList.addProf(tutorName + " " + familyName, modules);
		                        System.out.println("Prof " + prof.getName() + " with id  " + prof.getUUID() + " is registered.");
	            			
	            			// TODO Auto-generated catch block
	            		}  catch (MalformedURLException ee) {
	            			// TODO Auto-generated catch block
	            			ee.printStackTrace();
	            		} catch (Exception ee) {
	            			// TODO Auto-generated catch block
	            			ee.printStackTrace();
	            		} 
	                

	                String greeting = "Hello, " + tutorName + " " + familyName + "!\nSelected Module: " + selectedModule;
	                label.setText(greeting);
	            } else {
	                // Handle the case where no module is selected
	                label.setText("Please select a module.");
	            }
	        });
	        submitButton.getStyleClass().add("button");

	        // Create an HBox layout and add the labels, text fields, and button to it
	        HBox Tutorbox = new HBox(10);
	        Tutorbox.setAlignment(Pos.CENTER);
	        Tutorbox.getChildren().addAll(tutorLabel, tutorTextField);
	        HBox Familybox = new HBox(10);
	        Familybox.setAlignment(Pos.CENTER);
	        Familybox.getChildren().addAll(familyLabel, familyTextField);
	        HBox Modulebox = new HBox(10);
	        Modulebox.setAlignment(Pos.CENTER);
	        Modulebox.getChildren().addAll(moduleComboBox);
	        HBox Buttonbox = new HBox(10);
	        Buttonbox.setAlignment(Pos.CENTER);
	        Buttonbox.getChildren().addAll(submitButton);

	        // Create a VBox layout and add the HBox and label to it
	        VBox formVBox = new VBox(20);
	        formVBox.setAlignment(Pos.CENTER);
	        formVBox.getChildren().addAll(Tutorbox, Familybox, Modulebox, Buttonbox, label);

	
	        // Create a scene with the SplitPane
	        Scene scene = new Scene(formVBox, 1000, 600);
	        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

	        // Set the scene for the primary stage
	        primaryStage.setScene(scene);

	        // Show the primary stage
	        primaryStage.show();
	    }
	 public static void main(String[] args) {
	        launch(args);
	    }
	
	
	/*public static void main(String[] args) {
		
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
	}*/
}
