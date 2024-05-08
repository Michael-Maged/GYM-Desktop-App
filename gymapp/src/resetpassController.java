import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class resetpassController {
    @FXML
    private Button resetpassLink;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label errorLabel;


    
    String url = "jdbc:mysql://127.0.0.1:3306/gymdb";
    String user = "root";
    String dbPassword = "Janjon10!";

    String email = emailField.getText();
    String password = passField.getText();

    @FXML
    private void handleresetpass(ActionEvent event){
        try (Connection connection = DriverManager.getConnection(url, user, dbPassword)) {
            String sql = "update users set pass = ? where email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, email);
            
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("loginpage.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Mechanix Muscle Gym");
                    stage.setScene(new Scene(root));
                    stage.show();
    
                    Stage currentStage = (Stage) resetpassLink.getScene().getWindow();
                    currentStage.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }            
            } 
            else {
                errorLabel.setText("Email not found in the database: ");
            }
        } 
        catch (SQLException e) {
            errorLabel.setText(e.getMessage());
            e.printStackTrace();
        }
    }

}
