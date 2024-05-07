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
public class Membership {
    @FXML
    private Hyperlink ourgymLink;

    @FXML
    private Hyperlink eathealthyLink;

    @FXML
    private Hyperlink myprofileink;

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
    public void handlemyprofileLink(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Profiledashboard.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Mechanix Muscle Gym");
                stage.setScene(new Scene(root));
                stage.show();

                Stage currentStage = (Stage) myprofileinkLink.getScene().getWindow();
                currentStage.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
    }
}
