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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MDViewPayrollDataController implements Initializable {

    @FXML
    private TableView<?> recordsTableView;
    @FXML
    private TableColumn<?, ?> nameTableCol;
    @FXML
    private TableColumn<?, ?> empIDTableCol;
    @FXML
    private TableColumn<?, ?> saalryTableCol;
    @FXML
    private TableColumn<?, ?> BonusTableCol;
    @FXML
    private TableColumn<?, ?> OvertimeTableCol;
    @FXML
    private TableColumn<?, ?> designationTableCol;
    @FXML
    private TableColumn<?, ?> paymentMethodTableCol;
    @FXML
    private TableColumn<?, ?> monthPaidTableCol;
    @FXML
    private TableColumn<?, ?> DatePaidTableCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void saveRecordsButtonOnClick(ActionEvent event) {
    }
    
}
