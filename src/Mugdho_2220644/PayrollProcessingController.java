package Mugdho_2220644;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import mainPKG.Employee;

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
    private TableColumn<Payroll, Float> saalryCol;
    @FXML
    private TableColumn<Payroll, Float> BonusCol;
    @FXML
    private TableColumn<Payroll, Float> OvertimecOL;
    @FXML
    private TableColumn<Payroll, String> dESIGNcoL;
    @FXML
    private TableColumn<Payroll, String> pAYMENTMETHODcoL;

    @FXML
    private TableColumn<Payroll, String> monthPaidCol;
    @FXML
    private TableColumn<Payroll, LocalDate> DatePaidCol;
    @FXML
    private DatePicker sallaryDate;
    @FXML
    private ComboBox<String> sallaryMonthCombobox;

    private ArrayList<Payroll> records;

    @FXML
    private ComboBox<String> fildercOMBOBOX;
    @FXML
    private Label totalSallaryLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize ComboBoxes
        designationComboBox.getItems().addAll("Accountant", "Field Technician", "Network Engineer", "Technical Support Representative", "Marketing Manager", "Customer Care Representative");
        paymentMethodComboBox.getItems().addAll("Bkash", "Nagad", "Rocket", "Bank");
        sallaryMonthCombobox.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        // Initialize TableView
        initializeTableView();

        // Initialize records list
        records = new ArrayList<>();

        // Listener for searchTextField
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> searchButtonClicked());
    }

    private void initializeTableView() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("empName"));
        empIDCol.setCellValueFactory(new PropertyValueFactory<>("empId"));
        saalryCol.setCellValueFactory(new PropertyValueFactory<>("salaryAmount"));
        BonusCol.setCellValueFactory(new PropertyValueFactory<>("bonusAmount"));
        OvertimecOL.setCellValueFactory(new PropertyValueFactory<>("overtimeAmount"));
        dESIGNcoL.setCellValueFactory(new PropertyValueFactory<>("empDesign"));
        pAYMENTMETHODcoL.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        monthPaidCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        DatePaidCol.setCellValueFactory(new PropertyValueFactory<>("datePaid"));
        saalryCol.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        BonusCol.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        OvertimecOL.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        // Set on edit commit event handlers
        saalryCol.setOnEditCommit(this::updateSalary);
        BonusCol.setOnEditCommit(this::updateBonus);
        OvertimecOL.setOnEditCommit(this::updateOvertime);
    }

    @FXML
    private void calculateTotalSalaryButtonClicked(ActionEvent event) {
        float totalSalary = Float.parseFloat(salaryTextField.getText())
                + Float.parseFloat(bonusesTextField.getText())
                + Float.parseFloat(overtimeTextField.getText());
        totalSalaryLabel.setText(String.valueOf(totalSalary));
    }

    @FXML
    private void saveRecordButtonClicked(ActionEvent event) {
               if (validateInput()) {
        try {
            int userId = Math.round(Float.parseFloat(userIdTextField.getText()));
int salary = (int) Math.round(Float.parseFloat(salaryTextField.getText()));

           
            int bonuses = (int) Math.round(Float.parseFloat(bonusesTextField.getText()));
            int overtime = (int) Math.round(Float.parseFloat(overtimeTextField.getText()));

            Payroll payroll = new Payroll(
                salary,
                bonuses,
                overtime,
                sallaryMonthCombobox.getValue(),
                sallaryDate.getValue(),
                userId,
                nameTextField.getText(),
                designationComboBox.getValue(),
                paymentMethodComboBox.getValue()
            );
            records.add(payroll);
            payroll.writeToBinaryFile(records);
            updateTableView();
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Error", "Invalid input. Please enter valid numeric values.", "");
        }
    }
    }

    private boolean validateInput() {
        // Get values from input fields
        
        String name = nameTextField.getText();
        String userIdText = userIdTextField.getText();
        float salary = Float.parseFloat(salaryTextField.getText());
        float bonuses = Float.parseFloat(bonusesTextField.getText());
        float overtime = Float.parseFloat(overtimeTextField.getText());

        // Check if any of the fields are empty
        if (name.isEmpty() || userIdText.isEmpty()) {
            showAlert(AlertType.ERROR, "Error", "Name and User ID are required fields.", "");
            return false;
        }

        // Validate user ID (should be a valid float)
        float userId;
        try {
            userId = Float.parseFloat(userIdText);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Error", "Invalid user ID. Please enter a valid floating-point value.", "");
            return false;
        }

        // Validate salary (should be a valid float)
        if (salary < 0) {
            showAlert(AlertType.ERROR, "Error", "Salary cannot be negative.", "");
            return false;
        }

        // Validate bonuses (should be a valid float)
        if (bonuses < 0) {
            showAlert(AlertType.ERROR, "Error", "Bonuses cannot be negative.", "");
            return false;
        }

        // Validate overtime (should be a valid float)
        if (overtime < 0) {
            showAlert(AlertType.ERROR, "Error", "Overtime cannot be negative.", "");
            return false;
        }

        // All validations passed
        return true;
    }

    private void showAlert(AlertType ERROR, String title, String message, String string) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void loadButtonClicked(ActionEvent event) {
        recordsTableView.getItems().clear();
        Payroll payroll = new Payroll(0, "", "", "", 0.0f, 0.0f, 0.0f, "", LocalDate.now()); // Adjust constructor arguments as needed
        records = payroll.readFromBinaryFile();
        updateTableView();
        searchRecordsByEmpId();
    }

    private void searchRecordsByEmpId() {
        String empId = searchTextField.getText();
        if (!empId.isEmpty()) {
            ArrayList<Payroll> searchResults = new ArrayList<>();
            for (Payroll payroll : records) {
                if (String.valueOf(payroll.getEmpId()).equals(empId)) {
                    searchResults.add(payroll);
                }
            }
            recordsTableView.getItems().clear();
            recordsTableView.getItems().addAll(searchResults);
        }
    }

    @FXML
    private void refreshButtonClicked(ActionEvent event) {
        nameTextField.clear();
        userIdTextField.clear();
        salaryTextField.clear();
        bonusesTextField.clear();
        overtimeTextField.clear();
        totalSalaryLabel.setText("Sallary Label");

        recordsTableView.getItems().clear();
        Payroll payroll = new Payroll(0, "", "", "", 0.0f, 0.0f, 0.0f, "", LocalDate.now()); // Adjust constructor arguments as needed
        records = payroll.readFromBinaryFile();
        updateTableView();
    }

    private void updateTableView() {
        ObservableList<Payroll> payrollList = FXCollections.observableArrayList(records);
        recordsTableView.setItems(payrollList);
    }

    @FXML
    private void filtercomboinClk(ActionEvent event) {
        String filterCriteria = fildercOMBOBOX.getValue();
        if (filterCriteria != null) {
            switch (filterCriteria) {
                case "Latest Date":
                    records.sort(Comparator.comparing(Payroll::getDatePaid).reversed());
                    break;
                case "Designation":
                    records.sort(Comparator.comparing(Payroll::getEmpDesign));
                    break;
                case "Month":
                    records.sort(Comparator.comparing(Payroll::getMonth));
                    break;
                default:
                    break;
            }
            updateTableView();
        }
    }

    private void updateSalary(TableColumn.CellEditEvent<Payroll, Float> event) {
        Payroll payroll = event.getRowValue();
        payroll.setSalaryAmount(event.getNewValue());
        payroll.writeToBinaryFile(records);
    }

    private void updateBonus(TableColumn.CellEditEvent<Payroll, Float> event) {
        Payroll payroll = event.getRowValue();
        payroll.setBonusAmount(event.getNewValue());
        payroll.writeToBinaryFile(records);
    }

    private void updateOvertime(TableColumn.CellEditEvent<Payroll, Float> event) {
        Payroll payroll = event.getRowValue();
        payroll.setOvertimeAmount(event.getNewValue());
        payroll.writeToBinaryFile(records);
    }

}