package airport_javafx_fxml;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Vadim
 */
public class User {
    private final SimpleStringProperty name;
    private final SimpleStringProperty role;
    private String hashPass;
    
    public User(String name, int role, String hashPass) {
        this.name = new SimpleStringProperty(name);
        this.role = new SimpleStringProperty(role == 0 ? "Administrator" : "Simple user");
        this.hashPass = hashPass;
    }

    public int getIntRole() {
        return role.get().toLowerCase().equals("administrator") ? 0 : 1;
    }

    public String getRole() {
        return role.get();
    }

    public void setRole(String value) {
        role.set(value);
    }

    public StringProperty roleProperty() {
        return role;
    }
    

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public String gethashPass() {
        return hashPass;
    }

    public StringProperty nameProperty() {
        return name;
    }
    
    @Override
    public boolean equals(Object user) {
        return this.getName().toLowerCase().equals(((User)user).getName().toLowerCase());
    }
}

