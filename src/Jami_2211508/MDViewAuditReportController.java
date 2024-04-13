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
public class MDViewAuditReportController implements Initializable {

    @FXML
    private TableView<?> auditTableView;
    @FXML
    private TableColumn<?, ?> dateTableCol;
    @FXML
    private TableColumn<?, ?> titleTableCol;
    @FXML
    private TableColumn<?, ?> findingsTableCol;
    @FXML
    private TableColumn<?, ?> recommendationsTableCol;
    @FXML
    private TableColumn<?, ?> commentsTableCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
    }
    
}
