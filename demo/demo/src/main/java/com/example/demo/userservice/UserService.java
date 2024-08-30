package com.example.demo.userservice;

import com.example.demo.common.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    public static void addUser(String username, String passwordHash, String email, String phoneNumber) throws SQLException {
        String sql = "INSERT INTO Users (Username, PasswordHash, Email, PhoneNumber) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, passwordHash);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNumber);
            pstmt.executeUpdate();
            System.out.println("User added successfully.");
        }
    }
}