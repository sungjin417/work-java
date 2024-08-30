package safari;

import safari.dao.Dao;
import safari.vo.Vo;
import java.util.List;
import java.util.Scanner;

public class SafariMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dao dao = new Dao();
        System.out.print(Vo);


        while(true) {
            System.out.println("=================================");
            System.out.print("메뉴 선택 : [1]SELECT [2]INSERT [3]UPDATE [4]DELETE [5]QUIT : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                    List<Vo> list = dao.usersSelect();
                    dao.usersSelectPrn(list);
                    break;
                case 2:
                    dao.usersInsert();
                    break;
                default:
                    System.out.println("메뉴를 잘 못 선택 했습니다.");

            }
        }
    }
}
