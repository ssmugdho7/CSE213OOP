/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RiskFactorsReportController implements Initializable {

    @FXML
    private TextArea riskFactorDescriptionTextArea;
    @FXML
    private ComboBox<String> riskCategoryComboBox;
    @FXML
    private DatePicker assessmentDateDatePicker;
    @FXML
    private TextArea recommendationsTextArea;
    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;
    private Object MarketingManagerDashboard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        riskCategoryComboBox.getItems().addAll("Financial Risk", "Business Operations Risk","Strategy Troubles","Rule Compliance Risk","Reputation Risk","Other");
        DateTimeFormatter customDateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        assessmentDateDatePicker.setValue(LocalDate.now());
        assessmentDateDatePicker.setConverter(new LocalDateStringConverter(customDateFormat, null));
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        
        try{
        
        String riskCategory =riskCategoryComboBox.getValue();
        String riskFactorDescription = riskFactorDescriptionTextArea.getText();
        String recommendations = recommendationsTextArea.getText ();
        LocalDate assessmentDate =assessmentDateDatePicker.getValue();
        
        
   
   
   RiskFactors factor = new RiskFactors(riskCategory, riskFactorDescription,  recommendations, assessmentDate);
     
   
  
   boolean addStatus =  RiskFactors.addToInstanceToRiskFactors(factor," RiskFactors.bin"); //file writing
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", " RiskFactors Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid  values for riskCategory, riskFactorDescription, recommendations and assessmentDate.");
        }
    }
     private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();

    
    }
    //process = new data 
    //processes = old data
     //attendence= new data
     //attdences= old data
    //support= new support 
    // supports= old support
    
    //suppt= new support 
    // suppts= old supp
     
     // factor = new factor
    // factors = old factor
    

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
