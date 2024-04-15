/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MDViewAuditReportController implements Initializable {

    @FXML
    private TableView<AuditReport> auditTableView;
    @FXML
    private TableColumn<AuditReport, LocalDate> dateTableCol;
    @FXML
    private TableColumn<AuditReport, String> titleTableCol;
    @FXML
    private TableColumn<AuditReport, String> findingsTableCol;
    @FXML
    private TableColumn<AuditReport, String> recommendationsTableCol;
    @FXML
    private TableColumn<AuditReport, String> commentsTableCol;

    List<AuditReport> reports = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        titleTableCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        findingsTableCol.setCellValueFactory(new PropertyValueFactory<>("findings"));
        recommendationsTableCol.setCellValueFactory(new PropertyValueFactory<>("recommendations"));
        commentsTableCol.setCellValueFactory(new PropertyValueFactory<>("comments"));
        
        auditTableView.getItems().addAll(reports);
    }    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        reports = AuditReport.readFromFileForAuditReport("auditReport.bin");
        auditTableView.getItems().clear();
        auditTableView.getItems().addAll(reports);
    }
    
    
    @FXML
    private void saveButtonOnClick(ActionEvent event) {
    }

    
    
}
