/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AccountantDashboardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Button logOutButton;
    @FXML
    private Label ReimbursementreqOutputLabel;
    @FXML
    private BarChart<?, ?> employeeAttendenceBarChart;
    @FXML
    private ComboBox<?> monthComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewReimbursementButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void processReimbursementButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void writePayrollButtonOnClick(ActionEvent event) throws IOException{
      Parent parent = FXMLLoader.load(getClass().getResource("PayrollProcessing.fxml"));
        borderPane.setCenter(parent);

    
    }

    @FXML
    private void writeAuditReportButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void generateInvoiceButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void estimateCostAnalysisButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewAttendanceButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void employeeTermsAndPolicyButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void loadBarChartOnClk(ActionEvent event) {
    }
    
}
