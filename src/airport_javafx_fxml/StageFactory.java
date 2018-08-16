package airport_javafx_fxml;

import java.util.HashMap;
import javafx.stage.Stage;

/**
 *
 * @author Vadim
 */
public class StageFactory {
    private static final HashMap<String, Stage> OPEN_STAGES = new HashMap<>();
    private static Stage currentStage;

    public static Stage getStage(String name) {
        Stage stage = OPEN_STAGES.get(name.toLowerCase());
        return stage == null ? createStage(name) : stage;
    }

    public static void removeStage(String name) {
        OPEN_STAGES.remove(name.toLowerCase());
    }    
    
    public static Stage getCurrentStage() {
        return currentStage;
    }
    
    public static void registerStage(Stage stage, String name) {
        OPEN_STAGES.put(name.toLowerCase(), stage);
        stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> currentStage = isNowFocused ? stage : null);
    }

    private static Stage createStage(String name) {
        Stage stage = new Stage();
        registerStage(stage, name);
        return stage ;
    }
}
