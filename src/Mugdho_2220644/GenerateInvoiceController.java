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
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

//    ArrayList<Invoice> invoices = new ArrayList<>() ; 
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
      
         try{    
            int customerId = Integer.parseInt(customerIDTextField.getText());
            String address = addressTextArea.getText();
            LocalDate invoiceDateValue = invoiceDate.getValue();
            String services = servicesTextArea.getText();
            float amount = Float.parseFloat(amountTextField.getText());

        // Creating an instance of Invoice
        Invoice invoice = new Invoice(customerId, address, invoiceDateValue, services, amount);
        boolean addStatus = Invoice.addToInstanceToGenerateInvoice(invoice, "invoice.bin"); 
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Invoice Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numeric values for Customer ID and Amount.");
        }
  }


    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }  

    
     public Invoice createInvoiceFromInput() {
    // Assuming you have TextField objects for each field in the Invoice class
  

    // Fetch data from text fields
     int customerId = Integer.parseInt(customerIDTextField.getText());
    String address = addressTextArea.getText();
    LocalDate invoiceDateValue = invoiceDate.getValue();
    String services = servicesTextArea.getText();
    float amount = Float.parseFloat(amountTextField.getText());


    // Create and return Invoice object
    return new Invoice(customerId, address, invoiceDateValue, services, amount);
}
    

}


