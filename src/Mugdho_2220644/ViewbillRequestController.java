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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ViewbillRequestController implements Initializable {

    @FXML
    private TableView<?> invoiceRequestsTableview;
    @FXML
    private TableColumn<?, ?> serviceCall;
    @FXML
    private TableColumn<?, ?> dateCol;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> addCol;
    @FXML
    private Button returnButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SearchyIDTExtFeild(ActionEvent event) {
    }

    @FXML
    private void loadButtonAfterSearchTextfeildByIDOnClick(ActionEvent event) {
    }

    @FXML
    private void returnButtonInClk(ActionEvent event) {
    }
    
}
