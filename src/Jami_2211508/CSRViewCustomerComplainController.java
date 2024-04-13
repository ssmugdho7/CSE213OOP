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
import javafx.scene.control.RadioButton;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CSRViewCustomerComplainController implements Initializable {

    @FXML
    private TableColumn<?, ?> CustomerNameTableColomn;
    @FXML
    private TableColumn<?, ?> CustomerIDTableColomn;
    @FXML
    private TableColumn<?, ?> ComplainDetailsTableColomn;
    @FXML
    private RadioButton OnGoingRadioButton;
    @FXML
    private RadioButton pendingRadioButton;
    @FXML
    private RadioButton solvedRadioButton;
    @FXML
    private TextField customerIDTextfield;
    @FXML
    private TextArea writeDetailsTextArea;
    @FXML
    private TableView<?> CustomerComplainTableView;

    ToggleGroup tg;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        OnGoingRadioButton.setToggleGroup(tg);
        pendingRadioButton.setToggleGroup(tg);
        solvedRadioButton.setToggleGroup(tg);
    }    


    @FXML
    private void SendMessagetoCustomerButtonOnClick(ActionEvent event) {
        String Inquiry="";
        if(OnGoingRadioButton.isSelected())
            Inquiry="On Going";
        else if(pendingRadioButton.isSelected())
            Inquiry="Pending";        
        else if(solvedRadioButton.isSelected())
            Inquiry="Solved";
        
        try{   
            String inquiry = Inquiry;
            Integer id = Integer.parseInt(customerIDTextfield.getText());
            String details = writeDetailsTextArea.getText();

        
        customer k = new customer( inquiry, id, details) ;
        boolean addStatus = customer.addToInstanceForDutyToNetworkEngineer(k, "InquiryForCustomer.bin"); 
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New duty to Network Engineer Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid numeric values for Amount.");
        }
  }
 

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    
    }
    

    
}
