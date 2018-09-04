package airport_javafx_fxml;


import airport_javafx_fxml.StageFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vadim
 */
public class MainMenuController implements Initializable {
    @FXML
    private Button btnDepartures;
    @FXML
    private Button btnArrivals;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnUsersConfiguration;
    @FXML
    private AnchorPane acMainMenu;
    
    private static String txtLbl;
    private static boolean isArrival  = false;
    
    static String getTxtLbl(){
        return txtLbl;
    }

    static boolean isArrival(){
        return isArrival;
    }

    @FXML
    private void handleButtonCancel(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    private void handleButton(ActionEvent event) {
        String path = null;
        if (event.getSource().equals(btnDepartures) || event.getSource().equals(btnArrivals)) {
            if (event.getSource().equals(btnDepartures)) {
                txtLbl =  "Departure";
                isArrival = false;
            } else {
                txtLbl = "Arrival";
                isArrival = true;
            }
            path = "fxml/DAView.fxml";
        } else {
            txtLbl = "Users";
            path = "fxml/Users.fxml";
        }
        Stage stage = StageFactory.getStage(txtLbl); 
        try {
            stage.setScene(new Scene(new FXMLLoader(getClass().getResource(path)).load()));
            stage.setTitle(txtLbl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
