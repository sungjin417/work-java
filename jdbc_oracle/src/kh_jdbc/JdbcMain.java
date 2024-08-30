package kh_jdbc;

import kh_jdbc.dao.EmpDao;
import kh_jdbc.vo.EmpVo;
import java.util.List;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpDao dao = new EmpDao();
        

        while(true) {
            System.out.println("=================================");
            System.out.print("메뉴 선택 : [1]SELECT [2]INSERT [3]UPDATE [4]DELETE [5]QUIT : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                    List<EmpVo> list = dao.empSelect();
                    dao.empSelectPrn(list);
                    break;
                case 2:
                    dao.empInsert();
                    break;
                default:
                    System.out.println("메뉴를 잘 못 선택 했습니다.");

            }
        }
    }
}
