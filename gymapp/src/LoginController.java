import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passField;
    
    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink registerLink;

    @FXML
    private Hyperlink resetLink;

    String url = "jdbc:mysql://127.0.0.1:3306/gymdb";
    String user = "root";
    String dbPassword = "Janjon10!";

    @FXML
    private void handleRegisterLink(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registrationpage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Mechanix Muscle Gym");
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) registerLink.getScene().getWindow();
            currentStage.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleresetLink(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("resetpassword.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Mechanix Muscle Gym");
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) resetLink.getScene().getWindow();
            currentStage.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }    }

    @FXML
    private void handleLogin(ActionEvent event){
        String email = emailField.getText();
        String password = passField.getText();

        if(validCredentials(email, password) != null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("profiledashboard.fxml"));
                Parent root = loader.load();
                UserProfileController controller = loader.getController();
                controller.initData(validCredentials(email, password));
                controller.updateUser(validCredentials(email, password));
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Mechanix Muscle Gym");
                stage.setScene(new Scene(root));
                stage.show();

                Stage currentStage = (Stage) loginButton.getScene().getWindow();
                currentStage.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            errorLabel.setText("Invalid email or password");
            loginButton.setDisable(false);
        }
    }

    private UserProfile validCredentials(String email, String password){
        try (Connection connection = DriverManager.getConnection(url, user, dbPassword)) {
            String sql = "SELECT * FROM gymusers WHERE email = ? AND pass = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()){
                    String userName = resultSet.getString("firstN");
                    String userEmail = resultSet.getString("email");
                    String userPassword = resultSet.getString("pass");
                    int userHeight = resultSet.getInt("height");
                    int userAge = resultSet.getInt("age");
                    float userWeight = resultSet.getFloat("weight");
                    boolean userGender = resultSet.getBoolean("gender");
                    double userBMR = resultSet.getDouble("BMR");
                    int userMMP = resultSet.getInt("MMP");
                    double userPBF = resultSet.getDouble("PBF");

                    UserProfile user = new UserProfile(userName, userEmail, userPassword, userHeight, userAge, userWeight, userGender);
                    user.setMMP(userMMP);
                    user.setPBF(userPBF);
                    user.calcBMR();

                    return user;
                }
                else{
                    return null;
                }
            }
        } 
        catch (SQLException e) {
            errorLabel.setText(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}