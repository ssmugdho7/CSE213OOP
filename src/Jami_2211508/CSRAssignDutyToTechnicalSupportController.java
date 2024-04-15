/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CSRAssignDutyToTechnicalSupportController implements Initializable {

    @FXML
    private DatePicker SelectDateDatePicker;
    @FXML
    private TableView<customer> dutyDetailsTableView;
    @FXML
    private TableColumn<customer, Integer> customerIDTableColomn;
    @FXML
    private TableColumn<customer, LocalDate> datetoworkTableColomn;
    @FXML
    private TableColumn<customer, String> problemDetailsTableColomn;
    @FXML
    private TextArea problemDetailsTextArea;
    @FXML
    private TextField customerIDTextField;

    ObservableList<customer> ob;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ob = FXCollections.observableArrayList();
        customerIDTableColomn.setCellValueFactory(new PropertyValueFactory<customer, Integer>("id"));
        datetoworkTableColomn.setCellValueFactory(new PropertyValueFactory<customer, LocalDate>("date"));
        problemDetailsTableColomn.setCellValueFactory(new PropertyValueFactory<customer, String>("problem"));
    }    

    @FXML
    private void loadToTableButtonOnClick(ActionEvent event) {
        customer newWork = new customer(
                Integer.parseInt(customerIDTextField.getText()),
                SelectDateDatePicker.getValue(),
                problemDetailsTextArea.getText());
        
        ob.add(newWork);
        dutyDetailsTableView.setItems(ob);
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
    try{   
            Integer id = Integer.parseInt(customerIDTextField.getText());
            LocalDate date = SelectDateDatePicker.getValue();
            String problem = problemDetailsTextArea.getText();

       
        customer k = new customer( id, date, problem) ;
        boolean addStatus = customer.addToInstanceForDutyToTechnicalSupport(k, "DutyToTechnicalSupport.bin"); 
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New duty to Technical Support Added Successfully!");
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

    @FXML
    private void clearButtonOnClick(ActionEvent event) {
        ObservableList<customer> selectedRows, allWork;
        allWork = dutyDetailsTableView.getItems();
        selectedRows = dutyDetailsTableView.getSelectionModel().getSelectedItems();
        
        for(customer p: selectedRows){
            allWork.remove(p);
        }
    }
    
}
