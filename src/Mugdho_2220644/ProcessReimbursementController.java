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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProcessReimbursementController implements Initializable {

    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox<String> expenseTypeComboBox;
    @FXML
    private DatePicker expenseDatePicker;
    @FXML
    private TextField employeeNameTextField;
    @FXML
    private RadioButton payableRadioButton;
    @FXML
    private RadioButton notPayableRadioButton;
    @FXML
    private ComboBox<String> designationComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveRecordsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void loadPrevRecordsOnClick(ActionEvent event) {
    }
    
}
