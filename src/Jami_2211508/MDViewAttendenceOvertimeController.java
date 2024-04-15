/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class MDViewAttendenceOvertimeController implements Initializable {

    @FXML
    private TableView<?> attendenceTableView;
    @FXML
    private TableColumn<?, ?> designationTableCol;
    @FXML
    private TableColumn<?, ?> dateTableCol;
    @FXML
    private TableColumn<?, ?> overtimeTableCol;
    @FXML
    private TableColumn<?, ?> remarksTableCol;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
