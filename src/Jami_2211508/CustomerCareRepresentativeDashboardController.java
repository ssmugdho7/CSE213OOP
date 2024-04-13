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
public class CustomerCareRepresentativeDashboardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Button CustomerComplain;
    @FXML
    private Button RequestReimnursement;
    @FXML
    private Button AssignDutytoFieldTechnician;
    @FXML
    private Button AssignDutytoNetworkEngineer;
    @FXML
    private Button AssignDutytoTechnicalSupport;
    @FXML
    private Button AttendencAndOvertime;
    @FXML
    private Button TermsPolicy;
    @FXML
    private Button CustomerRatings;
    @FXML
    private MenuBar customerCareDashboardMenuBar;
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
            Logger.getLogger(CustomerCareRepresentativeDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void CustomerComplainButtonOnClick(MouseEvent event) {
        loadUI("CSR View Customer Complain");
    }

    @FXML
    private void RequestReimnursementButtonOnClick(MouseEvent event) {
        loadUI("CSR Request Reimnursement");
    }

    @FXML
    private void AssignDutytoFieldTechnicianButtonOnClick(MouseEvent event) {
        loadUI("CSR Assign Duty to Field Technician");
    }

    @FXML
    private void AssignDutytoNetworkEngineerButtonOnClick(MouseEvent event) {
        loadUI("CSR Assign Duty to Network Engineer");
    }

    @FXML
    private void AssignDutytoTechnicalSupportButtonOnClick(MouseEvent event) {
        loadUI("CSR Assign Duty to Technical Support");
    }

    @FXML
    private void AttendencAndOvertimeButtonOnClick(MouseEvent event) {
        loadUI("CSR Attendence and Overtime");
    }

    @FXML
    private void TermsPolicyButtonOnClick(MouseEvent event) {
        loadUI("CSR View Terms Policy");
    }

    @FXML
    private void CustomerRatingsButtonOnClick(MouseEvent event) {
        loadUI("CSR View Customer Ratings");
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
