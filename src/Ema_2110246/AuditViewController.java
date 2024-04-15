/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import Mugdho_2220644.AuditReport;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AuditViewController implements Initializable {

    @FXML
    private TextArea displayTexxtArea;
    @FXML
    private Button backButton;
 //private ArrayList<AuditReport> reports;
    private List<AuditReport>  reports  = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reports =  AuditReport.readFromFileForAuditReport("auditReport.bin");
        //reports = AuditReport.readFromFileForAuditReport("auditReport.bin");
       //String display = displayTexxtArea.getText ();
       
       if (reports != null && !reports.isEmpty()) {
            StringBuilder displayTextBuilder = new StringBuilder();
            for (AuditReport report : reports) {
                displayTextBuilder.append(report.toString()).append("\n");
            }
            displayTexxtArea.setText(displayTextBuilder.toString());
        } else {
            displayTexxtArea.setText("No audit reports found.");
        }
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
