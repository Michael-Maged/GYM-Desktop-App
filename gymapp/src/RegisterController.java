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
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterController {
    
    @FXML
    private TextField ageField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField weightField;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private RadioButton femaleRadio;
    
    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button registerButton;

    String url = "jdbc:mysql://127.0.0.1:3306/gymdb";
    String user = "root";
    String dbPassword = "Janjon10!";

    @FXML
    private void handleRegister(ActionEvent event){
        String email = emailField.getText().toLowerCase();
        String password = passField.getText();
        String firstN = firstNameField.getText();
        String lastN = lastNameField.getText();
        boolean isMale = false;
        if (maleRadio.isSelected()){
            isMale = true;
        }
        else if(femaleRadio.isSelected()){
            isMale = false;
        }
        int age = Integer.valueOf(ageField.getText());
        int height = Integer.valueOf(heightField.getText());
        float weight = Float.valueOf(weightField.getText());

        if (!verifyEmail(email)) {
            errorLabel.setText("Invalid email");
            registerButton.setDisable(false);
        }

        if (!passLen(password)) {
            errorLabel.setText("Password too short");
            registerButton.setDisable(false);
        }

        try (Connection connection = DriverManager.getConnection(url, user, dbPassword)) {
            String sql = "INSERT INTO gymusers (firstN, lastN, email, pass, age, gender, weight, height) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstN);
            statement.setString(2, lastN);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, age);
            statement.setBoolean(6, isMale);
            statement.setFloat(7, weight);
            statement.setInt(8, height);
            
            int rowsInserted = statement.executeUpdate();
            
            if (rowsInserted > 0) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("loginpage.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setTitle("Mechanix Muscle Gym");
                    stage.setScene(new Scene(root));
                    stage.show();
    
                    Stage currentStage = (Stage) registerButton.getScene().getWindow();
                    currentStage.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            } 
            else {
                registerButton.setDisable(false);
            }

        } 
        catch (SQLException e) {
            errorLabel.setText("Email already in use");
            e.printStackTrace();
        }
    }

    private static boolean verifyEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(email);

        if (m.matches()) {
            return true;
        } 
        else {
            return false;
        }
    }

    private static boolean passLen(String password) {
        return password.length() >= 6;
    }
}