
package Jami_2211508;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;


public class CSRAttendenceandOvertimeController implements Initializable {

    @FXML
    private ComboBox<String> EmployeeDesignatioonComboBox;
    @FXML
    private DatePicker checkInDateDatePicker;
    @FXML
    private TextArea remarkTextArea;
    @FXML
    private ComboBox<Integer> overtimeComboBox;
    @FXML
    private TableView<Csr> Tableview;
    @FXML
    private TableColumn<Csr, String> desigCol;
    @FXML
    private TableColumn<Csr, LocalDate> datecol;
    @FXML
    private TableColumn<Csr, Integer> overtimecol;
    @FXML
    private TableColumn<Csr, String> remarksCol;

    ObservableList<Csr> ob = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EmployeeDesignatioonComboBox.getItems().addAll("Accountant", "Customer",
                "Field Technician", "Marketing Manager", "Customer Care Representative",
                 "Technical Support Representative", "Network Engineer");
        
        for (int i=0; i<25; i++){
           overtimeComboBox.getItems().add(i);
        }
        
        desigCol.setCellValueFactory(new PropertyValueFactory<Csr, String>("Designation"));
        datecol.setCellValueFactory(new PropertyValueFactory<Csr, LocalDate>("date"));
        overtimecol.setCellValueFactory(new PropertyValueFactory<Csr, Integer>("hours"));
        remarksCol.setCellValueFactory(new PropertyValueFactory<Csr, String>("remarks"));
    }    

    @FXML
    private void LoadButtonOnClick(ActionEvent event) throws IOException {
        
        String designationType = EmployeeDesignatioonComboBox.getValue();
        if (designationType == null) {
            showErrorAlert("Error", "Please select a Designation type.");
            return;
        }
        Integer overtime = overtimeComboBox.getValue();
        if (overtime == null) {
            showErrorAlert("Error", "Please select Overtime hours.");
            return;
        }
        
        LocalDate date = checkInDateDatePicker.getValue();
        if (date == null) {
            showErrorAlert("Error", "Please select Date.");
            return;
        }
        
        
        Csr newAttendence = new Csr(
                EmployeeDesignatioonComboBox.getValue(),
                checkInDateDatePicker.getValue(),
                overtimeComboBox.getValue(),
                remarkTextArea.getText());
        
        ob.add(newAttendence);
        Tableview.setItems(ob);
    }
    
    @FXML
    private void SubmitButtonOnClick(ActionEvent event) {
        try{   
            String designation = EmployeeDesignatioonComboBox.getValue();
            LocalDate date = checkInDateDatePicker.getValue();
            Integer overtime = overtimeComboBox.getValue();
            String remarks = remarkTextArea.getText();
            
           

        
        Csr k = new Csr( designation, date, overtime, remarks) ;
        boolean addStatus = Csr.addToInstanceForCSRattendenceOvertime(k, "CSRattendenceOvertime.bin"); 
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New duty to Field Technicians Added Successfully!");
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
    
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
    
}
