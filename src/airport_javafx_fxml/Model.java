package airport_javafx_fxml;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Vadim
 */
public class Model {
    private static boolean isAdmin = false;
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatementInsertUsers; 
    private static Statement statement;
    private static final String URL = "jdbc:postgresql://localhost:5432/Airport";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "masterkey";
    
    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            preparedStatementInsertUsers = connection.prepareStatement(
                "INSERT into users (name, psw_hash, role) VALUES (?, ?, ?)",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException sqlException) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setContentText("SQLException!");
           
            alert.showAndWait();
           
            sqlException.printStackTrace();
        }
    }
    
    public static String md5(String str) {
        MessageDigest md = null;
        byte[] digest = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(str.getBytes());
            digest = md.digest();
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while(md5Hex.length() < 32 ) {
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }

    public static boolean isAdmin() {
        return isAdmin;
    }
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try {
           statement = connection.createStatement(
                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);
           resultSet = statement.executeQuery("SELECT name, role, psw_hash FROM Users");
            while (resultSet.next())
                users.add(new User(resultSet.getString("name"), resultSet.getInt("role"), resultSet.getString("psw_hash")));
            
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
    
    public static void removeUsers() {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void applyUsers(ObservableList<User> usersList) {
        removeUsers();
        usersList.forEach(e -> {
            try {
                preparedStatementInsertUsers.setString(1, e.getName());
                preparedStatementInsertUsers.setString(2, e.gethashPass());
                preparedStatementInsertUsers.setInt(3, e.getIntRole());
                preparedStatementInsertUsers.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public static boolean logon(String userName, String password) {
        boolean res = false;
        String sql = "SELECT name, psw_hash, role FROM users WHERE lower(name) = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparedStatement.setString(1, userName.toLowerCase());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                res = md5(password).equals(resultSet.getString("psw_hash"));
                if(resultSet.getInt("role") == 0)
                    isAdmin = true;
            }    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return res;
    }
}    