package mainPKG;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField newUserNameTextField;
    @FXML
    private TextField newUserPhoneNumberTextField;
    @FXML
    private TextField newPasswordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private DatePicker newUserDob;
    @FXML
    private Button signup;
    @FXML
    private Button goback;
    @FXML
    private TextField newNameTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Accountant", "Customer",
                "Field Technician", "Marketing Manager", "Customer Care Representative",
                "Managing Director", "Efficient Support Representative", "Network Engineer");
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) goback.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            showAlert("Error", "Error Loading Scene", "An error occurred while loading the login scene.");
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void createAccountButtonOnClick(ActionEvent event) {

        if (!validateFields()) {
            showAlert("Error", "Incomplete Information", "Please fill in all fields before signing up.");
            return;
        }

        if (!validatePasswords()) {
            showAlert("Error", "Passwords Mismatch", "Passwords do not match. Please re-enter.");
            return;
        }

        if (!validateAge()) {
            showAlert("Error", "Invalid Age", "Minimum age required is 8 years old.");
            return;
        }

        String fullName = newNameTextField.getText();
        String userName = newUserNameTextField.getText();
        String phoneNumber = newUserPhoneNumberTextField.getText();
        String password = newPasswordTextField.getText();
        LocalDate dob = newUserDob.getValue();
        User newUser = new User(fullName, userName, phoneNumber, password, dob);

        // Check for unique user ID, assuming you have a method for it
        if (!isUserIDUnique(userName)) {
            showAlert("Error", "Username Taken", "This username already exists. Please choose another one.");
            return;
        }

        Boolean success = SignUpFile.SignUpFileWrite(newUser, userTypeComboBox.getValue());
        if (success) {
            showAlert("Success", "Account Created", "Your sign up is complete.");
        } else {
            showAlert("Error", "Sign Up Failed", "An error occurred during sign up. Please try again.");
        }

        clearFields();
    }

    private boolean validateFields() {
        return !newNameTextField.getText().isEmpty()
                && !newUserNameTextField.getText().isEmpty()
                && !newUserPhoneNumberTextField.getText().isEmpty()
                && !newPasswordTextField.getText().isEmpty()
                && !confirmPasswordTextField.getText().isEmpty()
                && newUserDob.getValue() != null;
    }

    private boolean validatePasswords() {
        return newPasswordTextField.getText().equals(confirmPasswordTextField.getText());
    }

    private boolean validateAge() {
        LocalDate dob = newUserDob.getValue();
        return dob != null && dob.plusYears(8).isBefore(LocalDate.now());
    }

    private boolean isUserIDUnique(String userName) {
    
        //need to implement this method 
        return true;
    }

    private void clearFields() {
        newNameTextField.clear();
        newUserNameTextField.clear();
        newUserPhoneNumberTextField.clear();
        newPasswordTextField.clear();
        confirmPasswordTextField.clear();
        newUserDob.setValue(null);
    }

}
