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

public class EatHealthyController {
    @FXML
    private Hyperlink ourgymLink;

    @FXML
    private Hyperlink myprofileLink;

    @FXML
    private Hyperlink membershipLink;

    @FXML
    public void handleourgymLink(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("OurGym.fxml"));
                Parent root = loader.load();
                Stage currentStage = (Stage) ourgymLink.getScene().getWindow();
                currentStage.setScene(new Scene(root));
                currentStage.setTitle("Mechanix Muscle Gym");
                currentStage.setResizable(false);
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
    }


    @FXML
    public void handlemyprofileLink(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("profiledashboard.fxml"));
                Parent root = loader.load();
                //UserProfileController controller = loader.getController();
                //controller.initData(currentUser);
                Stage currentStage = (Stage) myprofileLink.getScene().getWindow();
                currentStage.setScene(new Scene(root));
                currentStage.setTitle("Mechanix Muscle Gym");
                currentStage.setResizable(false);
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
                Stage currentStage = (Stage) membershipLink.getScene().getWindow();
                currentStage.setScene(new Scene(root));
                currentStage.setTitle("Mechanix Muscle Gym");
                currentStage.setResizable(false);
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
    }

}
