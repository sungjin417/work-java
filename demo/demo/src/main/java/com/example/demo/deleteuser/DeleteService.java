package com.example.demo.deleteuser;

import com.example.demo.common.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteService {

    public static void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM Users WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) {
                System.out.println("User deleted successfully.");
            }
        }
    }
}