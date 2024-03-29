/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mainPKG.Employee;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class PayrollProcessingController implements Initializable {

    @FXML
    private TextField searchTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField bonusesTextField;
    @FXML
    private TextField overtimeTextField;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private ComboBox<String> paymentMethodComboBox;
    @FXML
    private Button calculateTotalSalaryButton;
    @FXML
    private Button saveRecordButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TableView<Payroll> recordsTableView;
    @FXML
    private TableColumn<Payroll, String> nameCol;
    @FXML
    private TableColumn<Payroll, Integer> empIDCol;
    @FXML
    private TableColumn<Payroll,Float> saalryCol;
    @FXML
    private TableColumn<Payroll,Float> BonusCol;
    @FXML
    private TableColumn<Payroll, Float> OvertimecOL;
    @FXML
    private TableColumn<Payroll, String> dESIGNcoL;
    @FXML
    private TableColumn<Payroll, String > pAYMENTMETHODcoL;
    @FXML
    private Label totalSalaryLabel;
    @FXML
    private ComboBox<?> fildercOMBOBOX;
    @FXML
    private Label totalSallaryLabel;
    @FXML
    private TableColumn<Payroll, String> monthPaidCol;
    @FXML
    private TableColumn<Payroll, LocalDate> DatePaidCol;
    @FXML
    private DatePicker sallaryDate;
    @FXML
    private ComboBox<String> sallaryMonthCombobox;


    
     
    ArrayList <Payroll>records;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         designationComboBox.getItems().addAll("Accountant", "Field Technician","Network Engineer", "Technical Support Representative", "Marketing Manager", "Customer Care Representative");
         paymentMethodComboBox.getItems().addAll("Bkash", "Nagad", "Rocket", "Bank");
         sallaryMonthCombobox.getItems().addAll("January","February", "March","April", "May", "June", "July", "August", "September", "October", "November", "December");   
    
    nameCol.setCellValueFactory(new PropertyValueFactory<Payroll, String>("empName"));
    empIDCol.setCellValueFactory(new PropertyValueFactory<Payroll, Integer>("empId"));
    saalryCol.setCellValueFactory(new PropertyValueFactory<Payroll, Float>("salaryAmount"));
    BonusCol.setCellValueFactory(new PropertyValueFactory<Payroll,Float>("bonusAmount"));
    OvertimecOL.setCellValueFactory(new PropertyValueFactory<Payroll, Float>("overtimeAmount"));
    dESIGNcoL.setCellValueFactory(new PropertyValueFactory<Payroll, String>("empDesign"));
    pAYMENTMETHODcoL.setCellValueFactory(new PropertyValueFactory<Payroll, String>("paymentMethod"));
    monthPaidCol.setCellValueFactory(new PropertyValueFactory<Payroll, String>("month"));
    DatePaidCol.setCellValueFactory(new PropertyValueFactory<Payroll, LocalDate>("datePaid"));
    
    
    records = new ArrayList<Payroll>();
    
    
    
    
    }    

    @FXML
    private void calculateTotalSalaryButtonClicked(ActionEvent event) {
     Payroll x = new Payroll(Float.parseFloat(salaryTextField.getText()), 
                         Float.parseFloat(bonusesTextField.getText()),                                                  
                        Float.parseFloat(overtimeTextField.getText()),                         
                    sallaryMonthCombobox.getValue(),                           
                           sallaryDate.getValue() ,                               
                          Integer.parseInt(userIdTextField.getText()),                       
                            nameTextField.getText(),                             
                     designationComboBox.getValue(),
                    paymentMethodComboBox.getValue());
     records.add(x); 
    


    totalSalaryLabel.setText("Sallary is : " + x.getTotalSalaryAmount());
    
    }

    @FXML
    private void saveRecordButtonClicked(ActionEvent event) {
    
       for(Payroll s: records){
      recordsTableView.getItems().add(s);

//    for(Payroll s: records){
//            recordsTableView.getItems().add(new Payroll(s.getSalaryAmount(),
//                                         s.getBonusAmount(),
//                                         s.getOvertimeAmount(),
//                    s.getMonth(),
//                    s.getDatePaid()
//            
            
            
            
            
            
            
            
            
            
            
            
            
//            ));
//    for (CartItem c : cartList) {
//            cartTV.getItems().add(
//                    new CartDummy(c.getProductName(), c.getUnitPrice(), c.getVatRate(), c.getQuantity(),
//                                    c.getVatAmount(), c.getTotalAmount()));
    }
    }
    
    
    @FXML
    private void loadButtonClicked(ActionEvent event) {
    }

    @FXML
    private void refreshButtonClicked(ActionEvent event) {
        nameTextField.clear();
        userIdTextField.clear();
        salaryTextField.clear();
        bonusesTextField.clear();
        overtimeTextField.clear();
         totalSalaryLabel.setText("");
    }
    
}
      