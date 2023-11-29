// WelcomePage.java
package tutoring;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WelcomePage extends VBox {

    private Label welcomeLabel;

    public WelcomePage(String tutorName) {
        initializeUI(tutorName);
    }

    private void initializeUI(String tutorName) {
        welcomeLabel = new Label("Welcome, " + tutorName + "!");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        setAlignment(Pos.CENTER);
        setPadding(new Insets(20));
        getChildren().add(welcomeLabel);
    }
}
