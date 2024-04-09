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
    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private DatePicker invoiceDatePicker;
    @FXML
    private TextArea detailedInfoTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    servicesComboBox.getItems().addAll("BillPayment", "New Connection fees", "LocationChangeFees", "OnuCharges", "Others");
    
    }    


    @FXML
    private void LoadToTextAreaOnClick(ActionEvent event) {
    // Fetching inputs from the FXML
        int customerID = Integer.parseInt(userIdTextField.getText());
        String address = addressTextField.getText();
        LocalDate invoiceDate = invoiceDatePicker.getValue();
        String services = servicesComboBox.getValue();

        // Creating an instance of Invoice
        Invoice invoice = new Invoice(customerID, address, invoiceDate, services);

        // Setting the text of the TextArea using the toString method of the Invoice instance
        detailedInfoTextArea.setText(invoice.toString());
    
    
    }

    @FXML
    private void sendButtonOnClick(ActionEvent event) {
    // Fetching inputs from the FXML
        int customerID = Integer.parseInt(userIdTextField.getText());
        String address = addressTextField.getText();
        LocalDate invoiceDate = invoiceDatePicker.getValue();
        String services = servicesComboBox.getValue();

        // Creating an instance of Invoice
        Invoice invoice = new Invoice(customerID, address, invoiceDate, services);

        // Adding the invoice instance to an ArrayList
        ArrayList<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);

        // Writing the ArrayList to the binary file
        Invoice.writeToFileForInvoiceRequest(invoices, "invoiceRequest.bin");
    
    
    }
    
}
