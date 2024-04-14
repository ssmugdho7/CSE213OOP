package Mugdho_2220644;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
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
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize ComboBoxes
        designationComboBox.getItems().addAll("Accountant", "Field Technician", "Network Engineer", "Technical Support Representative", "Marketing Manager", "Customer Care Representative");
        paymentMethodComboBox.getItems().addAll("Bkash", "Nagad", "Rocket", "Bank");
        sallaryMonthCombobox.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        // Initialize TableView
        fildercOMBOBOX.getItems().addAll("Latest Date", "Month");
        initializeTableView();

        // Initialize records list
        records = new ArrayList<>();

        // Listener for searchTextField
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> searchRecordsByEmpId());
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
        try {
            String salaryText = salaryTextField.getText();
            String bonusesText = bonusesTextField.getText();
            String overtimeText = overtimeTextField.getText();

            if (salaryText.isEmpty() || bonusesText.isEmpty() || overtimeText.isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "Fields are empty", "Please enter values in all fields.");
                return;
            }

            float salary = Float.parseFloat(salaryText);
            float bonuses = Float.parseFloat(bonusesText);
            float overtime = Float.parseFloat(overtimeText);

            float totalSalary = salary + bonuses + overtime;
            totalSallaryLabel.setText(String.valueOf(totalSalary));
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Error", "Invalid input", "Please enter valid numbers in salary, bonuses, and overtime fields.");
        }
    }

    @FXML
    private void saveRecordButtonClicked(ActionEvent event) {
        if (validateSysInput()) {
            Payroll newPayroll = createPayrollFromInput();
            if (newPayroll != null) {
                records.add(newPayroll);
                updateTableView();
                newPayroll.writeToBinaryFile(records);
                clearInputFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to save record", "Please fill up all the fields properly.");
            }
        }
    }

    private void clearInputFields() {
        userIdTextField.clear();
        nameTextField.clear();
        designationComboBox.getSelectionModel().clearSelection();
        paymentMethodComboBox.getSelectionModel().clearSelection();
        salaryTextField.clear();
        bonusesTextField.clear();
        overtimeTextField.clear();
        sallaryMonthCombobox.getSelectionModel().clearSelection();
        sallaryDate.setValue(null);
    }

    private boolean validateSysInput() {
        if (userIdTextField.getText().isEmpty()
                || nameTextField.getText().isEmpty()
                || designationComboBox.getSelectionModel().isEmpty()
                || paymentMethodComboBox.getSelectionModel().isEmpty()
                || salaryTextField.getText().isEmpty()
                || bonusesTextField.getText().isEmpty()
                || overtimeTextField.getText().isEmpty()
                || sallaryMonthCombobox.getSelectionModel().isEmpty()
                || sallaryDate.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, "Incomplete Input", "Please fill up all the fields properly.", null);
            return false;
        }
        return true;
    }

// Method to show an alert dialog
    private void showAlert(Alert.AlertType alertType, String title, String message, String details) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    private Payroll createPayrollFromInput() {
        int empId = Integer.parseInt(userIdTextField.getText());
        String empName = nameTextField.getText();
        String empDesign = designationComboBox.getValue();
        String paymentMethod = paymentMethodComboBox.getValue();
        float salary = Float.parseFloat(salaryTextField.getText());
        float bonuses = Float.parseFloat(bonusesTextField.getText());
        float overtime = Float.parseFloat(overtimeTextField.getText());
        String month = sallaryMonthCombobox.getValue();
        LocalDate datePaid = sallaryDate.getValue();

        return new Payroll(empId, empName, empDesign, paymentMethod, salary, bonuses, overtime, month, datePaid);

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

        int userId;
        try {
            userId = Integer.parseInt(userIdText);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Error", "Invalid user ID. Please enter a valid int value.", "");
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

    @FXML
    private void loadButtonClicked(ActionEvent event) {
        recordsTableView.getItems().clear();
        try {
            Payroll payroll = new Payroll(); // Assuming default constructor is provided
            records = payroll.readFromBinaryFile();
            updateTableView();
            searchRecordsByEmpId();
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error", "Failed to load records", e.getMessage());
        }
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
        totalSallaryLabel.setText("");

        recordsTableView.getItems().clear();
        try {
            Payroll payroll = new Payroll(0, "", "", "", 0.0f, 0.0f, 0.0f, "", LocalDate.now()); // Provide appropriate constructor arguments
            records = payroll.readFromBinaryFile();
            updateTableView();
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error", "Failed to refresh records", e.getMessage());
        }
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
                    records.sort(Comparator.comparing(Payroll::getDatePaid, Comparator.nullsLast(Comparator.naturalOrder())).reversed());
                    break;
                case "Month":
                    records.sort(Comparator.comparing(Payroll::getMonth, Comparator.nullsLast(Comparator.naturalOrder())));
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

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountantDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
