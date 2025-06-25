package chapter03;

import java.util.Scanner;

public class MenuTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("****************************************");
		System.out.println("\t Welcome to Shopping Mall");
		System.out.println("\t Welcome to Food Market");
		System.out.println("****************************************");
		
		System.out.print("\t 1. 상품보기");
		System.out.println("\t 2. 상품구입");
		System.out.print("\t 3. 영수증보기");
		System.out.println("\t 4. 종료");
		System.out.println("****************************************");
		
		System.out.print("메뉴를 선택해주세요(숫자) > ");
		
		int number = scan.nextInt();
		
		//선택 메뉴 체크 확인
		
		System.out.println("선택한 메뉴 : " + number);
		
		//
		
	
	}

}
