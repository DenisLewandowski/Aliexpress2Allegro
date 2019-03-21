package pl.dlewandowski.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class SignInWindow {
    private static final String APP_NAME = "A2A - Aliexpress to Allegro";
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 400;

    private Stage primaryStage;
    private GridPane grid;

    private Text welcomeText, wrongInputText;
    private Label login, password;
    private TextField loginTextField;
    private PasswordField passwordField;
    private Button loginButton, closeButton;

    public SignInWindow(Stage primaryStage) {
        this.primaryStage = primaryStage;

        initializeAndSetGrid();
        initializeComponents();
        setComponents();
        addComponentsToGrid();
        setPrimaryStage();

        primaryStage.show();
    }

    private void setPrimaryStage() {
        primaryStage.setTitle(APP_NAME);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(grid, WINDOW_WIDTH, WINDOW_HEIGHT));
    }

    private void initializeAndSetGrid() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 10, 25, 10));
    }

    private void initializeComponents() {
        welcomeText = new Text();
        wrongInputText = new Text();
        login = new Label();
        password = new Label();
        loginTextField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button();
        closeButton = new Button();
    }

    private void setComponents() {
        welcomeText.setText("Welcome");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        wrongInputText.setText("Invalid login or password!");
        wrongInputText.setFill(Color.FIREBRICK);
        wrongInputText.setVisible(false);
        login.setText("User login: ");
        password.setText("Password: ");
        loginButton.setText("Sign in");
        loginButton.setOnAction(signInEvent());
        closeButton.setText("Close");
        closeButton.setOnAction(e -> Platform.exit());
    }

    private void addComponentsToGrid() {
        grid.add(welcomeText, 0, 0);
        grid.add(login, 0, 1);
        grid.add(loginTextField, 1, 1);
        grid.add(password, 0, 2);
        grid.add(passwordField, 1, 2);

        HBox clsBtnBox = new HBox(10);
        clsBtnBox.setAlignment(Pos.BOTTOM_LEFT);
        clsBtnBox.getChildren().add(closeButton);
        grid.add(clsBtnBox, 0, 3);

        HBox btnBox = new HBox(10);
        btnBox.setAlignment(Pos.BOTTOM_RIGHT);
        btnBox.getChildren().add(loginButton);
        grid.add(btnBox, 1, 3);

        grid.add(wrongInputText, 1, 4);
    }

    private EventHandler<ActionEvent> signInEvent() {
        return event -> {
            if (loginTextField.getText().equals("admin") &&
                    passwordField.getText().equals("admin")) {
                new MainWindow();
            } else {
                wrongInputText.setVisible(true);
            }
        };
    }

}
