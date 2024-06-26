
package Ema_2110246;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RequestReimbursementPaymentController implements Initializable {

    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private ComboBox<String> ExpenseDescriptionComboBox;
    @FXML
    private TextField expenseAmountField;
    @FXML
    private DatePicker reimbursementDate;
    @FXML
    private RadioButton bankTransferRadioButton;
    @FXML
    private RadioButton checkRadioButton;
    @FXML
    private RadioButton mobileBankingRadioButton;
    @FXML
    private TextField employeeNameField;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //designationComboBox.getItems().addAll("Lawyer", "Receptionist", "Document Manager", "Consultant");
        designationComboBox.getItems().addAll("Marketing Manager", "Field Technician", "Customer Care RePresentative", "Network Engineer",  "Technical Support RePresentative");
        //designationComboBox.getSelectionModel().selectFirst();

        designationComboBox.setOnAction(event -> {
             String selectedDesignation = designationComboBox.getValue();
             if (selectedDesignation != null) {
                 switch (selectedDesignation) {
                     case "Marketing Manager":
                         ExpenseDescriptionComboBox.getItems().setAll(
                             "Marketing Campaigns","Advertising Expenses", "Market Research");
                         break;
                     case "Field Technician":
                         ExpenseDescriptionComboBox.getItems().setAll(
                             "Equipment Maintenance", "On-site Support", "Travel Expenses");
                         break;
                     case "Customer Care RePresentative":
                         ExpenseDescriptionComboBox.getItems().setAll(
                               "Customer Support Calls", "Training Expenses", "Office Supplies");
                         break;
                     case "Network Engineer":
                         ExpenseDescriptionComboBox.getItems().setAll(
                                 "Network Configuration", "Hardware Installation", "Troubleshootin");
                         break;
                     case "Technical Support RePresentative":
                         ExpenseDescriptionComboBox.getItems().setAll(
                             "Software Support", "Hardware Support", "Remote Assistance");
                         break;
                         
                     default:
                         ExpenseDescriptionComboBox.getItems().clear();
                         break;
                 }
             }
         });

         ToggleGroup paymentMethodToggleGroup = new ToggleGroup();
         bankTransferRadioButton.setToggleGroup(paymentMethodToggleGroup);
         checkRadioButton.setToggleGroup(paymentMethodToggleGroup);
         mobileBankingRadioButton.setToggleGroup(paymentMethodToggleGroup);
    }    

    @FXML
    private void submitRequestButtonOnClick(ActionEvent event) {
        String employeeName = employeeNameField.getText();
        String expenseAmountText = expenseAmountField.getText();
        LocalDate reimbursementDateValue = reimbursementDate.getValue();
        String designation = designationComboBox.getValue();
        String paymentMethod = getSelectedPaymentMethod();
        String expenseDistribution = ExpenseDescriptionComboBox.getValue();

        if (employeeName.isEmpty() || expenseAmountText.isEmpty() || reimbursementDateValue == null ||
                designation == null || paymentMethod.isEmpty() || expenseDistribution == null) {
            showAlert("Validation Error", "Please fill in all fields and select a payment method.", Alert.AlertType.ERROR);
            return;
        }

        Float expenseAmount;
        try {
            expenseAmount = Float.parseFloat(expenseAmountText);
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Invalid expense amount format.", Alert.AlertType.ERROR);
            return;
        }

        Reimbursement reimbursement = new Reimbursement(employeeName, expenseAmount, reimbursementDateValue,
                designation, paymentMethod, expenseDistribution);

        ArrayList<Reimbursement> existingReimbursements = Reimbursement.loadReimbursements("Reimbursement.bin");
        existingReimbursements.add(reimbursement);

        ObservableList<Reimbursement> observableReimbursements = FXCollections.observableArrayList(existingReimbursements);

        boolean success = Reimbursement.writeReimbursements(observableReimbursements, "Reimbursement.bin");

        if (success) {
            showAlert("Success", "Reimbursement submitted successfully.", Alert.AlertType.INFORMATION);
            clearFields();
        } else {
            showAlert("Error", "Failed to submit reimbursement.", Alert.AlertType.ERROR);
        }
        
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        
    }

    private void clearFields() {
        employeeNameField.clear();
        expenseAmountField.clear();
        bankTransferRadioButton.setSelected(false);
        checkRadioButton.setSelected(false);
        mobileBankingRadioButton.setSelected(false);
        ExpenseDescriptionComboBox.getSelectionModel().clearSelection();
        reimbursementDate.setValue(null);
        designationComboBox.getSelectionModel().clearSelection();
       
    }

    private String getSelectedPaymentMethod() {
        if (bankTransferRadioButton.isSelected()) {
            return "Bank Transfer";
        } else if (checkRadioButton.isSelected()) {
            return "Check";
        } else if (mobileBankingRadioButton.isSelected()) {
            return "Mobile Banking";
        }
        return null;
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MarketingManagerDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
