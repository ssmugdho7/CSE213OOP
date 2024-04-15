/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MDSuggestionsForChangesController implements Initializable {

    @FXML
    private ComboBox<String> employeeComboBox;
    @FXML
    private TextField topicTextField;
    @FXML
    private TextArea descriptionTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeeComboBox.getItems().addAll("Accountant","Field Technician", "Marketing Manager", 
                "Customer Care Representative","Technical Support Representative", "Network Engineer");
    }    

    @FXML
    private void sendButtonOnClick(ActionEvent event) {
    try{
            String topic = topicTextField.getText();
            String description = descriptionTextArea.getText();
            

        // Creating an instance
        md suggestions = new md( topic,description);
        String employee = employeeComboBox.getValue();
        if (employee == null) {
            showErrorAlert("Error", "Please select a user type.");
            return;
        }
        if (employee.equals("Accountant")) {
              boolean addStatus = md.addToInstanceForTermPolicys(suggestions, "Accountant Suggestions.bin"); 
              if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Accountant Suggestions Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
            }
        if (employee.equals("Field Technician")) {
              boolean addStatus = md.addToInstanceForTermPolicys(suggestions, "Field Technician Suggestions.bin"); 
              if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Field Technician Suggestions Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
            }
        if (employee.equals("Marketing Manager")) {
              boolean addStatus = md.addToInstanceForTermPolicys(suggestions, "Marketing Manager Suggestions.bin"); 
              if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Marketing Manager Suggestions Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
            }
        if (employee.equals("Customer Care Representative")) {
              boolean addStatus = md.addToInstanceForTermPolicys(suggestions, "Customer Care Representative Suggestions.bin"); 
              if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Customer Care Representative Suggestions Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
            }
        if (employee.equals("Technical Support Representative")) {
              boolean addStatus = md.addToInstanceForTermPolicys(suggestions, "Technical Support Representative Suggestions.bin"); 
              if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Technical Support Representative Suggestions Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
            }
        if (employee.equals("Network Engineer")) {
              boolean addStatus = md.addToInstanceForTermPolicys(suggestions, "Network Engineer Suggestions.bin"); 
              if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Network Engineer Suggestions Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
            }
 
     }
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numeric value.");
        }
        topicTextField.clear();
        descriptionTextArea.clear();
  }
 

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
