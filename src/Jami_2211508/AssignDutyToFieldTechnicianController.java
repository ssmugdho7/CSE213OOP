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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AssignDutyToFieldTechnicianController implements Initializable {

    @FXML
    private DatePicker SelectDateDatePicker;
    @FXML
    private TextField locationTextField;
    @FXML
    private TableView<?> dutyDetailsTableView;
    @FXML
    private TableColumn<?, ?> customerIDTableColomn;
    @FXML
    private TableColumn<?, ?> datetoworkTableColomn;
    @FXML
    private TableColumn<?, ?> locationTableColomn;
    @FXML
    private TableColumn<?, ?> problemDetailsTableColomn;
    @FXML
    private TextArea problemDetailsTextArea;
    @FXML
    private TextField customerIDTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadToTableButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
    }
    
}
