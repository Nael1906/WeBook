package com.example.controllers;

import java.io.IOException;
import com.example.models.UserModel;
import com.example.utils.AlertHelper;
import com.example.utils.SceneSwitcherHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ForgotPasswordController {
    @FXML
    public TextField NIMTextField; 

    @FXML
    public TextField usernameTextField;

    @FXML
    public PasswordField newPasswordField;

    @FXML
    public Button changePasswordButton; 

    @FXML 
    public Button loginButton; 

    private UserModel userModel = new UserModel();


    @FXML
    public void onLoginButtonClicked(ActionEvent e) throws IOException {
        SceneSwitcherHelper.switchScene("login", e);
    }

    @FXML
    public void changePasswordButtonClicked(ActionEvent e) throws IOException {
        if (NIMTextField.getText().isBlank() || usernameTextField.getText().isBlank() || newPasswordField.getText().isBlank()) {
            AlertHelper.showAlert("Error", "Mohon mengisi semua field", AlertType.ERROR);
            return; 
        }

        boolean success = userModel.changePassword(NIMTextField.getText(), newPasswordField.getText(), usernameTextField.getText());
        if (success) {
            SceneSwitcherHelper.switchScene("login", e);
            AlertHelper.showAlert("Success", "Password berhasil diupdate!", AlertType.INFORMATION);
        } else {
            AlertHelper.showAlert("Success", "Periksa kembali NIM, username, dan password baru", AlertType.INFORMATION);
        }
    }
}
