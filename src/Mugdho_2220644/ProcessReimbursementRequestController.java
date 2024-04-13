/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.awt.Font;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ProcessReimbursementRequestController implements Initializable {

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private DatePicker expenseDatePicker;

    @FXML
    private ComboBox<String> designationComboBox;

    @FXML
    private ToggleGroup statusRadioBox;

    @FXML
    private TextField amountTextField;

    @FXML
    private ComboBox<String> expenseTypeComboBox;

    @FXML
    void saveRecordsButtonOnClick(ActionEvent event) {
    }
    // Helper method to get the selected status from the radio buttons
    private String getStatusFromRadioBox() {
        RadioButton selectedRadioButton = (RadioButton) statusRadioBox.getSelectedToggle();
        return selectedRadioButton.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize combo boxes
        designationComboBox.getItems().addAll("Field Technician", "Marketing Manager");
        expenseTypeComboBox.getItems().addAll("Hardware", "Fund");
    }

   


    @FXML
    private void loadPrevRecordsOnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReimbursementExecutionRecords.fxml"));
        Parent parent = fxmlLoader.load();
        
        // Retrieve preferred height and width from the loaded parent node
        double prefHeight = parent.prefHeight(USE_COMPUTED_SIZE);
        double prefWidth = parent.prefWidth(USE_COMPUTED_SIZE);
        
        Stage stage = new Stage();
        stage.setTitle("Reimbursement Processing records");
        stage.setScene(new Scene(parent, prefWidth, prefHeight));
        stage.show();
    }
    
}
