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
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

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
    
       try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                //PdfWriter pw = new PdfWriter(new FileOutputStream("testPDF.pdf"));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
               
                
             invoice =  new Invoice(customerId, address, invoiceDate, services, amount);
                
                doc.close();
                
               
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
            //System.out.println("Something went wrong...");
            //System.out.println(e);
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
    
}
