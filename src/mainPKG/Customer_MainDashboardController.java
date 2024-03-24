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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Customer_MainDashboardController implements Initializable {

    @FXML
    private Button paybill;
    @FXML
    private Button paymenthistory;
    @FXML
    private Button viewandmodiservice;
    @FXML
    private Button ompissues;
    @FXML
    private Button sessionlogreopo;
    @FXML
    private Button acessserver;
    @FXML
    private Button checkwifispeed;
    @FXML
    private Button feedback;
    @FXML
    private Button logOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlePayBillButtonClick(ActionEvent event) {
    }

    @FXML
    private void handlePaymentHistoryButtonClick(ActionEvent event) {
    }

    @FXML
    private void handleServicePlanButtonClick(ActionEvent event) {
    }

    @FXML
    private void handleComplaintButtonClick(ActionEvent event) {
    }

    @FXML
    private void handleSessionLogButtonClick(ActionEvent event) {
    }

    @FXML
    private void handleAccessServersButtonClick(ActionEvent event) {
    }

    @FXML
    private void handleCheckSpeedButtonClick(ActionEvent event) {
    }

    @FXML
    private void handleFeedbackButtonClick(ActionEvent event) {
    }

    @FXML
    private void handleLogoutButtonClick(ActionEvent event) {
                        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) logOut.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
}
