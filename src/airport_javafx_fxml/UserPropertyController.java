/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport_javafx_fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Vadim
 */
public class UserPropertyController implements Initializable {
    @FXML
    ComboBox cbUserRole;
    @FXML
    Button btnUserOK;
    @FXML
    Button btnUserCancel;
    @FXML
    TextField tfUserUser;
    
    private void showMessageError(String textError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("User error");
        alert.setHeaderText(null);
        alert.setContentText(textError);

        alert.showAndWait();
        tfUserUser.requestFocus();
    }

    @FXML
    private void handleButtonUser(ActionEvent event) {
        if (event.getSource().equals(btnUserOK)) {
            String name = tfUserUser.getText();
            if (name == null || name.trim().equals("")) {
                showMessageError("Enter user name!");
            } else {
                int role = cbUserRole.getValue().equals("Administrator") ? 0 : 1;
                User user = new User(name, role, Model.md5(""));
                if (UsersController.users.contains(user)) {
                    showMessageError("User alredi exists!");
                } else {
                    UsersController.users.add(user);
                    StageFactory.getCurrentStage().close();
                }
            }
        } else if (event.getSource().equals(btnUserCancel)) {
            StageFactory.getCurrentStage().close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> comboOptions = FXCollections.observableArrayList();
        comboOptions.add("Simple user");
        comboOptions.add("Administrator");
        cbUserRole.setItems(comboOptions); 
        cbUserRole.setValue("Simple user");
    }    
}
