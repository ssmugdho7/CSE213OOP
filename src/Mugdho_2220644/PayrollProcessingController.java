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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class PayrollProcessingController implements Initializable {

    @FXML
    private TextField searchTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField bonusesTextField;
    @FXML
    private TextField overtimeTextField;
    @FXML
    private ComboBox<?> designationComboBox;
    @FXML
    private ComboBox<?> paymentMethodComboBox;
    @FXML
    private Button calculateTotalSalaryButton;
    @FXML
    private Button saveRecordButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TableView<?> recordsTableView;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> empIDCol;
    @FXML
    private TableColumn<?, ?> saalryCol;
    @FXML
    private TableColumn<?, ?> BonusCol;
    @FXML
    private TableColumn<?, ?> OvertimecOL;
    @FXML
    private TableColumn<?, ?> dESIGNcoL;
    @FXML
    private TableColumn<?, ?> pAYMENTMETHODcoL;
    @FXML
    private Label totalSalaryLabel;
    @FXML
    private ComboBox<?> fildercOMBOBOX;
    @FXML
    private Label totalSallaryLabel;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calculateTotalSalaryButtonClicked(ActionEvent event) {
    }

    @FXML
    private void saveRecordButtonClicked(ActionEvent event) {
    }

    @FXML
    private void loadButtonClicked(ActionEvent event) {
    }

    @FXML
    private void refreshButtonClicked(ActionEvent event) {
    }
    
}
