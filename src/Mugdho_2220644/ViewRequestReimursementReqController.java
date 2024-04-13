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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    
    List<Reimbursement>reimbursements = new ArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
//
//@FXML
//    private void saveTAbleviewContentAsPDFOnCLick(ActionEvent event) {
//   reimbursements = Reimbursement.readFromFile("reimbursementRequest.bin");
//    invoiceTableView.getItems().clear();
//  invoiceTableView.getItems().addAll(reimbursements);
//    }
    
}
//invoices = Invoice.readFromFileToGenerateInvoice("invoice.bin");
