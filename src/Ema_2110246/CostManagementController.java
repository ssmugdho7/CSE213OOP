/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;


import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CostManagementController implements Initializable {

    @FXML
    private TextArea suggestionTextArea;
    @FXML
    private Button saveButton;
    @FXML
    private ComboBox<String>budgetPlanComboBox;
    @FXML
    private ComboBox<String>saveMoneybyComboBox;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        budgetPlanComboBox.getItems().addAll("Invest more in what is effective", "Spend less on what does not work", "Find cheaper tools");
        saveMoneybyComboBox.getItems().addAll("Simplify processes", "Negotiate discounts", "Improve advertising");
    }    

    @FXML
    private void saveButtonOnCilick(ActionEvent event) {
        
  try{
        String suggestion = suggestionTextArea.getText();
        String budgetPlan = budgetPlanComboBox.getValue();
        String saveMoneyby = saveMoneybyComboBox.getValue();
        
        
   Cost_Management process = new Cost_Management(suggestion,budgetPlan,saveMoneyby);
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



      
