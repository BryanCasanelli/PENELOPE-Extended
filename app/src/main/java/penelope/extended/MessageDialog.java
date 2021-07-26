package penelope.extended;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Shows a simple message dialog.
 */
public class MessageDialog extends Alert{

    /**
     * Initializer.
     * @param alertType (AlertType) AlertType to extract default settings.
     */
    public MessageDialog(AlertType alertType) {
        super(alertType);
    }

    /**
     * Initializer
     * @param message (String) Message to show.
     */
    public MessageDialog(String message) {
        super(Alert.AlertType.INFORMATION);
        setHeaderText(null);
        setTitle(Language.get(0));
        setContentText(message);
        Stage stage = (Stage) getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(MessageDialog.class.getClassLoader().getResourceAsStream("images/icon_256.png")));
        ButtonType okButton = new ButtonType(Language.get(3), ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().clear();
        getDialogPane().getButtonTypes().add(okButton);
    }
    
}
