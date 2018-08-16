package airport_javafx_fxml;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Vadim
 */
public class LogonController implements Initializable {
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfUser;
    @FXML
    private Button btnOK;
    @FXML
    private Button btnCancel;

    private void showMessageError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Logon error");
        alert.setHeaderText(null);
        alert.setContentText("Incorrect user name or password!");

        alert.showAndWait();
        tfUser.requestFocus();
    }
    
    @FXML
    private void handleButtonCancel(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void handleButtonOK(ActionEvent event) {
        if (Model.logon(tfUser.getText(), pfPassword.getText())) {
            Stage stage = StageFactory.getStage("MainMenu");
            try {
                stage.setScene(new Scene(new FXMLLoader(getClass().getResource("fxml/MainMenu" + (Model.isAdmin() ? "Admin" : "") + ".fxml")).load()));
                stage.setTitle("Airport");
                stage.setResizable(false);
                stage.setOnCloseRequest(e -> {Platform.exit(); System.exit(0);});
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            StageFactory.getCurrentStage().close();
            StageFactory.removeStage("Logon");
            stage.show();
            
            stage = StageFactory.getStage("UserProperty");
            try {
                stage.setScene(new Scene(new FXMLLoader(getClass().getResource("fxml/UserProperty.fxml")).load()));
                stage.setTitle("New user");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else
            showMessageError();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfUser.setFocusTraversable(true);
        pfPassword.setFocusTraversable(true);
        btnOK.setFocusTraversable(true);
        btnCancel.setFocusTraversable(true);
        tfUser.setText("Vadim");
    }
    
}
