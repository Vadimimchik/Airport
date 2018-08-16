package airport_javafx_fxml;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Vadim
 */

public class DAController implements Initializable {
    @FXML
    private Label lblDA;
    @FXML
    private DatePicker beginDate;
    @FXML
    private DatePicker endDate;

    @FXML
    private void handleButtonMainMenu(ActionEvent event) {
        StageFactory.getCurrentStage().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblDA.setText(MainMenuController.getTxtLbl());
        beginDate.setValue(LocalDate.now());
        endDate.setValue(LocalDate.now());
    }    
    
}
