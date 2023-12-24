package com.example.controllers;

import java.io.IOException;

import com.example.models.Book;
import com.example.models.BookBorrow;
import com.example.models.BookBorrowModel;
import com.example.models.BookModel;
import com.example.utils.AlertHelper;
import com.example.utils.CurrentTime;
import com.example.utils.SceneSwitcherHelper;
import com.example.utils.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class BorrowBookCardController {
    @FXML
    public Text bookTitleText; 

    @FXML
    public Text bookCodeText; 


    @FXML
    public Label descriptionLabel; 


    private int bookId; 
    private BookBorrowModel bookBorrowModel = new BookBorrowModel();

    @FXML
    public void borrowBookButtonClicked(ActionEvent e) throws IOException {
        bookBorrowModel.insertBorrow(bookId, CurrentTime.getCurrentTime(), Session.getUserId());
        AlertHelper.showAlert("Success", "Buku berhasil dipinjam!", AlertType.INFORMATION);

        // untuk refresh tampilan list buku
        SceneSwitcherHelper.switchScene("katalog_buku", e);
    }

    public void setData(Book book) {
        bookTitleText.setText(book.getName());
        bookCodeText.setText(book.getCode());
        descriptionLabel.setText(book.getDescription());
        this.bookId = Integer.valueOf(book.getId());
    }
}
