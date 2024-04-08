/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class GenerateInvoiceController implements Initializable,Serializable {

    @FXML
    private TextArea servicesTextArea;
    @FXML
    private Button invoicereqButton;
    @FXML
    private TextField customerIDTextField;
    @FXML
    private TextArea addressTextArea;
    @FXML
    private DatePicker invoiceDate;
    @FXML
    private TextField amountTextField;

    ArrayList<Invoice> invoices = new ArrayList<>() ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void invReqsOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewbillRequest.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) invoicereqButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML   
        private void generateInvoiceOnClick(ActionEvent event) {
            int customerId = Integer.parseInt(customerIDTextField.getText());
            String address = addressTextArea.getText();
            LocalDate invoiceDateValue = invoiceDate.getValue();
            String services = servicesTextArea.getText();
            float amount = Float.parseFloat(amountTextField.getText());

        // Creating an instance of Invoice
        Invoice invoice = new Invoice(customerId, address, invoiceDateValue, services, amount);

       

        // Add the new invoice
        invoices.add(invoice);

        // Call the method to write all invoices
        Invoice.writeToFile(invoices, "invoice.bin");
    }
}


