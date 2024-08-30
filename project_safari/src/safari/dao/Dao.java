package safari.dao;

import safari.common.Common;
import safari.vo.Vo;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dao {
        Connection conn = null;
        Statement stmt = null; // create Statement 방식
        PreparedStatement pStmt = null; // Prepared Statement 방식
        ResultSet rs = null; // database 로 부터 결과를 받는 변수
        Scanner sc = new Scanner(System.in);
        // SELECT문 (조회)
        public List<Vo> usersSelect() {
            List<Vo> list = new ArrayList<>();
            try {
                conn = Common.getConnection();
                stmt = conn.createStatement();
                String sql = "SELECT * FROM users";
                rs = stmt.executeQuery(sql);

                while(rs.next()) {
                    String userID = rs.getString("UserID");
                    String userID_1 = rs.getString("userID_1");
                    String username = rs.getString("Username");
                    String email = rs.getString("Email");
                    String password = rs.getString("password");
                    int phonenumber = rs.getInt("phonenumber");
                    list.add(new Vo(userID, userID_1, username, email, password, phonenumber));
                }
                Common.close(rs);
                Common.close(stmt);
                Common.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
        public void usersInsert() {
            System.out.println("회원 정보를 입력 하세요 : ");
            System.out.print("회원아이디(4자리) ; ");
            String userID = sc.next();
            System.out.print("이름 : ");
            String username = sc.next();
            System.out.print("이메일 : ");
            String email = sc.next();
            System.out.print("전화번호 : ");
            int phonenumber = sc.nextInt();
            System.out.print("비밀번호 : ");
            String password = sc.next();
            String sql = "INSERT INTO users(userID, username, password, phonenumber) VALUES (?,?,?,?)";
            try {
                conn = Common.getConnection();
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, userID); // 첫번째는 순서의 의미
                pStmt.setString(2, username);
                pStmt.setString(3, email);
                pStmt.setString(4, password);
                pStmt.setInt(5, phonenumber);
                int rst = pStmt.executeUpdate();
                System.out.println("rst : " + rst);

            }catch (Exception e) {
                e.printStackTrace();
            }
            Common.close(pStmt);
            Common.close(conn);
            // rst는 지역변수로 받았기 때문에 안닫아도 됨
        }
        public void usersSelectPrn(List<Vo> list) {
            for (Vo e : list) {
                System.out.print(e.userID() + " ");
                System.out.print(e.username() + " ");
                System.out.print(e.email() + " ");
                System.out.print(e.password() + " ");
                System.out.print(e.phonenumber() + " ");
                System.out.println();
            }
        }
    }

