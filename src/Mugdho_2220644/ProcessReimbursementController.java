/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ProcessReimbursementController implements Initializable {

    @FXML
    private TextField amount;
    @FXML
    private ComboBox<?> ExpenseDescriptionComboBox;
    @FXML
    private DatePicker expenseDate;
    @FXML
    private TextField name;
    @FXML
    private RadioButton PayableRadioButton;
    @FXML
    private RadioButton NotPayableRadioButton;
    @FXML
    private ComboBox<?> designationComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveRecordsAsBinFileOnClick(ActionEvent event) {
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
