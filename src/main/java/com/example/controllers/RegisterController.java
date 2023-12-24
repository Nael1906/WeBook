package com.example.controllers;

import java.io.IOException;
import java.util.Optional;
import com.example.models.UserModel;
import com.example.utils.AlertHelper;
import com.example.utils.SceneSwitcherHelper;
import com.example.utils.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegisterController {
    @FXML
    public TextField sidField;

    @FXML
    public TextField fullNameFiled;

    @FXML
    public TextField emailField;

    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Button loginButton;

    @FXML
    public Button registerButton;

    @FXML
    public void loginButtonClicked(ActionEvent e) throws IOException {
        SceneSwitcherHelper.switchScene("login", e);
    }

    private UserModel userModel = new UserModel();

    @FXML
    public void registerButtonClicked(ActionEvent e) throws IOException {
        if (sidField.getText().isBlank() || fullNameFiled.getText().isBlank() || emailField.getText().isBlank()
                || emailField.getText().isBlank() || usernameField.getText().isBlank()
                || passwordField.getText().isBlank()) {
            AlertHelper.showAlert("Register error", "Harap mengisi semua form!", AlertType.ERROR);
            return;
        }

        boolean success = userModel.registerUser(sidField.getText(), fullNameFiled.getText(), emailField.getText(),
                usernameField.getText(), passwordField.getText());

        if (success) {
            AlertHelper.showAlert("Success", "Registrasi berhasil!", AlertType.INFORMATION);
            Optional<String> userId = userModel.loginUser(usernameField.getText(), passwordField.getText());
            if (userId.isPresent()) {
                SceneSwitcherHelper.switchScene("katalog_buku", e);
                Session.setUserId(userId.get());
            } else {
                AlertHelper.showAlert("Login Error", "Periksa kembali username dan password", AlertType.ERROR);
            }
        }
    }
}