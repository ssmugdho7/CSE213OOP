/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EstimateCostAnalysisController implements Initializable {

    @FXML
    private TextField subscriberField;
    @FXML
    private TextField revenueField;
    @FXML
    private TextField fixedCostsField;
    @FXML
    private TextField variableCostsField;
    @FXML
    private TextField additionalCostsField;
    @FXML
    private Label totalRevenueLabel;
    @FXML
    private Label totalCostsLabel;
    @FXML
    private Label netProfitLabel;
    @FXML
    private Button SubmitToMDOnClick;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calculateCosts(ActionEvent event) {
    }
    
}
