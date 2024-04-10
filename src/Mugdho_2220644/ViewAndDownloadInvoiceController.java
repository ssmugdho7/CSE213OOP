/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ViewAndDownloadInvoiceController implements Initializable {

    @FXML
    private TableView<Invoice> invoiceTableView;
    @FXML
    private TableColumn<Invoice, Integer> customerIdTableCol;
    @FXML
    private TableColumn<Invoice, String> addressTableCol;
    @FXML
    private TableColumn<Invoice, LocalDate> invoiceDateTableCol;
    @FXML
    private TableColumn<Invoice, String> servicesTableCol;
    @FXML
    private TableColumn<Invoice, Float> amountTableCol;

    
    List<Invoice> invoices = new ArrayList<>();
    @FXML
    private Label invoicelabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         customerIdTableCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        addressTableCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        invoiceDateTableCol.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        servicesTableCol.setCellValueFactory(new PropertyValueFactory<>("services"));
        amountTableCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Load invoices from file
//        invoiceRequests = InvoiceRequest.readFromFile("invoiceRequest.bin");
        invoiceTableView.getItems().addAll(invoices);
    }    

    @FXML
    private void downloadButtonbuttonOnClick(ActionEvent event) {
    
    
    }

    @FXML
    private void viewInvoicebuttonOnClick(ActionEvent event) {
    invoices = Invoice.readFromFileToGenerateInvoice("invoice.bin");
    invoiceTableView.getItems().clear();
    invoiceTableView.getItems().addAll(invoices);
    
    
    
    }

    @FXML
    private void invoiceLabelOnMouseEntered(MouseEvent event) {
//     invoicelabel.setText(invoices.toString());
    
    }
    
}
