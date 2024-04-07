/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

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
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ManagingDirectorDashboardController implements Initializable {

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
    private void readPayrollDataButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void readAuditReportButtonOnClick(ActionEvent event) throws IOException {
    
     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewAuditReport.fxml"));
        Parent parent = fxmlLoader.load();

        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);

        Stage stage = new Stage();
        stage.setTitle("Read Audit Report");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
    
    }

    @FXML
    private void readProcessedReimbursementButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewSuggestionOfCostManagementButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void paymentCostChartAnalysisButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void readRiskFactorsofCompanyButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void writeTermsAndPolicyForEmployeesButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void writeTermsAndPolicyForCustomerButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {
    }
    
}
