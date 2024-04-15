/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import Mugdho_2220644.AuditReport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;



public class ViewAuditReportController implements Initializable {

    @FXML
    private TextArea displayTexxtArea;
    
    @FXML
    private Button loadAudit;
    //private List<AuditReport> reports  = new ArrayList<>();
   private ArrayList<AuditReport> reports;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //List<AuditReport> reports = AuditReport.readFromFileForAuditReport("AuditReport.bin");

       // Populate ComboBox with report titles
       // for (AuditReport report : reports) {
           // checkauditComboBix.getItems().add(report.getTitle());
       //}
       //reports = AuditReport.readFromFileForAuditReport("auditReport.bin");
       String display = displayTexxtArea.getText ();
       //displayTexxtArea.setText(reports);
       displayTexxtArea.setText(reports.toString());
    }   // packs = PackargesRate.readFromFileToPackagesRate("PackagesRate.bin");

    @FXML
    private void loadAuditOnClick(ActionEvent event) {
       /* List<AuditReport> reports = AuditReport.readFromFileForAuditReport("auditReport.bin"); // For debugging purposes
        if (!reports.isEmpty()) {
            displayTexxtArea.clear();
            for (AuditReport report : reports) {
                displayTexxtArea.appendText(report.toString() + "\n\n");
            }
        } else {
            showAlert(Alert.AlertType.INFORMATION, "No Reports", "No audit reports found.");
        }
        //displayTexxtArea.setText(reports.toString());
        
    }
      private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();*/
       //String display = displayTexxtArea.getText ();
       //displayTexxtArea.setText(reports.toString());
       
       
    }







}
        
        
        
        

        
 
       //displayTexxtArea.clear();
      // List<AuditReport> reports = AuditReport.readFromFileForAuditReport("AuditReport.bin");
      // Load audit reports from file
      //List<AuditReport> reports = AuditReport.readFromFileForAuditReport("AuditReport.bin");
      // Display audit reports in the text area
      //if (!reports.isEmpty()) {
         // for (AuditReport report : reports) {
             // displayTexxtArea.appendText(report.toString() + "\n\n")}
      //} else {
         // showAlert(Alert.AlertType.INFORMATION, "No Reports", "No audit reports found.");
      //}


      //displayTexxtArea.setText(report.toString());

       // Fetch selected report
        //AuditReport selectedReport = null;
       // Iterable<AuditReport> reports = null;
        //for (AuditReport report : reports) {
           // if (!report.getTitle().equals(selectedTitle)) {
            //} else {
                //selectedReport = report;
                //break;
        //    //}
        //}
       // Display selected report in TextArea
       //if (selectedReport != null) {
        // displayTexxtArea.setText(selectedReport.toString());
       // }// Call a method to load AuditReport objects from file
    //List<AuditReport> reports = AuditReport.readFromFileForAuditReport("auditReport.bin");
    
    // Display content in text areas
   //if (!reports.isEmpty()) {
       // AuditReport firstReport = reports.get(0);
// Assuming you want to display the first loaded report
        ///String title = TitleTextFeild.getText();
        //String findings = FindingsTextArea.getText();
       // String recommendations = RecomendationTextArea.getText();
       // String comments = CommentsTextArea.getText();
        //LocalDate date = auditDate.getValue();

        //AuditReport firstReport = reports.get(0);
        //TitleTextFeild.setText(firstReport.getTitle());
       // FindingsTextArea.setText(firstReport.getFindings());
        //RecomendationTextArea.setText(firstReport.getRecommendations());
       // CommentsTextArea.setText(firstReport.getComments());
        //auditDate.setValue(firstReport.getAuditDate());
    //}// else {
        //showAlert(Alert.AlertType.ERROR, "Error", "No audit reports found.");
    //}

    //private void showAlert(AlertType alertType, String no_Reports, String no_audit_reports_found) {
   //     throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  //  }
//}   
        
     
        

   // private void showAlert(String title, String message) {
    //    Alert alert = new Alert(AlertType.ERROR);
       /// alert.setTitle(title);
       // alert.setHeaderText(null);
       // alert.setContentText(message);
       // alert.showAndWait();
    
   // }

    //private void showAlert(AlertType alertType, String error, String no_audit_reports_found) {
   //     throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   // }
    

