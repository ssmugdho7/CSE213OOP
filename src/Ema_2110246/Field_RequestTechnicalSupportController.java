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
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Field_RequestTechnicalSupportController implements Initializable {

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private ComboBox<String> reasonComboBox;
    @FXML
    private TextArea showTextArea;
    @FXML
    private Button submitButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reasonComboBox.getItems().addAll("Slow Internet Connection","Device Not Working", "Equipment Issue", "Other");
        DateTimeFormatter customDateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        dateDatePicker.setValue(LocalDate.now());
        dateDatePicker.setConverter(new LocalDateStringConverter(customDateFormat, null));

    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        try{
        String reason =reasonComboBox.getValue();
        String show = showTextArea.getText ();
        
        LocalDate date =dateDatePicker.getValue();
        
        
   
   
  Field_RequestTechnicalSupport support= new Field_RequestTechnicalSupport(reason, show, date);
  //pushing to model Class done   
   
  
   boolean addStatus = Field_RequestTechnicalSupport.addToInstanceToField_RequestTechnicalSupport(support," Field_RequestTechnicalSupport.bin"); //file writing
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "RequestTechnicalSupport Added Successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Oops, something went wrong.");
            }
     } 
         
         catch (NumberFormatException e) {
          showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter valid  values for reason.");
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
    
}
