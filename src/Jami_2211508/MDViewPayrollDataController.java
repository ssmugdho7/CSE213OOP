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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MDViewPayrollDataController implements Initializable {

    @FXML
    private TableView<Payroll> recordsTableView;
    @FXML
    private TableColumn<Payroll, String> nameTableCol;
    @FXML
    private TableColumn<Payroll, Integer> empIDTableCol;
    @FXML
    private TableColumn<Payroll, Float> saalryTableCol;
    @FXML
    private TableColumn<Payroll, Float> BonusTableCol;
    @FXML
    private TableColumn<Payroll, Float> OvertimeTableCol;
    @FXML
    private TableColumn<Payroll, String> designationTableCol;
    @FXML
    private TableColumn<Payroll, String> paymentMethodTableCol;
    @FXML
    private TableColumn<Payroll, String> monthPaidTableCol;
    @FXML
    private TableColumn<Payroll, LocalDate> DatePaidTableCol;
    
    //List<Payroll> records = new ArrayList<>();
    private ArrayList<Payroll> records;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        records = new ArrayList<>();
        
        nameTableCol.setCellValueFactory(new PropertyValueFactory<>("empName"));
        empIDTableCol.setCellValueFactory(new PropertyValueFactory<>("empId"));
        saalryTableCol.setCellValueFactory(new PropertyValueFactory<>("salaryAmount"));
        BonusTableCol.setCellValueFactory(new PropertyValueFactory<>("bonusAmount"));
        OvertimeTableCol.setCellValueFactory(new PropertyValueFactory<>("overtimeAmount"));
        designationTableCol.setCellValueFactory(new PropertyValueFactory<>("empDesign"));
        paymentMethodTableCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        monthPaidTableCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        DatePaidTableCol.setCellValueFactory(new PropertyValueFactory<>("datePaid"));
        saalryTableCol.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        BonusTableCol.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        OvertimeTableCol.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        
        recordsTableView.getItems().addAll(records);
    }    


    @FXML
    private void saveRecordsButtonOnClick(ActionEvent event) {

        
    }
    
    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
//        records = Payroll.readFromBinaryFile("payroll.bin");
//        recordsTableView.getItems().clear();
//        recordsTableView.getItems().addAll(records);
//        recordsTableView.getItems().clear();

        try {
            Payroll payroll = new Payroll(); // Assuming default constructor is provided
            records = payroll.readFromBinaryFile();
//            updateTableView();
//            searchRecordsByEmpId();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load records", e.getMessage());
        }
        
        
    }
    private void showAlert(Alert.AlertType alertType, String title, String message, String details) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
    
}
