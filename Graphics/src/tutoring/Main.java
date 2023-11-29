package tutoring;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;

public class Main extends Application {
	
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
        ObservableList<String> modulesList = FXCollections.observableArrayList("Mathematics", "Physics", "Chemistry");
        ComboBox<String> moduleComboBox = new ComboBox<>(modulesList);
        moduleComboBox.setPromptText("Select Module");
        moduleComboBox.getStyleClass().add("combo-box");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String tutorName = tutorTextField.getText();
            String familyName = familyTextField.getText();
            String selectedModule = moduleComboBox.getSelectionModel().getSelectedItem();
            
            if (selectedModule != null) {
                String greeting = "Hello, " + tutorName + " " + familyName + "!\nSelected Module: " + selectedModule;
                System.out.println("Enroll prof");
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
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(Tutorbox,Familybox,Modulebox,Buttonbox, label);

        // Create a scene with the VBox layout
        Scene scene = new Scene(new StackPane(vbox), 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Set the scene for the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
