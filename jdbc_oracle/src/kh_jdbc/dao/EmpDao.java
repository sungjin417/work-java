package kh_jdbc.dao;

import kh_jdbc.common.Common;
import kh_jdbc.vo.EmpVo;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpDao {
    Connection conn = null;
    Statement stmt = null; // create Statement 방식
    PreparedStatement pStmt = null; // Prepared Statement 방식
    ResultSet rs = null; // database 로 부터 결과를 받는 변수
    Scanner sc = new Scanner(System.in);
    // SELECT문 (조회)
    public List<EmpVo> empSelect() {
        List<EmpVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM EMP";
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int empNo = rs.getInt("EMPNO");
                String name = rs.getString("ENAME");
                String job = rs.getString("JOB");
                int mgr = rs.getInt("MGR");
                Date date = rs.getDate("HIREDATE");
                BigDecimal sal = rs.getBigDecimal("SAL");
                BigDecimal comm = rs.getBigDecimal("COMM");
                int deptNo = rs.getInt("DEPTNO");
                list.add(new EmpVo(empNo, name, job, mgr, date, sal, comm, deptNo));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void empInsert() {
        System.out.println("사원 정보를 입력 하세요 : ");
        System.out.print("사원번호(4자리) ; ");
        int no = sc.nextInt();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("직책 : ");
        String job = sc.next();
        System.out.print("상관 사원 번호 : ");
        int mgr = sc.nextInt();
        System.out.print("입사일 : ");
        String date = sc.next();
        System.out.print("급여 : " );
        BigDecimal sal = sc.nextBigDecimal();
        System.out.print("성과급 : " );
        BigDecimal comm = sc.nextBigDecimal();
        System.out.print("부서번호 : ");
        int dept = sc.nextInt();
        String sql = "INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, no); // 첫번째는 순서의 의미
            pStmt.setString(2, name);
            pStmt.setString(3, job);
            pStmt.setInt(4, mgr);
            pStmt.setString(5, date);
            pStmt.setBigDecimal(6, sal);
            pStmt.setBigDecimal(7, comm);
            pStmt.setInt(8, dept);
            int rst = pStmt.executeUpdate();
            System.out.println("rst : " + rst);

        }catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
        // rst는 지역변수로 받았기 때문에 안닫아도 됨
    }
    public void empSelectPrn(List<EmpVo> list) {
        for (EmpVo e : list) {
            System.out.print(e.getEmpNo() + " ");
            System.out.print(e.getName() + " ");
            System.out.print(e.getJob() + " ");
            System.out.print(e.getMgr() + " ");
            System.out.print(e.getDate() + " ");
            System.out.print(e.getSal() + " ");
            System.out.print(e.getComm() + " ");
            System.out.print(e.getDeptNo() + " ");
            System.out.println();
        }
    }
}
