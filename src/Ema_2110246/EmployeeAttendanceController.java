/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
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
                           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Marketing_Manager_MainDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) BAck.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
