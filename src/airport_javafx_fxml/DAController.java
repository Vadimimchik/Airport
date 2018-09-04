package airport_javafx_fxml;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    private TableView<DA> tvDA;
    @FXML
    private TableColumn<DA, String> colFlight;
    @FXML
    private TableColumn<DA, String> colDate;
    @FXML
    private TableColumn<DA, String> colTime;
    @FXML
    private TableColumn<DA, String> colCity;
    @FXML
    private TableColumn<DA, String> colCompany;
    @FXML
    private TableColumn<DA, String> colTerminal;
    @FXML
    private TableColumn<DA, String> colGate;
    @FXML
    private Button btnPassengars;

    private static boolean isArrival;

    @FXML
    private void handleButtonMainMenu(ActionEvent event) {
        StageFactory.getCurrentStage().close();
    }

    @FXML
    private void handleButtonOK(ActionEvent event) {
        tvDA.setItems(FXCollections.observableArrayList(Model.getDAs(isArrival, beginDate.getValue(), endDate.getValue())));
    }

    @FXML
    private void handleKeyMainMenu(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE)
            StageFactory.getCurrentStage().close();
    }

    @FXML
    private void handleButtonPassengars(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblDA.setText(MainMenuController.getTxtLbl());
        beginDate.setValue(LocalDate.now());
        endDate.setValue(LocalDate.now());
        
        colFlight.setCellValueFactory(cellData -> cellData.getValue().flightProperty());
        colDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        colTime.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        colCity.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        colCompany.setCellValueFactory(cellData -> cellData.getValue().companyProperty());
        colTerminal.setCellValueFactory(cellData -> cellData.getValue().terminalProperty());
        colGate.setCellValueFactory(cellData -> cellData.getValue().gateProperty());

        isArrival = MainMenuController.isArrival();
        tvDA.setItems(FXCollections.observableArrayList(Model.getDAs(isArrival, beginDate.getValue(), endDate.getValue())));
        if (!isArrival)
            tvDA.getColumns().remove(colGate);
        btnPassengars.setVisible(Model.isAdmin());
    }    
    
}
