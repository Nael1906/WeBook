package com.example.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.example.App;
import com.example.models.Book;
import com.example.models.BookModel;
import com.example.utils.SceneSwitcherHelper;
import com.example.utils.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class KatalogBukuController implements Initializable {
    @FXML
    public Button historyButton;

    @FXML
    public Button logoutButton;

    @FXML
    public Button cariButton;

    @FXML
    public TextField cariBukuTextField;

    @FXML
    public VBox listBukuVBox;

    private List<Book> books = new ArrayList<Book>();
    private BookModel bookModel = new BookModel();

    @FXML
    public void logoutButtonClicked(ActionEvent e) throws IOException {
        SceneSwitcherHelper.switchScene("login", e);
        Session.setUserId("");
    }

    @FXML
    public void historyButtonClicked(ActionEvent e) throws IOException {
        SceneSwitcherHelper.switchScene("history", e);
    }

    @FXML
    public void searchButtonClicked(ActionEvent e) {

        books = bookModel.searchBook(cariBukuTextField.getText());
        listBukuVBox.getChildren().clear();
        books.stream().forEach(book -> {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("components/borrow_book_card.fxml"));
            try {
                VBox bookCard = loader.load();
                BorrowBookCardController controller = loader.getController();
                controller.setData(book);
                listBukuVBox.getChildren().add(bookCard);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        fetchAllBooks();
        listBukuVBox.setSpacing(10);
    }

    private void fetchAllBooks() {
        books = bookModel.getAllBooks();
        listBukuVBox.setSpacing(10); // Menambahkan jarak antar kartu buku
        books.stream().forEach(book -> {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("components/borrow_book_card.fxml"));
            try {
                VBox bookCard = loader.load();
                BorrowBookCardController controller = loader.getController();
                controller.setData(book);
                listBukuVBox.getChildren().add(bookCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
