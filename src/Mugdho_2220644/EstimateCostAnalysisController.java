/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;


import java.io.IOException;
import java.io.Serializable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EstimateCostAnalysisController implements Initializable,Serializable {
    
//    private ArrayList<CostEstimation> costEstimations = new ArrayList<>();
//    private final String fileName = "costEstimation.bin";

    @FXML
    private TextField subscriberTextField;

    @FXML
    private TextField revenueTextField;

    @FXML
    private TextField fixedCostsTextField;

    @FXML
    private TextField variableCostsTextField;

    @FXML
    private TextField additionalCostsTextField;
    @FXML
    private Label totalRevenueLabel;
    @FXML
    private Label totalCostsLabel;
    @FXML
    private Label netProfitLabel;
    @FXML
    private Button submitToMDButton;
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code here
    }
    
    @FXML
    void calculateCostButtonOnClick(ActionEvent event) {
    }

    @FXML
    void submitButtonToMDOnClick(ActionEvent event) {
         try{    
            int subscriber = Integer.parseInt(subscriberTextField.getText());
            float revenue = Float.parseFloat(revenueTextField.getText());
            float fixedCost = Float.parseFloat(fixedCostsTextField.getText());
            float variableCost = Float.parseFloat(variableCostsTextField.getText());
            float additionCost = Float.parseFloat(additionalCostsTextField.getText());

        // Creating an instance of Invoice
        CostEstimation cost = new CostEstimation(subscriber, revenue, fixedCost, variableCost, additionCost);
        boolean addStatus = CostEstimation.addToInstanceToEstimateCost(cost,"costEstimation.bin"); 
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Cost Estimation Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid  values .");
        }
  }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }   

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
