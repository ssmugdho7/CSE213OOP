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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SendInvoiceRequestController implements Initializable {

    @FXML
    private TextField userIDTextFeild;
    @FXML
    private TextField addresstextfeild;
    @FXML
    private DatePicker reqDatepicker;
    @FXML
    private ComboBox<?> servicesComboBox;
    @FXML
    private TextArea detailsofinvReq;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendOnClick(ActionEvent event) {
    }

    @FXML
    private void LoadToTextAreaOnClick(ActionEvent event) {
    }
    
}
