/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import Mugdho_2220644.CostEstimation;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdatedRatesAndControlPopularPackagesChartController implements Initializable {

    @FXML
    private TextField packageNameTextField;
    @FXML
    private TextField popularityTextField;
    @FXML
    private TextField speedTextFiled;
    @FXML
    private TextField rateTextField;
    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        
        try{    
            String  packageName =  packageNameTextField.getText();
            float popularity = Float.parseFloat(popularityTextField.getText());
            float speed = Float.parseFloat(speedTextFiled.getText());
            float rate = Float.parseFloat(rateTextField.getText());

        // Creating an instance of Invoice
       // RiskFactors factor = new RiskFactors(riskCategory, riskFactorDescription,  recommendations, assessmentDate);
        PackagesRate packag = new PackagesRate(packageName,  popularity,  speed,  rate);
        boolean addStatus = PackagesRate.addToInstanceToPackagesRate (packag,"PackagesRate.bin");
        //boolean addStatus = MarketingManager.addToInstanceToPackagesRate (packag,"PackagesRate.bin"); 
   
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "PackagesRate  Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid n values for packageName,  popularity,  speed andrate.");
        }
    }
    
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }   

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MarketingManagerDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
//package= new data
//packages= old data