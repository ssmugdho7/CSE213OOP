/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MarketingManagerDashboardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Button logOutButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void requestReimbursementButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void paymentCostChartButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void paymentCostManagementButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void readCustomerRatingButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void identifyRiskFactorsButtonOnClick(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("RiskFactorsReport.fxml"));
        borderPane.setCenter(parent);
    }

    @FXML
    private void tbaButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void attendanceCheckInButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewEmployeeTermsAndPolicyButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event)          {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) logOutButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
