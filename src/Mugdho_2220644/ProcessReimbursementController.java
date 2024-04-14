/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProcessReimbursementController implements Initializable {

    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox<String> expenseTypeComboBox;
    @FXML
    private DatePicker expenseDatePicker;
    @FXML
    private TextField employeeNameTextField;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        designationComboBox.getItems().addAll("Markeing Manager", "Field Technician", "Technical Support Representative", "Network Engineer", "Customer care Representative");
        
                expenseTypeComboBox.getItems().addAll("Accident", "Sickness","Others");
    }    

    @FXML
    private void saveRecordsButtonOnClick(ActionEvent event) {
    
     try{
        String empName = employeeNameTextField.getText();

    
   LocalDate expenseDate=  expenseDatePicker.getValue( );
String designation = designationComboBox.getValue();
Float amount = Float.parseFloat(amountTextField.getText());
String expenseType = expenseTypeComboBox.getValue();
  
  ProcessReimbursement process =  new ProcessReimbursement( empName, designation,  expenseType,  expenseDate, amount);
  //pushing to model Class done   
   
  
   boolean addStatus = ProcessReimbursement.addToInstanceToProcessReimbursement(process, "processedReimbursement.bin"); //file writing
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Invoice Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numeric values for Customer ID and Amount.");
        }
  }


    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();

    
    }
    //process = new data 
    //processes = old data

    

    @FXML
    private void loadPrevRecordsOnClick(ActionEvent event) {
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
