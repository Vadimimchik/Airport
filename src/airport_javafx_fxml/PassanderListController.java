/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport_javafx_fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Vadim
 */
public class PassanderListController implements Initializable {

    @FXML
    private void handleButtonMainMenu(ActionEvent event) {
        StageFactory.getCurrentStage().close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Model.getCurrentFlightID()+100);
    }    
    
}
