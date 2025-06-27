package chapter05;

import java.util.Scanner;

public class GugudanVer1 {

	public static void main(String[] args) {
		// 출력하는 구구단을 콘솔로 입력받아 실행
		// 구구단 2단 출력
		
		Scanner scan = new Scanner(System.in);
		int dan = 0;
		
		System.out.println("출력하실 구구단을 입력해주세요.");
		
		while (true) {
			System.out.print("몇단?(종료 : 0) > ");
			dan = scan.nextInt();
			
			if (dan != 0) {
				// dan 변수값이 0이 아닌 경우 : 구구단 출력
				System.out.println(dan + "단");
				System.out.println("****************");
				for(int i=1; i <= 9; i++) {
					System.out.println(dan + " ❌ " + i + " = " + (dan*i));
				}
			} else {
				// dan 변수값이 0인 경우 : 프로그램 종료
				System.out.println("-- 프로그램 종료 --");
				System.exit(0);
				
			}
				
		} // while 	
		
	}// main

}// class
