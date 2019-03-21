package pl.dlewandowski;


import javafx.application.Application;
import javafx.stage.Stage;
import pl.dlewandowski.view.MainWindow;
import pl.dlewandowski.view.SignInWindow;

public class AliexpressToAllegro extends Application {

    public static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        AliexpressToAllegro.primaryStage = primaryStage;
        new MainWindow();
        primaryStage.show();
    }
}
