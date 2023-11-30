package tutoring;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class WelcomePage extends VBox {

    private Label welcomeLabel;

    public WelcomePage(IProfessor professor) {
        initializeUI(professor);
    }

    private void initializeUI(IProfessor professor) {

        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(10, 20, 10, 20));

        Label projectNameLabel = new Label("Tutoring");
        projectNameLabel.getStyleClass().add("title");
        topBar.getChildren().add(projectNameLabel);

        HBox professorInfo = new HBox(10);
        professorInfo.setAlignment(Pos.CENTER_RIGHT);

        VBox imageVBox = new VBox(20);
        imageVBox.setAlignment(Pos.CENTER_RIGHT);
        imageVBox.getStyleClass().add("avatar");

        VBox sessions = new VBox(10);
        sessions.setAlignment(Pos.CENTER);
        Label professorNameLabel = new Label("Professor: ");
        try {
            String welcomeMessage = "Welcome, " + professor.getName() + "!\n";
            welcomeMessage += "ID: " + professor.getUUID() + "\n";

            professorNameLabel = new Label(professor.getName());
            professorNameLabel.setStyle("-fx-font-size: 14px;");

            welcomeLabel = new Label(welcomeMessage);
            welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            

            if (professor.getSessions() != null && !professor.getSessions().isEmpty()) {
                // Display sessions
                for (ISession session : professor.getSessions()) {
                    Label sessionLabel = new Label("Session: " + session.toString());
                    sessions.getChildren().add(sessionLabel);
                }
            } else {
                // Show message and button to add sessions
                Label noSessionLabel = new Label("No sessions available. Add sessions below:");
                Button addSessionButton = new Button("Add Session");
                addSessionButton.setOnAction(e -> {
                    try {
                    	 boolean sessionCreated = professor.createSession(Modules.Algorithmic,Level.BEGINNER,1,LocalTime.of(9, 0),LocalTime.of(9, 0),LocalDate.of(2023, 12, 1),20,Currency.EUR);
                    	  if (sessionCreated) {
                    		  System.out.println("Session Created");
                              // or notify the user that the session was added successfully
                          } else {
                        	  System.out.println("Session Error");
                          }
                    
                    } catch (Exception ex) {
                        ex.printStackTrace(); // Handle RemoteException as needed
                    }
                });
                sessions.getChildren().addAll(noSessionLabel, addSessionButton);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        professorInfo.getChildren().addAll(professorNameLabel, imageVBox);

        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER);
        header.getChildren().addAll(topBar, professorInfo);
        header.getStyleClass().add("header");

        

        SplitPane splitPane = new SplitPane(createMenu(), sessions);
        splitPane.setDividerPositions(0.2);

        HBox mainPage = new HBox(10);
        mainPage.setAlignment(Pos.CENTER);
        mainPage.getChildren().addAll(splitPane);
        mainPage.getStyleClass().add("mainpage");
        splitPane.setStyle("-fx-border-color: null;-fx-background-color: #F5F5F5;");

        HBox.setHgrow(topBar, Priority.ALWAYS);
        HBox.setHgrow(splitPane, Priority.ALWAYS);

        VBox fullPage = new VBox(10);
        fullPage.setAlignment(Pos.TOP_CENTER);
        fullPage.getChildren().addAll(header, mainPage);

        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(0));
        getChildren().addAll(fullPage);
    }

    private VBox createMenu() {
        Label menuItem = createMenuItem("All Sessions");
        Label menuItem2 = createMenuItem("Next Sessions");
        Label menuItem3 = createMenuItem("Past Sessions");

        VBox menu = new VBox(5);
        menu.setAlignment(Pos.TOP_LEFT);
        menu.getChildren().addAll(menuItem, menuItem2, menuItem3);
        menu.getStyleClass().add("menu");

        // Set the first menu item as selected by default
        selectMenuItem(menuItem);

        return menu;
    }

    private Label createMenuItem(String text) {
        Label menuItem = new Label(text);
        menuItem.getStyleClass().add("menuItem");

        // Set the label to take full width
        menuItem.setMaxWidth(Double.MAX_VALUE);
        menuItem.setAlignment(Pos.CENTER_LEFT);
        menuItem.setStyle("-fx-pref-height: 30;");

        // Event handling for mouse click
        menuItem.setOnMouseClicked(event -> {
            // Reset styles for all menu items
            for (javafx.scene.Node node : ((VBox) menuItem.getParent()).getChildren()) {
                node.getStyleClass().remove("selected");
            }

            // Apply selected style to the clicked menu item
            menuItem.getStyleClass().add("selected");
        });

        return menuItem;
    }


    private void selectMenuItem(Label menuItem) {
        // Apply selected style to the specified menu item
        menuItem.getStyleClass().add("selected");
    }


}
