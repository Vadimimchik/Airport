/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport_javafx_fxml;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Vadim
 */
public class DA {
    private final int ID;
    private final SimpleStringProperty flight;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;
    private final SimpleStringProperty city;
    private final SimpleStringProperty company;
    private final SimpleStringProperty terminal;
    private final SimpleStringProperty gate;

    public DA(int ID, String flight, String date, String time, String city, String company, String terminal, String gate) {
        this.ID = ID;
        this.flight = new SimpleStringProperty(flight);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.city = new SimpleStringProperty(city);
        this.company = new SimpleStringProperty(company);
        this.terminal = new SimpleStringProperty(terminal);
        this.gate = new SimpleStringProperty(gate);
    }

    public int getID() {
        return ID;
    }
    
    public String getFlight() {
        return flight.get();
    }

    public void setFlight(String value) {
        flight.set(value);
    }

    public StringProperty flightProperty() {
        return flight;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String value) {
        date.set(value);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getTime() {
        return time.get();
    }

    public void setTime(String value) {
        time.set(value);
    }
    
    public StringProperty timeProperty() {
        return time;
    }
    
    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String value) {
        city.set(value);
    }

    public String getCompany() {
        return company.get();
    }

    public StringProperty companyProperty() {
        return company;
    }

    public void setCompany(String value) {
        company.set(value);
    }

    public String getTerminal() {
        return terminal.get();
    }

    public void setTerminal(String value) {
        terminal.set(value);
    }

    public StringProperty terminalProperty() {
        return terminal;
    }

    public String getGate() {
        return gate.get();
    }

    public void setGate(String value) {
        gate.set(value);
    }

    public StringProperty gateProperty() {
        return gate;
    }

    @Override
    public String toString() {
        return "DA{" + "flight=" + flight + ", date=" + date + ", time=" + time + ", city=" + city + ", company=" + company + ", terminal=" + terminal + ", gate=" + gate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.flight);
        hash = 59 * hash + Objects.hashCode(this.date);
        hash = 59 * hash + Objects.hashCode(this.time);
        hash = 59 * hash + Objects.hashCode(this.city);
        hash = 59 * hash + Objects.hashCode(this.company);
        hash = 59 * hash + Objects.hashCode(this.terminal);
        hash = 59 * hash + Objects.hashCode(this.gate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DA other = (DA) obj;
        if (!Objects.equals(this.flight, other.flight)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.terminal, other.terminal)) {
            return false;
        }
        if (!Objects.equals(this.gate, other.gate)) {
            return false;
        }
        return true;
    }
    
    
}
