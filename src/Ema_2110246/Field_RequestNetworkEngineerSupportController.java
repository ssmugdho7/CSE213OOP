/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Field_RequestNetworkEngineerSupportController implements Initializable {

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private ComboBox<String> reasonComboBox;
    @FXML
    private TextArea issueTextArea;
    @FXML
    private Button submitButton;
    @FXML
    private ComboBox<String> deviceComboBox;
    @FXML
    private TextField customerIdTextFiled;
    @FXML
    private TextArea addressTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reasonComboBox.getItems().addAll("Network Connectivity", "Software Updates","Performance Issues","Connection Dropouts", "Other");
        deviceComboBox.getItems().addAll("Router", "Access Point","Switch","Modem","Other");
        DateTimeFormatter customDateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        dateDatePicker.setValue(LocalDate.now());
        dateDatePicker.setConverter(new LocalDateStringConverter(customDateFormat, null));
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        try{
        
        String reason =reasonComboBox.getValue();
        String device =deviceComboBox.getValue();
        int customerId = Integer.parseInt(customerIdTextFiled.getText());
        String address = addressTextArea.getText();
        String issue = issueTextArea.getText ();
        LocalDate date =dateDatePicker.getValue();
        
        
   
   
  Field_RequestNetworkEngineerSupport suppt = new Field_RequestNetworkEngineerSupport(reason, device, issue, address,  customerId, date);
  //pushing to model Class done   
   
  
   boolean addStatus = Field_RequestNetworkEngineerSupport.addToInstanceToField_RequestNetworkEngineerSupport(suppt,"Field_RequestNetworkEngineerSupport.bin"); //file writing
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "RequestNetworkEngineerSupport Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid  values for reason,address,customerId and device.");
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
     //attendence= new data
     //attdences= old data
    //support= new support 
    // supports= old support
    
    //suppt= new support 
    // suppts= old supp
}
