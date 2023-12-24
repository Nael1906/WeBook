package com.example.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.example.App;
import com.example.models.Book;
import com.example.models.BookBorrow;
import com.example.models.BookBorrowModel;
import com.example.utils.SceneSwitcherHelper;
import com.example.utils.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

public class HistoryPeminjamanController implements Initializable {
    @FXML
    public Button logoutButton;

    @FXML
    public Button pinjamBukuButton;

    @FXML
    public VBox peminjamanListVBox;

    @FXML
    public Text noHistoryText;

    @FXML
    public ImageView noHistoryImage;

    @FXML
    public void pimjamBukuButtonClicked(ActionEvent e) throws IOException {
        SceneSwitcherHelper.switchScene("katalog_buku", e);
    }

    @FXML
    public void logoutButtonClicked(ActionEvent e) throws IOException {
        SceneSwitcherHelper.switchScene("login", e);
    }

    private List<BookBorrow> borrowedBooks = new ArrayList<BookBorrow>();
    private BookBorrowModel bookBorrowModel = new BookBorrowModel();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        borrowedBooks = bookBorrowModel.getAllBorrows(Session.getUserId());
        noHistoryText.setVisible(borrowedBooks.isEmpty());
        noHistoryImage.setVisible(borrowedBooks.isEmpty());

        borrowedBooks.stream().forEach(book -> {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("components/history_item.fxml"));
            try {
                VBox bookCard = loader.load();
                HistoryCardController controller = loader.getController();
                controller.setData(book);
                peminjamanListVBox.getChildren().add(bookCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
