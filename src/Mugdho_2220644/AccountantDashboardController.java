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
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    private BarChart<Employee, ?> employeeAttendenceBarChart;
    @FXML
    private ComboBox<String> monthComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       monthComboBox.getItems().addAll(
    "January", "February", "March", "April", "May", "June", 
    "July", "August", "September", "October", "November", "December"
);
    }    

    @FXML
    private void viewReimbursementButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewReimbursementRequests.fxml"));
        Parent parent = fxmlLoader.load();
        
        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);
        
        Stage stage = new Stage();
        stage.setTitle("View Reimbursement");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
    }


    @FXML
    private void processReimbursementButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProcessReimbursement.fxml"));
        Parent parent = fxmlLoader.load();
        
        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);
        
        Stage stage = new Stage();
        stage.setTitle("Process Reimbursement");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
    }

    @FXML
    private void writePayrollButtonOnClick(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PayrollProcessing.fxml"));
        Parent parent = fxmlLoader.load();
        
        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);
        
        Stage stage = new Stage();
        stage.setTitle("Payroll Processing");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
    }
    @FXML
    private void writeAuditReportButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SubmitAuditReport.fxml"));
        Parent parent = fxmlLoader.load();
        
        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);
        
        Stage stage = new Stage();
        stage.setTitle("Submit Audit");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
    }

    @FXML
    private void generateInvoiceButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Generate Invoice.fxml"));
        Parent parent = fxmlLoader.load();
        
        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);
        
        Stage stage = new Stage();
        stage.setTitle("GenerateInvoice");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
    }


    @FXML
    private void estimateCostAnalysisButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EstimateCostAnalysis.fxml"));
        Parent parent = fxmlLoader.load();
        
        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);
        
        Stage stage = new Stage();
        stage.setTitle("EstimateCostAnalysis");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
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
    private void logOutButtonOnClick(ActionEvent event) {        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage currentStage = (Stage) logOutButton.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void loadBarChartOnClk(ActionEvent event) {
    }
    
}
