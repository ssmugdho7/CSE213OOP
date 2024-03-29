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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ViewRequestReimursementReqController implements Initializable {

    @FXML
    private TableView<?> RequestReimbursementDataTableView;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> amountColumn;
    @FXML
    private TableColumn<?, ?> paymentMethodColumn;
    @FXML
    private TableColumn<?, ?> expenseTypeColumn;
    @FXML
    private TableColumn<?, ?> reqDateColumn;
    @FXML
    private TableColumn<?, ?> designationColumn;
    @FXML
    private ComboBox<?> paymentMethodComboBox;
    @FXML
    private Button loadReqOnClick;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveTAbleviewContentAsPDFOnCLick(ActionEvent event) {
    }
    
}
