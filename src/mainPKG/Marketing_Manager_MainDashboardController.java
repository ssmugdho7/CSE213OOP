/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Marketing_Manager_MainDashboardController implements Initializable {

    @FXML
    private VBox goalsVBox;
    @FXML
    private Button logoutButton;
    @FXML
    private Button reqReimbursement;
    @FXML
    private Button termsAndPolicy;
    @FXML
    private Button attndnce;
    @FXML
    private Button CostAnalysis;
    @FXML
    private Button ostmanagement;
    @FXML
    private Button CustomerRating;
    @FXML
    private Button riskfactors;
    @FXML
    private Button auditreportView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void reqReimbursementOnClick(ActionEvent event) {
    }

    @FXML
    private void termsAndPolicyOnClick(ActionEvent event) {
    }

    @FXML
    private void attndnceOnClk(ActionEvent event) {
                    try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeAttendance.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) attndnce.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void CostAnalysisOnClk(ActionEvent event) {
    }

    @FXML
    private void ostmanagementOnClk(ActionEvent event) {
    }

    @FXML
    private void CustomerRatingOnClk(ActionEvent event) {
    }

    @FXML
    private void riskfactorsonclk(ActionEvent event) {
    }

    @FXML
    private void auditreportViewOnClk(ActionEvent event) {
    }

}
