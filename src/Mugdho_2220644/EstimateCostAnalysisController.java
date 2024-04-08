/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;


import java.io.Serializable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EstimateCostAnalysisController implements Initializable,Serializable {
    
    private ArrayList<CostEstimation> costEstimations = new ArrayList<>();
    private final String fileName = "costEstimation.bin";

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code here
    }
    
    @FXML
    void calculateCostButtonOnClick(ActionEvent event) {
        int subscriber = Integer.parseInt(subscriberTextField.getText());
        float revenue = Float.parseFloat(revenueTextField.getText());
        float fixedCosts = Float.parseFloat(fixedCostsTextField.getText());
        float variableCosts = Float.parseFloat(variableCostsTextField.getText());
        float additionalCost = Float.parseFloat(additionalCostsTextField.getText());

        CostEstimation costEstimation = new CostEstimation(subscriber, revenue, fixedCosts, variableCosts, additionalCost);
        costEstimations.add(costEstimation);
    }

    @FXML
    void submitButtonToMDOnClick(ActionEvent event) {
        CostEstimation.writeToFile(costEstimations, fileName);
    }

}
