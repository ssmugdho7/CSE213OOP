package Mugdho_2220644;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewbillRequestController implements Initializable {

    @FXML
    private TableView<Invoice> invoiceRequestsTableview;
    @FXML
    private TableColumn<Invoice, Integer> idCol;
    @FXML
    private TableColumn<Invoice, String> addCol;
    @FXML
    private TableColumn<Invoice, LocalDate> dateCol;
    @FXML
    private TableColumn<Invoice, String> serviceCall;
    @FXML
    private Button returnButton;
    private TextField searchByIDTextField;

    // ArrayList to hold invoice requests
    private ArrayList<Invoice> invoiceRequests = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize TableView columns
        idCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        addCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        serviceCall.setCellValueFactory(new PropertyValueFactory<>("services"));

        // Load invoices from file
        invoiceRequests = Invoice.readFromFile("invoiceRequest.bin");
        invoiceRequestsTableview.getItems().addAll(invoiceRequests);
    }


    @FXML
    private void loadButtonAfterSearchTextfeildByIDOnClick(ActionEvent event) {
        // Load all invoices from file again
        invoiceRequests = Invoice.readFromFileForInvoiceRequest("invoiceRequest.bin");
        invoiceRequestsTableview.getItems().clear();
        invoiceRequestsTableview.getItems().addAll(invoiceRequests);
    }

    @FXML
    private void returnButtonInClk(ActionEvent event) {
        // Implement return button functionality here
    }

    @FXML
    private void SearchyIDTExtFeild(ActionEvent event) {
                int searchID = Integer.parseInt(searchByIDTextField.getText());
        
        // Clear the TableView
        invoiceRequestsTableview.getItems().clear();
        
        // Search for invoices with the given ID and add them to the TableView
        for (Invoice invoice : invoiceRequests) {
            if (invoice.getCustomerId() == searchID) {
                invoiceRequestsTableview.getItems().add(invoice);
            }
        }
    }
}
