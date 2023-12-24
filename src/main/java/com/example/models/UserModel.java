package com.example.models;

import java.sql.*;
import java.util.Optional;

import com.example.utils.ConnectionManager;

public class UserModel {
    public Optional<String> loginUser(String username, String password)  {
        try (Connection conn = ConnectionManager.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, username);
            pStmt.setString(2, password);

            ResultSet rSet = pStmt.executeQuery();

            System.out.println("the result set is:" + rSet.toString());

            if (rSet.next()) {
                return Optional.of(rSet.getString("id"));
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    public boolean registerUser(String sid, String fullName, String email, String username, String password) {
        try (Connection conn = ConnectionManager.getConnection()) {
            String sql = "INSERT INTO users(full_name, email, username, password, sid) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, fullName);
            pStmt.setString(2, email);
            pStmt.setString(3, username);
            pStmt.setString(4, password);
            pStmt.setString(5, sid);
            pStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePassword(String NIM, String newPassword, String username) {
        try (Connection conn = ConnectionManager.getConnection()) {
            String sql = "UPDATE users SET password = ? WHERE sid = ? AND username = ?"; 
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, newPassword);
            pStmt.setString(2, NIM);
            pStmt.setString(3, username);
            int totalRowUpdated = pStmt.executeUpdate();
            return totalRowUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
