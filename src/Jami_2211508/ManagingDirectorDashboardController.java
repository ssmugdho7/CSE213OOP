/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ManagingDirectorDashboardController implements Initializable {

    @FXML
    private Button ViewPayrollData;
    @FXML
    private Button ViewAuditReport;
    @FXML
    private Button ViewReimbursementProcess;
    @FXML
    private Button WriteTermsPolicy;
    @FXML
    private Button ViewExtimatedCostButton;
    @FXML
    private Button ViewRiskFactorsButton;
    @FXML
    private Button ViewAttendenceOvertimeButton;
    @FXML
    private Button suggestionsforchangesButton;
    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar managingDirectorDashboardMenuBar;
    @FXML
    private Button logOutButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            borderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(ManagingDirectorDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void ViewPayrollDataOnClick(MouseEvent event) {
        loadUI("MD View Payroll Data");
    }

    @FXML
    private void ViewAuditReportOnClick(MouseEvent event) {
        loadUI("MD View Audit Report");
    }

    @FXML
    private void ViewReimbursementProcessOnClick(MouseEvent event) {
        loadUI("MD View Reimbursement Process");
    }

    @FXML
    private void WriteTermsPolicyOnClick(MouseEvent event) {
        loadUI("MD Write Terms Policy");
    }

    @FXML
    private void ViewExtimatedCostButtonOnClick(MouseEvent event) {
        loadUI("MD View Extimated Cost");
    }

    @FXML
    private void ViewRiskFactorsButtonOnClick(MouseEvent event) {
        loadUI("MD View Risk Factors");
    }

    @FXML
    private void ViewAttendenceOvertimeButtonOnClick(MouseEvent event) {
        loadUI("MD View Attendence Overtime");
    }

    @FXML
    private void suggestionsforchangesButtonOnClick(MouseEvent event) {
        loadUI("MD suggestions for changes");
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainPKG/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage currentStage = (Stage) logOutButton.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
}
