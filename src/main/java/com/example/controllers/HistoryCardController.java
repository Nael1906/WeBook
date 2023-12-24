package com.example.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class HistoryCardController  {
    @FXML
    public Text bookTitleText; 

    @FXML
    public Text bookCodeText; 


    @FXML
    public Label descriptionLabel; 

    @FXML
    public Label borrowedAtLabel; 

    @FXML
    public Button returnBookButton; 

    private int borrowId; 
    private int bookId; 
    private BookBorrowModel bookBorrowModel = new BookBorrowModel();
    private BookModel bookModel = new BookModel();

    @FXML
    public void returnBookButtonClicked(ActionEvent e) throws IOException {
        bookBorrowModel.deleteBorrow(borrowId);
        System.out.println("book id =" + bookId);
        System.out.println("borrow id =" + borrowId);

        bookModel.updateBorrowStatus(bookId, 0);
        AlertHelper.showAlert("Success", "Buku berhasil dikembalikan!", AlertType.INFORMATION);

        // untuk refresh tampilan list buku
        SceneSwitcherHelper.switchScene("history", e);
    }

    public void setData(BookBorrow book) {
        bookTitleText.setText(book.getBookTitle());
        bookCodeText.setText(book.getKodeBuku());
        descriptionLabel.setText(book.getDescription());
        borrowedAtLabel.setText(String.format("Dipinjam pada tanggal %s", book.getBorrowedAt()));
        this.borrowId = Integer.valueOf(book.getBorrowId());
        this.bookId = Integer.valueOf(book.getBookId());
    }

}
