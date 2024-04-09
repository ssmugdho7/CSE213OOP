
package Ema_2110246;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateStringConverter;


public class EmployeeAttendanceController implements Initializable {

    @FXML
    private ComboBox<String> EmpDesignatioonComboBox;
    @FXML
    private DatePicker checkInDateDatepicker;
    @FXML
    private TextArea remarksTextArea;
    @FXML
    private ComboBox<String> overtimeCombobox;
    @FXML
    private TableView<EmployeeAttendance> Tableview;
    @FXML
    private TableColumn<EmployeeAttendance, String> desigCol;
    @FXML
    private TableColumn<EmployeeAttendance, LocalDate> datecol;
    @FXML
    private TableColumn<EmployeeAttendance, Float> overtimecol;
    @FXML
    private TableColumn<EmployeeAttendance,String > remarksCol;
    @FXML
    private Button BAck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        desigCol.setCellValueFactory(new PropertyValueFactory<>("designation"));
        remarksCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        overtimecol.setCellValueFactory(new PropertyValueFactory<>("hour"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        DateTimeFormatter customDateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        checkInDateDatepicker.setValue(LocalDate.now());
        checkInDateDatepicker.setConverter(new LocalDateStringConverter(customDateFormat, null));
        
        EmpDesignatioonComboBox.getItems().addAll("Marketing Manager", "Field Technician", "Customer Care RePresentative", "Network Engineer",  "Technical Support");
        
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void LoadOnClick(ActionEvent event) {
        String designation = EmpDesignatioonComboBox.getValue();
        String remarks = remarksTextArea.getText();
        String overtime = overtimeCombobox.getValue();
        Float hoursValue = Float.valueOf(overtime);
                //valueOf(overtime);
        LocalDate date = checkInDateDatepicker.getValue();
        Tableview.getItems().add(new EmployeeAttendance(designation,remarks, hoursValue, date));
    }

    @FXML
    private void BAckOnClk(ActionEvent event) {
    }

    
    
}
