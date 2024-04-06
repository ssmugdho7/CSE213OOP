/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RequestReimbursementPaymentController implements Initializable {

    @FXML
    private ComboBox<?> designationComboBox;
    @FXML
    private ComboBox<?> ExpenseDescriptionComboBox;
    @FXML
    private TextField expenseAmountField;
    @FXML
    private DatePicker reimbursementDate;
    @FXML
    private RadioButton bankTransferRadioButton;
    @FXML
    private RadioButton checkRadioButton;
    @FXML
    private RadioButton mobileBankingRadioButton;
    @FXML
    private TextField employeeNameField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
    }
    
}
