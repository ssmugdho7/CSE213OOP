/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CostManagementController implements Initializable {

    @FXML
    private TextArea suggestionTextArea;
    @FXML
    private TextField totalExpensesTextField;
    @FXML
    private TextField monthlyRevenueTextField;
    @FXML
    private Button saveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveButtonOnCilick(ActionEvent event) {
        
  try{
        String suggestion = suggestionTextArea.getText();
        
        Float totalExpenses = Float.parseFloat(totalExpensesTextField.getText());
        
        Float monthlyRevenue = Float.parseFloat(monthlyRevenueTextField.getText());
   
        
   Cost_Management process =  new Cost_Management( suggestion,totalExpenses,monthlyRevenue);
  //pushing to model Class done   
   
  
   boolean addStatus = Cost_Management.addToInstanceToCost_Management(process, "Cost_Management.bin"); //file writing
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New suggestion Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numeric values for totalExpenses and monthlyRevenue.");
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

    
        
    }



      
