package com.example.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.utils.ConnectionManager;
import com.example.utils.Session;

public class BookModel {

    public List<Book> searchBook(String searchValue) {
        List<Book> bookList = new ArrayList<Book>();

        try (Connection conn = ConnectionManager.getConnection()) {
            String sql = "SELECT * FROM books WHERE is_borrowed = 0 AND name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, searchValue + '%');

            ResultSet rSet = stmt.executeQuery();

            while (rSet.next()) {
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                String code = rSet.getString("code");
                String description = rSet.getString("description");
                boolean isBorrowed = rSet.getBoolean("is_borrowed");

                bookList.add(new Book(id, name, code, description, isBorrowed));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<Book>();

        try (Connection conn = ConnectionManager.getConnection()) {
            String sql = "SELECT * FROM books WHERE is_borrowed = 0";
            Statement stmt = conn.createStatement();
            ResultSet rSet = stmt.executeQuery(sql);

            while (rSet.next()) {
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                String code = rSet.getString("code");
                String description = rSet.getString("description");
                boolean isBorrowed = rSet.getBoolean("is_borrowed");

                bookList.add(new Book(id, name, code, description, isBorrowed));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public void updateBorrowStatus(int id, int borrowStatus) {
        try (Connection conn = ConnectionManager.getConnection()) {
            String sqlUpdate = "UPDATE books SET is_borrowed = ? WHERE id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sqlUpdate);
            pStmt.setInt(1, borrowStatus);
            pStmt.setInt(2, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
