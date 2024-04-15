/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;


import Ema_2110246.Reimbursement;
import Ema_2110246.MarketingManager;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ViewRequestReimursementReqController implements Initializable {

    @FXML
    private TableView<Reimbursement> RequestReimbursementDataTableView;
    @FXML
    private TableColumn<Reimbursement, String> nameColumn;
    @FXML
    private TableColumn<Reimbursement, Float> amountColumn;
    @FXML
    private TableColumn<Reimbursement, String> paymentMethodColumn;
    @FXML
    private TableColumn<Reimbursement, String> expenseTypeColumn;
    @FXML
    private TableColumn<Reimbursement, LocalDate> reqDateColumn;
    @FXML
    private TableColumn<Reimbursement, String> designationColumn;
    @FXML
    private ComboBox<String> paymentMethodComboBox;
    @FXML
    private Button loadReqOnClick;
    
private List<Reimbursement> reimbursements = new ArrayList<>();
    @FXML
    private Button backButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
    amountColumn.setCellValueFactory(new PropertyValueFactory<>("expenseAmount"));
    paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
    expenseTypeColumn.setCellValueFactory(new PropertyValueFactory<>("expenseDistribution"));
    reqDateColumn.setCellValueFactory(new PropertyValueFactory<>("reimbursementDate"));
    designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
    
       reimbursements = Reimbursement.loadReimbursements("Reimbursement.bin");
       RequestReimbursementDataTableView.getItems().setAll(reimbursements);
    }


    @FXML
    private void saveTAbleviewContentAsPDFOnCLick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save PDF File");
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
    File file = fileChooser.showSaveDialog(null);

    if (file != null) {
        try (PdfWriter writer = new PdfWriter(file.getAbsolutePath())) {
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Add content to the PDF document
            document.add(new Paragraph("Reimbursements:"));
            for (Reimbursement reimbursement : reimbursements) {
                document.add(new Paragraph(reimbursement.toString()));
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
    }
    
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

