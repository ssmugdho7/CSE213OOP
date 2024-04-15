/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MDViewExtimatedCostController implements Initializable {

    @FXML
    private Label ExtimatedCostTableView;
    @FXML
    private TableColumn<?, ?> noOfSubscriberTableCol;
    @FXML
    private TableColumn<?, ?> averageRevenueTableCol;
    @FXML
    private TableColumn<?, ?> fixedCostTableCol;
    @FXML
    private TableColumn<?, ?> variableCostTableCol;
    @FXML
    private TableColumn<?, ?> aditionalCostTableCol;
    @FXML
    private TableColumn<?, ?> calculationTableCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
