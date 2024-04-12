
package Ema_2110246;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    //private TableView<EmployeeAttendance> showTableView;
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
    private Button LoadButton;
    @FXML
    private TableView<EmployeeAttendance> TableView;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationTableColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        remarksTableColumn.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        overtimeHourstableColumn.setCellValueFactory(new PropertyValueFactory<>("overtimeHours"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        DateTimeFormatter customDateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        checkInDateDatePicker.setValue(LocalDate.now());
        checkInDateDatePicker.setConverter(new LocalDateStringConverter(customDateFormat, null));
        
        EmployeeDesignatioonComboBox.getItems().addAll("Marketing Manager", "Field Technician", "Customer Care RePresentative", "Network Engineer",  "Technical Support");
        
 


       
        
    }   
    
    
    
    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        String designation = EmployeeDesignatioonComboBox.getValue();
        String remarks = remarksTextArea.getText ();
        String overtimeHours = overtimeHoursTextFiled.getText();
        int overtimeHoursValue = Integer.parseInt(overtimeHours);
        LocalDate checkInDate = checkInDateDatePicker.getValue();
        TableView.getItems().add(new EmployeeAttendance(designation,checkInDate ,overtimeHoursValue , remarks));
        //String displayText = items.generateDisplayText();
        remarksTextArea.clear();
        remarksTextArea.appendText(remarks);
                
        
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        String designation = EmployeeDesignatioonComboBox.getValue();
        String remarks = remarksTextArea.getText ();
        String overtimeHours = overtimeHoursTextFiled.getText();
        LocalDate checkInDate = checkInDateDatePicker.getValue();

        if (designation == null || remarks == null || overtimeHours.isEmpty() || checkInDate == null) {
            showErrorAlert("Error", "Please enter all required data.");
            return;
        }

        int overtimeHoursValue;
        try {
            overtimeHoursValue = Integer.parseInt (overtimeHours);
        } catch (NumberFormatException e) {
            showErrorAlert("Error", "Invalid hours format. Please enter a valid number.");
            return;
        }

        if (overtimeHoursValue <= 0) {
            showErrorAlert("Error", "Hours must be a positive value.");
            return;
        }
        
        
        List<Object> employeeAttendanceList = MarketingManager.readObjectsFromFile("EmployeeAttendance.bin");
        for (Object obj : employeeAttendanceList) {
            if (obj instanceof EmployeeAttendance) {
                EmployeeAttendance existingRecord = (EmployeeAttendance) obj;
                if (existingRecord.getDate().equals(checkInDate)) {
                    showErrorAlert("Error", "Record already submitted for today.");
                    return;
                }
            }
        }
            ////////////
        EmployeeAttendance newEmployeeAttendance = new EmployeeAttendance(designation,checkInDate ,overtimeHoursValue , remarks);
        //boolean addStatus = MarketingManager.addnewEmployeeAttendance
        boolean addStatus = MarketingManager.addNewEmployeeAttendance(newEmployeeAttendance, "EmployeeAttendance.bin");
        if (addStatus) {
            showInfoAlert("Success", "Send Successfully!");
        } else {
            showErrorAlert("Error", "Oops, something went wrong");
        }
        
    }



    /*@FXML
    private void loadButtonOnClick(ActionEvent event) {
        String designation = EmployeeDesignatioonComboBox.getValue();
        String remarks = remarksTextArea.getText ();
        String overtimeHours = overtimeHoursTextFiled.getText();
        int overtimeHoursValue = Integer.parseInt(overtimeHours);
        LocalDate checkInDate = checkInDateDatePicker.getValue();
        showTableView.getItems().add(new EmployeeAttendance(designation,checkInDate ,overtimeHoursValue , remarks));
                
        
    }*/
    
     
    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showInfoAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    
}
