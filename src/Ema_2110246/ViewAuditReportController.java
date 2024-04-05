/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import Mugdho_2220644.AuditReport;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;


public class ViewAuditReportController implements Initializable {

    @FXML
    private TextArea displayTexxtArea;
    @FXML
    private ComboBox<String> checkauditComboBix;
 private ArrayList<AuditReport> reports;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                reports = AuditReport.readFromFile("AuditReport.bin");

        // Populate ComboBox with report titles
        for (AuditReport report : reports) {
            checkauditComboBix.getItems().add(report.getTitle());
        }
    }    

    @FXML
    private void loadAuditOnClick(ActionEvent event) {
        if (checkauditComboBix.getSelectionModel().isEmpty()) {
            showAlert("Error", "Please select a report.");
            return;
        }

        // Fetch selected report
        String selectedTitle = checkauditComboBix.getSelectionModel().getSelectedItem();
        AuditReport selectedReport = null;
        for (AuditReport report : reports) {
            if (report.getTitle().equals(selectedTitle)) {
                selectedReport = report;
                break;
            }
        }

        // Display selected report in TextArea
        if (selectedReport != null) {
            displayTexxtArea.setText(selectedReport.toString());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    
    }
    
}
