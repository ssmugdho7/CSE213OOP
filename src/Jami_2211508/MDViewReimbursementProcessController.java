/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MDViewReimbursementProcessController implements Initializable {

    @FXML
    private Label reimbursementTableView;
    @FXML
    private TableColumn<?, ?> nameTableCol;
    @FXML
    private TableColumn<?, ?> IDTableCol;
    @FXML
    private TableColumn<?, ?> designationTableCol;
    @FXML
    private TableColumn<?, ?> dateTableCol;
    @FXML
    private TableColumn<?, ?> payStatusTableCol;
    @FXML
    private TableColumn<?, ?> amountTableCol;
    @FXML
    private TableColumn<?, ?> expenseTypeTableCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
