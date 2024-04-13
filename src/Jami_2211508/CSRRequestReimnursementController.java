/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

//import static Jami_2211508.csrReimnursement.writeToFileForRequestingReimbursement;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CSRRequestReimnursementController implements Initializable {

    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox<String> ExpenseTypeComboBox;
    @FXML
    private DatePicker expenseDatePicker;
    @FXML
    private TextField name;
   
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private TableView<csrReimnursement> tableView;
    @FXML
    private TableColumn<csrReimnursement, String> nameCol;
    @FXML
    private TableColumn<csrReimnursement, LocalDate> dateCol;
    @FXML
    private TableColumn<csrReimnursement, String> designationCol;
    @FXML
    private TableColumn<csrReimnursement, Float> amountCol;
    @FXML
    private TableColumn<csrReimnursement, String> expanseCol;
    
    List<csrReimnursement> reimbursements = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationComboBox.getItems().addAll("Accountant", "Customer",
                "Field Technician", "Marketing Manager", "Customer Care Representative",
                "Technical Support Representative", "Network Engineer");
        ExpenseTypeComboBox.getItems().addAll(".........", "-------");
        
        
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        designationCol.setCellValueFactory(new PropertyValueFactory<>("designation"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        expanseCol.setCellValueFactory(new PropertyValueFactory<>("expanse"));
        
        tableView.getItems().addAll(reimbursements);
    }    

    

    @FXML
    private void sendbuttonOnClick(ActionEvent event) {
        try{    
            LocalDate date = expenseDatePicker.getValue();
            String employeeName = name.getText();
            String designation = designationComboBox.getValue();
            String expense = ExpenseTypeComboBox.getValue();
            float amount = Float.parseFloat(amountTextField.getText());

        // Creating an instance of Invoice
        csrReimnursement reimbursement = new csrReimnursement(date, employeeName, designation, expense, amount) ;
        boolean addStatus = csrReimnursement.addToInstanceForRequestingReimbursement(reimbursement, "reimbursement.bin"); 
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New reimbursement Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numeric values for Amount.");
        }
        name.clear();
        amountTextField.clear();
        designationComboBox.getItems().clear();
        expenseDatePicker.setValue(null);
        ExpenseTypeComboBox.getItems().clear();

        
        
        
  }

    @FXML
    private void ViewReimbursementHistoryButtonOnClick(ActionEvent event) {
        reimbursements = csrReimnursement.readFromFileForRequestingReimbursement("reimbursement.bin");
        tableView.getItems().clear();
        tableView.getItems().addAll(reimbursements);
    
   
    }
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
