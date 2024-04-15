/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.management.Notification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Field_ViewNotificationController implements Initializable {

    @FXML
    private TableView<Notification> viewNotificationFromAssignDutyTableView;
    @FXML
    private TableColumn<Notification, Integer> customerIdTableColumn;
    @FXML
    private TableColumn<Notification, LocalDate> datetoWorkTableColumn;
    @FXML
    private TableColumn<Notification, String> locationTableColumn;
    @FXML
    private TableColumn<Notification, String> problemDetailsTableColumn;
    @FXML
    private Button loadButton;
    @FXML
    private Button saveTableViewAsPDF;
    @FXML
    private Button backButton;
    private List<Notification> nofis = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        customerIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        datetoWorkTableColumn.setCellValueFactory(new PropertyValueFactory<>("datetoWork"));
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        problemDetailsTableColumn.setCellValueFactory(new PropertyValueFactory<>("problemDetails"));
  
       //dutyFieldTechnicians = MarketingManager.loadReimbursements("dutyToFieldTechnician.bin");
       //dutyFieldTechnicians =customer.readFromFile("dutyToFieldTechnician.bin");
      // viewNotificationFromAssignDutyTableView.getItems().setAll(k);
      //invoiceRequests = InvoiceRequest.readFromFile("invoiceRequest.bin");
        //invoiceTableView.getItems().addAll(invoices);
       // nofis = dutyFieldTechnicians.readFromFileToPackagesRate("dutyToFieldTechnician.bin");
        viewNotificationFromAssignDutyTableView.getItems().addAll(nofis);
    }    

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void saveTableViewAsPDFOnCLick(ActionEvent event) {
        /*FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save PDF File");
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
    File file = fileChooser.showSaveDialog(null);

    if (file != null) {
        try (PdfWriter writer = new PdfWriter(file.getAbsolutePath())) {
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Add content to the PDF document
            document.add(new Paragraph("dutyFieldTechnicians:"));
            for (Notification notification :ks) {
                document.add(new Paragraph(notification.toString()));
            }

            // Close the document
            document.close();

            // Show success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "PDF generated successfully.", ButtonType.OK);
            alert.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();
            // Show error message
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error generating PDF.", ButtonType.OK);
            alert.showAndWait();
        }
    }*/
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FieldTechnicianDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
