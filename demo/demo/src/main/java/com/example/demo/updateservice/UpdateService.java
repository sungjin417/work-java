package com.example.demo.updateservice;

import com.example.demo.common.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateService {

    public static void updateUserEmail(int userId, String newEmail) throws SQLException {
        String sql = "UPDATE Users SET Email = ? WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, userId);
            int updated = pstmt.executeUpdate();
            if (updated > 0) {
                System.out.println("User email updated successfully.");
            }
        }
    }
}