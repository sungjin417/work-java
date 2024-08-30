package com.example.demo.queryservice;

import com.example.demo.common.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryService {

    public static void getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM Users WHERE Username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("UserID: " + rs.getInt("UserID"));
                System.out.println("Username: " + rs.getString("Username"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("PhoneNumber: " + rs.getString("PhoneNumber"));
                // 여기서 나머지 필드 정보를 출력할 수 있습니다.
            }
        }
    }
}