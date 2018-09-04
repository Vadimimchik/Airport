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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Vadim
 */
public class UsersController implements Initializable {
    @FXML
    TableView<User> tableUsers;
    @FXML
    TableColumn<User, String> colUser;
    @FXML
    TableColumn<User, String> colRole;
    
    static ObservableList<User> users = FXCollections.observableArrayList();
    static ObservableList<User> etalonUsers = FXCollections.observableArrayList();
    
    @FXML
    private void handleDragDroped(ActionEvent event) {
        System.out.println("handleDragDroped");
    }
    
    @FXML
    private void handleButtonMainMenu(ActionEvent event) {
        StageFactory.getCurrentStage().close();
    }
    
    @FXML
    private void handleButtonAdd(ActionEvent event) {
        StageFactory.getStage("UserProperty").show();
    }

    @FXML
    private void handleButtonRemove(ActionEvent event) {
        users.remove(tableUsers.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void handleButtonApply(ActionEvent event) {
        if (!etalonUsers.equals(users))
            Model.applyUsers(users);
    }

    @FXML
    private void handleClickOnTable(MouseEvent event) {
        if (event.getClickCount() == 2) {
            System.out.println(tableUsers.getSelectionModel().getSelectedItem());
        }      
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        tableUsers.setEditable(true);
//        colUser.setCellFactory(TextFieldTableCell.forTableColumn());
//        ObservableList<String> roles = FXCollections.observableArrayList();
//        roles.add("Administrator");
//        roles.add("Simple user");
//        colRole.setCellFactory(ComboBoxTableCell.forTableColumn(roles));
        users.clear();
        colUser.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colRole.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        users.addAll(Model.getUsers());
        etalonUsers.addAll(users);
        tableUsers.setItems(users);
    }    
   
}
