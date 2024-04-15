/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private ComboBox<String> servicesComboBox;
    private TextField userIdTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private DatePicker invoiceDatePicker;
    @FXML
    private TextArea detailedInfoTextArea;
    @FXML
    private TextField customerIdTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    servicesComboBox.getItems().addAll("BillPayment", "New Connection fees", "LocationChangeFees", "OnuCharges", "Others");
    
    }    

    @FXML
    private void sendButtonOnClick(ActionEvent event) {
     try {
            int customerId = Integer.parseInt(customerIdTextField.getText());
            String address = addressTextField.getText();
            LocalDate invoiceDate = invoiceDatePicker.getValue();
            String services = servicesComboBox.getValue();
//            float amount = Float.parseFloat(amountTextField.getText());

            InvoiceRequest newInvoice = new InvoiceRequest(customerId, address, invoiceDate, services);
            boolean addStatus = InvoiceRequest.addNewInstance(newInvoice, "invoiceRequest.bin");

            if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Invoice Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
        } catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numeric values for Customer ID and Amount.");
        }
    }
 
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }  

   
    @FXML
    private void LoadToTextAreaOnClick(ActionEvent event) {
    // Fetching inputs from the FXML
        int customerId = Integer.parseInt(customerIdTextField.getText());
        String address = addressTextField.getText();
        LocalDate invoiceDate = invoiceDatePicker.getValue();
        String services = servicesComboBox.getValue();

        // Creating an instance of Invoice
        InvoiceRequest invoice = new InvoiceRequest(customerId, address, invoiceDate, services);

        // Setting the text of the TextArea using the toString method of the Invoice instance
       detailedInfoTextArea.setText(invoice.toString());
    
    
    }
    
    
    
    
    
    
    
}
