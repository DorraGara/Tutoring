package tutoring;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.EnumSet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main  extends Application{
	
	 private IProfessorList professorList; 
	 IProfessor prof;
	 @Override
	    public void start(Stage primaryStage) {
	        primaryStage.setTitle("Simple JavaFX App");

	        // Create labels and text fields for tutor name and family name
	        Label title = new Label("GustaveTutoring");
	        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;-fx-font-family: 'Sans-serif'; -fx-text-fill: #041444;");
	        Label description = new Label("GustaveTutoring is an innovative tutoring application designed to provide a seamless and personalized learning experience for students seeking academic assistance. ");
	        description.getStyleClass().add("desc");
	        description.setWrapText(true); 
	        description.setStyle("-fx-text-alignment: justify;-fx-line-spacing: 1.2;");
	        Label tutorLabel = new Label("Tutor name");
	        tutorLabel.getStyleClass().add("label");
	        Label familyLabel = new Label("Family name");
	        Label ModuleLabel = new Label("Module");
	        ModuleLabel.getStyleClass().add("label");
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
	        
	        
	        
	        Button submitButton = new Button("Register");
	        submitButton.setOnAction(e -> {
	            String tutorName = tutorTextField.getText();
	            String familyName = familyTextField.getText();
	            Modules selectedModule = moduleComboBox.getSelectionModel().getSelectedItem();

	            if (selectedModule != null) {
	                try {
	                    professorList = (IProfessorList) Naming.lookup("rmi://127.0.0.1:1101/professor_list");
	                    System.out.println("Enroll prof");
	                    EnumSet<Modules> modules = EnumSet.of(selectedModule);
	                    prof = professorList.addProf(tutorName + " " + familyName, modules);
	                    System.out.println("Prof " + prof.getName() + " with id  " + prof.getUUID() + " is registered." + "sessions" + prof.getSessions());
	                } catch (MalformedURLException ee) {
	                    ee.printStackTrace();
	                } catch (Exception ee) {
	                    ee.printStackTrace();
	                }

	                WelcomePage welcomePage = new WelcomePage(prof);
	                Scene welcomeScene = new Scene(welcomePage, 1000, 600);
	                welcomeScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

	                // Set the new scene for the primary stage
	                primaryStage.setScene(welcomeScene);
	            } else {
	                // Handle the case where no module is selected
	                label.setText("Please select a module.");
	            }
	        });
	        submitButton.getStyleClass().add("button");

	        // Create an HBox layout and add the labels, text fields, and button to it
	        VBox titlebox = new VBox(5);
	        titlebox.getChildren().addAll(title,description);
	        VBox Tutorbox = new VBox(5);
	        Tutorbox.getChildren().addAll(tutorLabel, tutorTextField);
	        VBox Familybox = new VBox(5);
	        Familybox.getChildren().addAll(familyLabel, familyTextField);
	        VBox Modulebox = new VBox(10);
	        Modulebox.getChildren().addAll(ModuleLabel,moduleComboBox);
	        HBox Buttonbox = new HBox(10);
	        Buttonbox.setAlignment(Pos.BASELINE_RIGHT);
	        Buttonbox.getChildren().addAll(submitButton);

	       /* double imageWidth = primaryStage.getWidth() * 0.4;

	        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/tutoring/assets/photos/elearning.jpg")));
	        imageView.setFitHeight(600);
	        imageView.setFitWidth(imageWidth);
	        imageView.setPreserveRatio(true);*/

	        // Create a VBox layout for the image
	    //    VBox imageVBox = new VBox(imageView);
	        VBox imageVBox = new VBox(20);
	        imageVBox.getStyleClass().add("image");
	        BoxBlur blur = new BoxBlur(10, 10, 3);
	        imageVBox.setEffect(blur);
	        // Create a VBox layout for the form
	        VBox formVBox = new VBox(20);
	        formVBox.setAlignment(Pos.CENTER_LEFT);
	        formVBox.getChildren().addAll(titlebox,Tutorbox, Familybox, Modulebox, Buttonbox, label);
	        formVBox.setPadding(new Insets(10, 20, 10, 20));
	        

	        // Create a SplitPane to horizontally split the image and form
	        SplitPane splitPane = new SplitPane(imageVBox, formVBox);
	        splitPane.setDividerPositions(0.55); // Set the divider position (40% split)
	        splitPane.setStyle("-fx-border-color: null;");
	        
	        // Create a scene with the SplitPane
	        Scene scene = new Scene(splitPane, 1000, 600);
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
