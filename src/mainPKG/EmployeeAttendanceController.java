/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPKG;

import java.net.URL;
import java.util.ResourceBundle;
iimport javafx.event.ActionEvent;
import javafx.fxml.FXML;
mport javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EmployeeAttendanceController implements Initializable {


    @FXML
    private ComboBox<?> EmpDesignatioonComboBox;
    @FXML
    private DatePicker checkInDateDatepicker;
    @FXML
    private TextArea remarksTextArea;
    @FXML
    private ComboBox<?> overtimeCombobox;
    @FXML
    private TableView<?> Tableview;
    @FXML
    private TableColumn<?, ?> desigCol;
    @FXML
    private TableColumn<?, ?> datecol;
    @FXML
    private TableColumn<?, ?> overtimecol;
    @FXML
    private TableColumn<?, ?> remarksCol;
    @FXML
    private Button BAck;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void submitButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void LoadOnClick(ActionEvent event) {
    }

    @FXML
    private void BAckOnClk(ActionEvent event) {
    }

}
