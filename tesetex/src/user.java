import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class user {
    List<user> list = new ArrayList<>();
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public static String nick;
    Scanner sc = new Scanner(System.in);

    public void SignUp() {  //회원 가입 메소드
        System.out.println("=".repeat(10) + "회원가입" + "=".repeat(10));
        System.out.print("성명 : ");
        String name = sc.next();
        System.out.print("성별 (남 / 여) : ");
        String gender = sc.next();
        System.out.print("생년월일 (YYYY/MM/DD) : ");
        String date1 = sc.next();
        System.out.print("연락처 (- 포함) : ");
        String contact = sc.next();
        System.out.print("닉네임 입력 (한글, 알파벳, 숫자 포함 10자 제한) : ");
        String nick = sc.next();
        System.out.print("ID 입력 (알파벳, 숫자 포함 10자 제한) : ");
        String id = sc.next();
        String pwd = null;
        while (true) {
            System.out.print("PASSWORD 입력 (알파벳, 숫자, 특수기호 포함 15자 제한) : ");
            pwd = sc.next();
            System.out.println(checkPassword(pwd, id));
            if (checkPassword(pwd, id) == "") {
                break;
            }
        }

        String sql = "INSERT INTO FUBAOUSER(UNAME, GENDER, BIRTH, CONTACT, NICK, ID, PASSWORD, ENTER_DATE, TOKEN) VALUES(?,?,?,?,?,?,?,SYSDATE,30)";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, gender);
            pstmt.setString(3, date1);
            pstmt.setString(4, contact);
            pstmt.setString(5, nick);
            pstmt.setString(6, id);
            pstmt.setString(7, pwd);
            int rst = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("회원가입이 완료되었습니다. 환영합니다. " + nick + "님");
        Common.close(pstmt);
        Common.close(conn);
    }
}