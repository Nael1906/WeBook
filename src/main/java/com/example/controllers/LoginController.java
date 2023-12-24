package com.example.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import com.example.App;
import com.example.models.UserModel;
import com.example.utils.AlertHelper;
import com.example.utils.SceneSwitcherHelper;
import com.example.utils.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController  {
    private UserModel userModel = new UserModel();

    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Button loginButton;

    @FXML
    public Button registerButton;

    @FXML
    public Text forgotPasswordText;

    @FXML
    public void loginButtonClicked(ActionEvent e) throws IOException {
        if (usernameField.getText().isBlank() || passwordField.getText().isBlank()) {
            AlertHelper.showAlert("Login Error", "Username and password harus diisi!", AlertType.ERROR);
            return;
        }

        Optional<String> userId = userModel.loginUser(usernameField.getText(), passwordField.getText());
        if (userId.isPresent()) {
            SceneSwitcherHelper.switchScene("katalog_buku", e);
            Session.setUserId(userId.get());
            AlertHelper.showAlert("Success", "Login berhasil!", AlertType.INFORMATION);
        } else {
            AlertHelper.showAlert("Login Error", "Periksa kembali username dan password", AlertType.ERROR);
        }
    }

    @FXML
    public void registerButtonClicked(ActionEvent e) throws IOException {
        SceneSwitcherHelper.switchScene("register", e);
        forgotPasswordText.setOnMouseClicked(null);
    }

    @FXML 
    public void forgotPasswordClicked(MouseEvent e) throws IOException {
        SceneSwitcherHelper.switchScene("change_password", e);
    }
   
}
