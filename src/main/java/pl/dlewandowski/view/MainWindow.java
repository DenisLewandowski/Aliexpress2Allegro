package pl.dlewandowski.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.dlewandowski.service.AliexpressOfferDownloader;
import pl.dlewandowski.AliexpressToAllegro;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainWindow {

    private Stage stage;
    private BorderPane mainBorderPane, bottomBorderPane;
    private Scene mainScene;
    private Button closeButton, addOfferButton;
    private Text appTitle;

    public MainWindow() {
        stage = AliexpressToAllegro.primaryStage;
        stage.setTitle("Aliexpress2Allegro App");
        stage.getIcons().add(new Image("aliexpress.png"));
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
        appTitle = new Text();
        closeButton = new Button();
        addOfferButton = new Button();
    }

    private void setComponents() {
        mainBorderPane.setPadding(new Insets(20,20,20,20));

        addOfferButton.setText("Add new offer");
        addOfferButton.setPadding(new Insets(20,40,20,40));
        addOfferButton.setAlignment(Pos.CENTER_RIGHT);
        addOfferButton.setOnAction(e -> {
            new NewOffertDialog();
        });

        setTitleAndLogo();
        setCloseButton();

        bottomBorderPane.setLeft(closeButton);
        bottomBorderPane.setRight(addOfferButton);

        mainBorderPane.setBottom(bottomBorderPane);
    }

    private void setCloseButton() {
        closeButton.setText("Close");
        closeButton.setAlignment(Pos.BOTTOM_LEFT);
        closeButton.setPadding(new Insets(20,40,20,40));
        closeButton.setAlignment(Pos.CENTER_LEFT);
        closeButton.setOnAction(e -> Platform.exit());
    }


    private void setTitleAndLogo() {
        BorderPane topBorderPane = new BorderPane();
        HBox logoHBox = new HBox();
        logoHBox.setSpacing(60);
        logoHBox.setAlignment(Pos.CENTER);

        setAppTitle();
        topBorderPane.setTop(appTitle);
        setAliexpressImage(logoHBox);
        setRightArrow(logoHBox);
        setAllegroImage(logoHBox);

        topBorderPane.setTop(new BorderPane(appTitle));
        topBorderPane.setCenter(new BorderPane(logoHBox));

        mainBorderPane.setTop(topBorderPane);
    }

    private void setAppTitle() {
        appTitle.setText("Aliexpress to Allegro App");
        appTitle.setFont(new Font("Blackadder ITC", 36));
    }

    private void setAliexpressImage(HBox hBox) {
        Image img = new Image("https://ae01.alicdn.com/kf/HTB1c3FmKpXXXXblXpXXq6xXFXXX5/Jewelry-Box-For-Wholesaler-Customized-Order-and-Down-Payment.jpg_640x640.jpg", 60, 60, false, true);
        ImageView aliexpressImage = new ImageView(img);
        aliexpressImage.setOnMouseClicked(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://best.aliexpress.com/?lan=pl"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
        hBox.getChildren().add(aliexpressImage);
    }

    private void setRightArrow(HBox hBox) {
        ImageView arrow = new ImageView("right_arrow.png");
        BorderPane center = new BorderPane();
        center.setCenter(arrow);
        hBox.getChildren().add(center);
    }

    private void setAllegroImage(HBox hBox) {
        Image img = new Image("https://cdn6.aptoide.com/imgs/d/5/8/d58afa02da764b2f5acffd30fd533b44_icon.png?w=60", 60, 60, false, true);
        ImageView allegroImage = new ImageView(img);
        allegroImage.setOnMouseClicked(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://allegro.pl/"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
        hBox.getChildren().add(allegroImage);
    }

}
