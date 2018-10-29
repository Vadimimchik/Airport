package airport_javafx_fxml;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Vadim
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        StageFactory.registerStage(stage, "Logon");
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("fxml/Logon.fxml")));
            stage.setScene(scene);
            stage.setTitle("Airport");
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
