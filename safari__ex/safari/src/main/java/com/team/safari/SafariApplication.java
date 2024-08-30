package com.team.safari;

import com.team.safari.Common.Common;
import com.team.safari.Vo.UserVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class SafariApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafariApplication.class, args);
        Scanner scanner = new Scanner(System.in);

        System.out.println("회원 정보 입력");
        System.out.print("아이디를 입력하세요: ");
        String userId = scanner.nextLine();

        System.out.print("패스워드를 입력하세요: ");
        String password = scanner.nextLine();

        System.out.print("이름을 입력하세요: ");
        String userName = scanner.nextLine();

        System.out.print("이메일을 입력하세요: ");
        String email = scanner.nextLine();

        System.out.print("전화번호를 입력하세요: ");
        String phone = scanner.nextLine();

        // User 객체 생성 및 정보 설정
        UserVO userVO = new UserVO(userId, password, userName, email, phone);

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 데이터베이스 연결
            conn = Common.getConnection();

            // SQL 쿼리 작성
            String sql = "INSERT INTO Users (UserID, Password, UserName, Email, Phone) VALUES (?, ?, ?, ?, ?)";

            // PreparedStatement 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userVO.getUserId());
            pstmt.setString(2, userVO.getPassword());
            pstmt.setString(3, userVO.getUserName());
            pstmt.setString(4, userVO.getEmail());
            pstmt.setString(5, userVO.getPhone());

            // 쿼리 실행
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("회원 정보가 성공적으로 저장되었습니다.");
            }
        } catch (SQLException e) {
            System.out.println("회원 정보 저장 중 오류가 발생했습니다: " + e.getMessage());
        } finally {
            // 연결, 문장 닫기
            Common.close(pstmt);
            Common.close(conn);
            scanner.close();
        }
    }
}
