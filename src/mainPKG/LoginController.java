package mainPKG;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private Button login;
    @FXML
    private Button signupButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Accountant", "Customer",
                "Field Technician", "Marketing Manager", "Customer Care Representative",
                 "Managing Director", "Technical Support Representative", "Network Engineer");
        //defaultIdpass
        userIdTextField.setText("test");
        passwordTextField.setText("1234");
    }    

    @FXML
    private void forgotPasswordButtonOnClick(ActionEvent event) {
        
       
        
        
    }

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        
          String userType = userTypeComboBox.getValue();
        if (userType == null) {
            showErrorAlert("Error", "Please select a user type.");
            return;
        }

        String username = userIdTextField.getText();
        String password = passwordTextField.getText();

        boolean isValidLogin = SignUpFile.SignUpFileRead(userType, username, password);

        if (isValidLogin) {

            String userFullName = SignUpFile.FileRead_forUserName(userType, username, password);

            Stage currentStage = (Stage) login.getScene().getWindow();
            if (userType.equals("Customer")) {
                //SceneChange newScene= new SceneChange();
                //newScene.Scenechanger(currentStage, "User_1_MainDashboard.fxml");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mugdho_2220644/CustomerDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Accountant")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mugdho_2220644/AccountantDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Field Technician")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ema_2110246/FieldTechnicianDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Marketing Manager")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ema_2110246/MarketingManagerDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Customer Care Representative")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Jami_2211508/CustomerCareRepresentative_MainDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Managing Director")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Jami_2211508/CustomerCareRepresentative_MainDashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Technical Support Representative")) {
//                SceneChange newScene = new SceneChange();
//                newScene.Scenechanger(currentStage, "Efficient_Support_Representative_MainDashboard.fxml");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tasin_2211161/TechnicalSupportRepresentativeDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            
            
            
            }
            if (userType.equals("Network Engineer")) {
//                SceneChange newScene = new SceneChange();
//                newScene.Scenechanger(currentStage, "Network_Engineer_MainDashboard.fxml");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tasin_2211161/NetworkEngineerDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            
            
            }
        } else {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Unable to Login");
            a.setContentText("UserID and Password is Invalid");
            a.showAndWait();

        }
        
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) signupButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
     private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
    
} 



