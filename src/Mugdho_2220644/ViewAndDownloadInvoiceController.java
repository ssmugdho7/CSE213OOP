/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    @FXML
    private TextField searchByIDTExtfeild;
    @FXML
    private Button backButton;
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
         Invoice selectedInvoice = invoiceTableView.getSelectionModel().getSelectedItem();
        if (selectedInvoice != null) {
            downloadInvoicePDF(selectedInvoice);
        } else {
            showAlert("No Invoice Selected", "Please select an invoice to download.");
        }
    }

    private void downloadInvoicePDF(Invoice invoice) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            // Check if the file already exists
            if (file.exists()) {
                // Prompt user to confirm overwrite
                Alert overwriteAlert = new Alert(Alert.AlertType.CONFIRMATION);
                overwriteAlert.setTitle("Confirm Overwrite");
                overwriteAlert.setHeaderText("File already exists. Do you want to overwrite it?");
                overwriteAlert.setContentText("Click OK to overwrite the file or Cancel to choose a different name.");

                Optional<ButtonType> result = overwriteAlert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    generateInvoicePDF(invoice, file);
                }
            } else {
                generateInvoicePDF(invoice, file);
            }
        }
    }

    private void generateInvoicePDF(Invoice invoice, File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            PdfWriter writer = new PdfWriter(fos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Add invoice details to the PDF
            document.add(new Paragraph("Invoice Details"));
            document.add(new Paragraph("Customer ID: " + invoice.getCustomerId()));
            document.add(new Paragraph("Address: " + invoice.getAddress()));
            document.add(new Paragraph("Invoice Date: " + invoice.getInvoiceDate()));
            document.add(new Paragraph("Services: " + invoice.getServices()));
            document.add(new Paragraph("Amount: $" + invoice.getAmount()));

            document.close();

            showAlert("Success", "Invoice PDF saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save PDF: " + e.getMessage());
        }
    
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

    @FXML
    private void searchByIDTExtfeildOnClk(ActionEvent event) {
        String searchText = searchByIDTExtfeild.getText().trim();
        if (!searchText.isEmpty()) {
            List<Invoice> filteredInvoices = new ArrayList<>();
            for (Invoice invoice : invoices) {
                if (String.valueOf(invoice.getCustomerId()).equals(searchText)) {
                    filteredInvoices.add(invoice);
                }
            }
            invoiceTableView.getItems().clear();
            invoiceTableView.getItems().addAll(filteredInvoices);
        } else {
            showAlert("Search Error", "Please enter an invoice ID to search.");
        }
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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



