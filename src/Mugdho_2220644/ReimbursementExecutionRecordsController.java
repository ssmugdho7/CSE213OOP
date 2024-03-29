/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ReimbursementExecutionRecordsController implements Initializable {

    @FXML
    private TableView<?> reimbursementTable;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> designationColumn;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> statusColumn;
    @FXML
    private TableColumn<?, ?> expenseTypeColumn;
    @FXML
    private TableColumn<?, ?> amountColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoadDataOnClocl(ActionEvent event) {
    }

    @FXML
    private void fiterByDateOnClick(ActionEvent event) {
    }

    @FXML
    private void saveAsPDF(ActionEvent event) {
    }

    @FXML
    private void FormatBinFileData(ActionEvent event) {
    }
    
}
