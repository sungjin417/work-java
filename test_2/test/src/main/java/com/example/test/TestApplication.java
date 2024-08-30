package com.example.test;

import com.example.test.dao.UserDAOImpl;
import com.example.test.vo.UserVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		Scanner sc = new Scanner(System.in);
		UserDAOImpl dao = new UserDAOImpl();

		while(true) {
			System.out.println("=================================");
			System.out.print("메뉴 선택 : [1]SELECT [2]INSERT [3]UPDATE [4]DELETE [5]QUIT : ");
			int sel = sc.nextInt();
			switch(sel) {
				case 1:
					List<UserVO> list = dao.userSelect();
					dao.userSelectPrn(list);
					break;

				default:
					System.out.println("메뉴를 잘 못 선택 했습니다.");

			}
		}

	}
}
