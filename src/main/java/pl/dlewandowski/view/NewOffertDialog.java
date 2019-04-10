package pl.dlewandowski.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.dlewandowski.service.AliexpressURLValidator;
import pl.dlewandowski.service.AliexpressOfferDownloader;

import javax.swing.text.html.Option;
import java.util.Optional;

public class NewOffertDialog extends TextInputDialog {

    public NewOffertDialog() {

        setTitle("Enter Aliexpiess URL");
        setIcon();
        setContentText("Enter Aliexpress URL:");
        setHeaderText("");

        Optional<String> result = this.showAndWait();
        buttonPressed(result);
    }

    private void setIcon() {
        Stage dialog = (Stage) this.getDialogPane().getScene().getWindow();
        dialog.getIcons().add(new Image("aliexpress.png"));
        ImageView image = new ImageView("aliexpress.png");
        this.setGraphic(image);
    }

    private void buttonPressed(Optional<String> result) {
        String url = result.get();
        if (AliexpressURLValidator.validate(url)) {
            for (String imgUrl : AliexpressOfferDownloader.getOffer(url).getImageURLs()) {
                System.out.println(imgUrl);
            }
            showSuccesDialog();
        } else {
            showErrorDialog();
        }
    }

    private void showErrorDialog() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wrong URL");
        alert.setContentText("Invalid aliexpress offert URL!");
        Stage errorDialog = (Stage) alert.getDialogPane().getScene().getWindow();
        errorDialog.getIcons().add(new Image("aliexpress.png"));
        alert.showAndWait();
    }

    private void showSuccesDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Offer downloaded!");
        alert.setHeaderText("");
        alert.setContentText("Aliexpress offer is downloaded properly!");
        Stage errorDialog = (Stage) alert.getDialogPane().getScene().getWindow();
        errorDialog.getIcons().add(new Image("aliexpress.png"));
        alert.showAndWait();
    }

}
