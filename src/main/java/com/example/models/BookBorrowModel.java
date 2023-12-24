package com.example.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.utils.ConnectionManager;

public class BookBorrowModel {
    private BookModel bookModel = new BookModel();

    public void insertBorrow(int bookId, String borrowedAt, String userId) {
        System.out.println("BUKU  DIPINJAM");
        try (Connection conn = ConnectionManager.getConnection()) {
            String sql = "INSERT INTO book_borrows(book_id, borrowed_at, user_id) VALUES (?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, bookId);
            pStmt.setString(2, borrowedAt);
            pStmt.setString(3, userId);
            pStmt.executeUpdate();
            bookModel.updateBorrowStatus(bookId, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BookBorrow> getAllBorrows(String userId) {
        List<BookBorrow> bookBorrows = new ArrayList<BookBorrow>();

        try (Connection conn = ConnectionManager.getConnection()) {
            String sql = "SELECT book_borrows.borrowed_at, book_borrows.id as borrow_id, books.* from book_borrows INNER JOIN books ON books.id = book_borrows.book_id AND book_borrows.user_id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, userId);
            ResultSet rSet = pStmt.executeQuery();
            while (rSet.next()) {
                BookBorrow borrowed = new BookBorrow(rSet.getString("name"), rSet.getString("code"),
                        rSet.getString("borrowed_at"), rSet.getString("borrow_id"), rSet.getString("description"),
                        rSet.getString("id"));
                bookBorrows.add(borrowed);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookBorrows;
    }

    public void deleteBorrow(int borrowId) {
        try (Connection conn = ConnectionManager.getConnection()) {
            String sql = "DELETE FROM book_borrows WHERE id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, borrowId);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
