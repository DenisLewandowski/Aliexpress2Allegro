package pl.dlewandowski.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.dlewandowski.AliexpressOfferDownloader;
import pl.dlewandowski.AliexpressToAllegro;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainWindow {

    private Stage stage;
    private BorderPane mainBorderPane, bottomBorderPane;
    private HBox topHBox;
    private Scene mainScene;
    private Button closeButton, button;
    private Text text;
    private TextField aliexpresURLTextField;

    public MainWindow() {
        stage = AliexpressToAllegro.primaryStage;
        initializeComponents();
        setComponents();
        initializeMainScene();


        stage.setScene(mainScene);
        WindowUtils.setWindowCenterOnScreen(stage);
    }

    private void initializeMainScene() {
        mainScene = new Scene(mainBorderPane,800, 600);
    }

    private void initializeComponents() {
        mainBorderPane = new BorderPane();
        bottomBorderPane = new BorderPane();
        text = new Text();
        closeButton = new Button();
        button = new Button();
    }

    private void setComponents() {
        mainBorderPane.setPadding(new Insets(20,20,20,20));
        topHBox = new HBox(50);

        text.setText("Second window");
        closeButton.setText("Close");
        closeButton.setAlignment(Pos.BOTTOM_LEFT);
        closeButton.setPadding(new Insets(20,40,20,40));
        closeButton.setAlignment(Pos.CENTER_LEFT);
        closeButton.setOnAction(e -> Platform.exit());
        button.setText("Do something");
        button.setPadding(new Insets(20,40,20,40));
        button.setAlignment(Pos.CENTER_RIGHT);
        button.setOnAction(e -> {
            for(String imgUrl : AliexpressOfferDownloader.getOffer(aliexpresURLTextField.getText()).getImageURLs()) {
                System.out.println(imgUrl);
            }
        });

        setAliexpressImage();
        setRightArrow();
        setAllegroImage();
        topHBox.setAlignment(Pos.TOP_CENTER);

        setURLText();

        bottomBorderPane.setLeft(closeButton);
        bottomBorderPane.setRight(button);

        mainBorderPane.setBottom(bottomBorderPane);
        mainBorderPane.setTop(topHBox);
    }

    private void setAliexpressImage() {
        Image img = new Image("https://ae01.alicdn.com/kf/HTB1c3FmKpXXXXblXpXXq6xXFXXX5/Jewelry-Box-For-Wholesaler-Customized-Order-and-Down-Payment.jpg_640x640.jpg", 60, 60, false, true);
        ImageView aliexpressImage = new ImageView(img);
        aliexpressImage.setOnMouseClicked(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://best.aliexpress.com/?lan=pl"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
        topHBox.getChildren().add(aliexpressImage);
    }

    private void setRightArrow() {
        ImageView arrow = new ImageView("right_arrow.png");
        BorderPane center = new BorderPane();
        center.setCenter(arrow);
        topHBox.getChildren().add(center);
    }

    private void setAllegroImage() {
        Image img = new Image("https://cdn6.aptoide.com/imgs/d/5/8/d58afa02da764b2f5acffd30fd533b44_icon.png?w=60", 60, 60, false, true);
        ImageView allegroImage = new ImageView(img);
        allegroImage.setOnMouseClicked(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://allegro.pl/"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
        topHBox.getChildren().add(allegroImage);
    }

    private void setURLText() {
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(20,40,0,40));
        Label aliUrl = new Label("Wpisz adres URL z Aliexpiress:");
        aliexpresURLTextField = new TextField();
        aliexpresURLTextField.setPrefWidth(520);
        hBox.getChildren().add(aliUrl);
        hBox.getChildren().add(aliexpresURLTextField);
        mainBorderPane.setCenter(hBox);
    }



}
