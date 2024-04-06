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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
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
    @FXML
    private PieChart PIECHARTCUSTOMERRATINGS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void requestReimbursementButtonOnClick(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RequestReimbursementPayment.fxml"));
        Parent parent = fxmlLoader.load();

        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);

        Stage stage = new Stage();
        stage.setTitle("Request Reimbursement Payment ");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
        
        
    }
        

    @FXML
    private void paymentCostChartButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void paymentCostManagementButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void WriteupdatedRatesAndcontrolPipularpackageChartchart(ActionEvent event) {
    }

    @FXML
    private void identifyRiskFactorsButtonOnClick(ActionEvent event) {
        
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
    private void logOutButtonOnClick(ActionEvent event) {
        
       
    }

    @FXML
    private void viewAuditOnClk(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewAuditReport.fxml"));
        Parent parent = fxmlLoader.load();

        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);

        Stage stage = new Stage();
        stage.setTitle("Audit report view");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
    }
    
}
