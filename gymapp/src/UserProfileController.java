import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserProfileController{

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label pbfLabel;

    @FXML
    private Label bmrLabel;

    @FXML
    private Label pmmLabel;

    @FXML
    private TextField pmmField;

    @FXML
    private TextField pbfField;

    @FXML
    private Button editinfoButton;

    @FXML
    private Label kcallabel;

    @FXML
    private Hyperlink ourgymLink;

    @FXML
    private Hyperlink eathealthyLink;

    @FXML
    private Hyperlink membershipLink;

    private UserProfile currentUser;

    public void updateUser(UserProfile u){
        currentUser = u;
    }

    @FXML
    public void handleEdit(ActionEvent event){
        currentUser.setMMP(Integer.valueOf(pmmField.getText()));
        currentUser.setPBF(Double.valueOf(pbfField.getText()));

        pmmLabel.setText(currentUser.getMMP() + "%");
        pbfLabel.setText(currentUser.getBodyfatpercentage() + "%");

        pmmField.clear();
        pbfField.clear();

        updateUserProfileInDatabase(currentUser);
    }

    @FXML
    public void handleourgymLink(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("OurGym.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Mechanix Muscle Gym");
                stage.setScene(new Scene(root));
                stage.show();

                Stage currentStage = (Stage) ourgymLink.getScene().getWindow();
                currentStage.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
    }


    @FXML
    public void handleeathealthyLink(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EatHealthy.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Mechanix Muscle Gym");
                stage.setScene(new Scene(root));
                stage.show();

                Stage currentStage = (Stage) eathealthyLink.getScene().getWindow();
                currentStage.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
    }

    @FXML
    public void handlemembershipLink(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Membership.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Mechanix Muscle Gym");
                stage.setScene(new Scene(root));
                stage.show();

                Stage currentStage = (Stage) membershipLink.getScene().getWindow();
                currentStage.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void initData(UserProfile userProfile) {
        updateUserProfileInDatabase(userProfile);

        welcomeLabel.setText("Welcome, " + userProfile.getName());
        heightLabel.setText(userProfile.getheight() + " cm");
        ageLabel.setText(userProfile.getage() + "yrs");
        weightLabel.setText(userProfile.getweight() + " kg");
        genderLabel.setText((userProfile.getisMale() ? "Male" : "Female"));
        bmrLabel.setText(userProfile.getBMR() + "kcal");
        pbfLabel.setText(userProfile.getBodyfatpercentage() + "%");
        pmmLabel.setText(userProfile.getMMP() + "%");
    }

    private void updateUserProfileInDatabase(UserProfile userProfile) {
        userProfile.calcBMR();
        
        String url = "jdbc:mysql://127.0.0.1:3306/gymdb";
        String user = "root";
        String dbPassword = "Janjon10!";

        try (Connection connection = DriverManager.getConnection(url, user, dbPassword)) {
            String sql = "UPDATE gymusers SET BMR = ?, MMP = ?, PBF = ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, userProfile.getBMR());
            statement.setInt(2, userProfile.getMMP());
            statement.setDouble(3, userProfile.getBodyfatpercentage());
            statement.setString(4, userProfile.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}