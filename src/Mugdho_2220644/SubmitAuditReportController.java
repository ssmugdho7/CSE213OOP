/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SubmitAuditReportController implements Initializable {

    @FXML
    private TextField TitleTextFeild;
    @FXML
    private TextArea FindingsTextArea;
    @FXML
    private TextArea RecomendationTextArea;
    @FXML
    private TextArea CommentsTextArea;
    @FXML
    private DatePicker auditDate;
//    private List<AuditReport> report = new ArrayList<>();
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
    private void SubMitButtoNOnClk(ActionEvent event) {
     
      try{  
        String title = TitleTextFeild.getText();
        String findings = FindingsTextArea.getText();
        String recommendations = RecomendationTextArea.getText();
        String comments = CommentsTextArea.getText();
        LocalDate date = auditDate.getValue();

        AuditReport report = new AuditReport(title, findings, recommendations, comments, date);
        boolean addStatus = AuditReport.addToInstanceForAuditReport(report, "auditReport.bin");

        if (addStatus) {
            showAlert(Alert.AlertType.INFORMATION, "Success", "Audit Report Added Successfully!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
        }
      }
    catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numeric values for Customer ID and Amount.");
    }
    }



private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }  


//        // Validate if all fields are filled
//        if (title.isEmpty() || findings.isEmpty() || recommendations.isEmpty() || comments.isEmpty() || date == null) {
//            showAlert("Error", "Please fill in all fields before submitting.");
//            return;
//        }
//
//        // Validate character limits
//        if (!isValidLength(title, 25) || !isValidLength(findings, 100) || !isValidLength(recommendations, 100) || !isValidLength(comments, 100)) {
//            showAlert("Error", "Input length exceeds limit.");
//            return;
//        }
//
//        // Validate date
//        if (date.isAfter(LocalDate.now())) {
//            showAlert("Error", "Audit date cannot be in the future.");
//            return;
//        }
//
//        // If all validations pass, create AuditReport object and add it to the ArrayList
//        AuditReport report = new AuditReport(title, findings, recommendations, comments, date);
//        reports.add(report);
//
//        // Write ArrayList to file
//        AuditReport.writeToFileForAuditReport(reports, "AuditReport.bin");
//
//        // Clear all fields after submission
//        clearFields();
//    }
//
//    private void clearFields() {
//        TitleTextFeild.clear();
//        FindingsTextArea.clear();
//        RecomendationTextArea.clear();
//        CommentsTextArea.clear();
//        auditDate.setValue(null);
//    }
//
//    private boolean isValidLength(String text, int maxLength) {
//        return text.length() <= maxLength;
//    }
//
//    private void showAlert(String title, String message) {
//        Alert alert = new Alert(AlertType.ERROR);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
