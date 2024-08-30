package com.example.test.dao;

import com.example.test.common.Common;
import com.example.test.vo.UserVO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAOImpl implements UserDAO {
    private String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    private String dbUser = "test_user1";
    private String dbPassword = "1234";

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<UserVO> userSelect() {
        List<UserVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM users";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int UserID = rs.getInt("USERID");
                String Username = rs.getString("USERNAME");
                String Password = rs.getString("PASSWORD");
                String Email = rs.getString("EMAIL");
                String PhoneNumber = rs.getString("PHONENUMBER");

                list.add(new UserVO(UserID, Username, Password, Email, PhoneNumber));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertUser(UserVO user) throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
                 PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Users (UserID, Username, Password, Email, PhoneNumber) VALUES (?, ?, ?, ?, ?)")) {

                pstmt.setInt(1, user.getUserid());
                pstmt.setString(2, user.getUsername());
                pstmt.setString(3, user.getPassword()); // 비밀번호 해싱 필요
                pstmt.setString(4, user.getEmail());
                pstmt.setString(5, user.getPhone());

                pstmt.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("드라이버 로드 실패", e);
        }
    }
    public void userSelectPrn(List<UserVO> list) {
        for (UserVO e : list) {
            System.out.print(e.getUserid() + " ");
            System.out.print(e.getUsername() + " ");
            System.out.print(e.getPassword() + " ");
            System.out.print(e.getEmail() + " ");
            System.out.print(e.getPhone() + " ");
            System.out.println();
        }
    }
}
