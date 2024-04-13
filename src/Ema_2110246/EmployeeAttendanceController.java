
package Ema_2110246;


import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateStringConverter;


public class EmployeeAttendanceController implements Initializable {
    @FXML
    private ComboBox<String> EmployeeDesignatioonComboBox;
    @FXML
    private DatePicker checkInDateDatePicker;
    @FXML
    private TableColumn<EmployeeAttendance, String> designationTableColumn;
    @FXML
    private TableColumn<EmployeeAttendance, LocalDate> dateTableColumn;
    @FXML
    private TableColumn<EmployeeAttendance, Integer> overtimeHourstableColumn;
    @FXML
    private TableColumn<EmployeeAttendance, String> remarksTableColumn;
    @FXML
    private TextArea remarksTextArea;
    @FXML
    private TextField overtimeHoursTextFiled;
    @FXML
    private TableView<EmployeeAttendance>TableView;
    @FXML
    private Button LoadInformationButton;
    
    List<EmployeeAttendance> attendances = new ArrayList<>();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationTableColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        remarksTableColumn.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        overtimeHourstableColumn.setCellValueFactory(new PropertyValueFactory<>("overtimeHour"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("checkIndate"));
        

        
        
        DateTimeFormatter customDateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        checkInDateDatePicker.setValue(LocalDate.now());
        checkInDateDatePicker.setConverter(new LocalDateStringConverter(customDateFormat, null));
        
        EmployeeDesignatioonComboBox.getItems().addAll("Marketing Manager", "Field Technician", "Customer Care RePresentative", "Network Engineer",  "Technical Support");
       
        TableView.getItems().addAll(attendances);

       
        
    }   
          
    
                
        
    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        try{
        String designation = EmployeeDesignatioonComboBox.getValue();
        String remarks = remarksTextArea.getText ();
        //String overtimeHours = overtimeHoursTextFiled.getText();
        //float overtimeHoursValue = Float.parseFloat(overtimeHours);
        float overtimeHours = Float.parseFloat(overtimeHoursTextFiled.getText());
        LocalDate date = checkInDateDatePicker.getValue();
        
        
   
   
  EmployeeAttendance attendance= new EmployeeAttendance(designation,date,overtimeHours, remarks);
  //pushing to model Class done   
   
  
   boolean addStatus = EmployeeAttendance.addToInstanceToEmployeeAttendance(attendance," EmployeeAttendance.bin"); //file writing
   
        
        if (addStatus) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "New Attendance Added Successfully!");
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
     //attendence= new data
     //attdences= old data




    

    @FXML
    private void loadInformationOnClick(ActionEvent event) {
       String designation = EmployeeDesignatioonComboBox.getValue();
        String remarks = remarksTextArea.getText ();
        float overtimeHours = Float.parseFloat(overtimeHoursTextFiled.getText());
        LocalDate date = checkInDateDatePicker.getValue();
        
        // Create a new instance of EmployeeAttendance
        TableView.getItems().add(new EmployeeAttendance(designation,date,overtimeHours, remarks));
        
  //attendances = attendance.readFromFileToEmployeeAttendance("EmployeeAttendanc.bin");
   // TableView.getItems().clear();
   // TableView.getItems().addAll(attendance);
        //remarksTextArea.setText(attendance.toString());*/
    


 
}
    

}


  
    

