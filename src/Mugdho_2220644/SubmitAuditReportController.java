/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SubmitAuditReportController implements Initializable {

    @FXML
    private TextField TitleTextFeild;
    @FXML
    private DatePicker auditDate;
    @FXML
    private TextArea findingsTextArea;
    @FXML
    private TextArea recommendationsTextArea;
    @FXML
    private TextArea commentsTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
       
        String reportTitle = TitleTextFeild.getText().trim();
        String reportFindings = findingsTextArea.getText().trim();
        LocalDate reportDate = auditDate.getValue(); 
 String reportRecommendations =  recommendationsTextArea.getText(); 
        String reportComments =   commentsTextArea.getText();
        
        
        
        if (isValidInput(reportTitle, reportFindings,reportRecommendations,reportComments)) {
//            Accountant.saveAuditReport(reportTitle, reportDescription);
//            generatePDF(reportTitle, reportDescription);
            showConfirmationAlert("Report submitted successfully.");
            clearFields();
        } 
        
        else {
            showErrorAlert("Invalid input. Please check title and description.");
            clearFields();
        }
   
    }
    
   public boolean isValidInput(String reportTitle, String reportFindings,String reportRecommendations,String reportComments) 
   {
        return reportTitle.length() > 0 && reportFindings.length() >0 && reportRecommendations.length() >0 && reportComments.length() >0;
    }

    private void showConfirmationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        TitleTextFeild.clear();
        findingsTextArea.clear();
        recommendationsTextArea.clear();
        commentsTextArea.clear();
    
    } 
}

 
