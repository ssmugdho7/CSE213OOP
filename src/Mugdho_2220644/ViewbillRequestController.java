package Mugdho_2220644;

import java.io.*;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewbillRequestController implements Initializable {

    @FXML
    private TableView<InvoiceRequest> invoiceRequestsTableview;
    @FXML
    private TableColumn<InvoiceRequest, Integer> idCol;
    @FXML
    private TableColumn<InvoiceRequest, String> addCol;
    @FXML
    private TableColumn<InvoiceRequest, LocalDate> dateCol;
    @FXML
    private TableColumn<InvoiceRequest, String> serviceCall;
    @FXML
    private Button returnButton;
    private TextField searchByIDTextField;

    // ArrayList to hold invoice requests
     List<InvoiceRequest> invoiceRequests = new ArrayList<>();
    @FXML
    private Button filterButton;
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize TableView columns
        idCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        addCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        serviceCall.setCellValueFactory(new PropertyValueFactory<>("services"));

        // Load invoices from file
//        invoiceRequests = InvoiceRequest.readFromFile("invoiceRequest.bin");
        invoiceRequestsTableview.getItems().addAll(invoiceRequests);
    }


    @FXML
    private void loadButtonAfterSearchTextfeildByIDOnClick(ActionEvent event) {
        // Load all invoices from file again
        invoiceRequests = InvoiceRequest.readFromFile("invoiceRequest.bin");
        invoiceRequestsTableview.getItems().clear();
        invoiceRequestsTableview.getItems().addAll(invoiceRequests);
    }

    @FXML
    private void returnButtonInClk(ActionEvent event) {
        // Implement return button functionality here
    }

   

    @FXML
    private void filterButtonOnclick(ActionEvent event) {
             int searchID = Integer.parseInt(searchByIDTextField.getText());
        
        // Clear the TableView
        invoiceRequestsTableview.getItems().clear();
        Iterable<InvoiceRequest> invoices = null;
        
        // Search for invoices with the given ID and add them to the TableView
        for (InvoiceRequest invoice : invoiceRequests) {
            if (invoice.getCustomerId() == searchID) {
//                 InvoiceRequest x = invoice; 
                invoiceRequestsTableview.getItems().add(invoice);
            }
        }
    
    
    }

    @FXML
    private void SearchyIDTExtFeild(ActionEvent event) {
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


