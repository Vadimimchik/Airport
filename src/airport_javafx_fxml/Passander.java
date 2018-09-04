package airport_javafx_fxml;

import javafx.beans.property.SimpleStringProperty;

public class Passander {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty passport;

    public Passander(String firstName, String lastName, String passport) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.passport = new SimpleStringProperty(passport);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getPassport() {
        return passport.get();
    }

    
    
    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public SimpleStringProperty passportProperty() {
        return passport;
    }
    
    
}
