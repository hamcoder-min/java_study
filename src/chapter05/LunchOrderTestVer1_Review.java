package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1_Review {

	public static void main(String[] args) {
		// 메뉴판
		System.out.println("********************************************");
		System.out.println("\t Welcome to Food Mart!!!");
		System.out.println("********************************************");
		System.out.println(" 1. 햄버거(🍔) : 100\t 2. 피자(🍕) : 200");
		System.out.println(" 3. 라멘(🍜) : 300\t 4. 샐러드(🥗) : 400");
		System.out.println(" 9. 나가기");
		System.out.println("********************************************");
		System.out.println("******** Food Mart에 오신것을 환영합니다 ********");
		
		Scanner scan = new Scanner(System.in);
		String menuName = "";
		int menuNo = -1;
		int menuPrice = 0;
		int change = 0;
		int charge = 0;
		
	
		
		// 1. 메뉴 주문
		System.out.print("메뉴 선택(숫자로) > ");
		if (scan.hasNextInt()) {
			menuNo = scan.nextInt();
			
			switch (menuNo) {
			case 1 :
				menuName = "햄버거(🍔)"; menuPrice = 100;
				break;
			case 2 :
				menuName = "피자(🍕"; menuPrice = 200;
			case 3 : 
				menuName = "라멘(🍜)"; menuPrice = 300;
			case 4 : 
				menuName = "샐러드(🥗)"; menuPrice = 400;
			
			}
			
			/*if (menuNo == 1) {
				menuName = "햄버거(🍔)"; menuPrice = 100;
			} else if (menuNo == 2) {
				menuName = "피자(🍕)"; menuPrice = 200;
			} else if (menuNo ==3) {
				menuName = "라멘(🍜)"; menuPrice = 300;
			} else if (menuNo == 4) {
				menuName = "샐러드(🥗)"; menuPrice = 400;
			} else if (menuNo == 9) {
				System.out.println("--주문을 종료합니다--");
				System.exit(0);
			} else {
				System.out.println("메뉴가 준비중입니다.");
			}*/
			
		} else {
			System.out.println("올바르지 않은 입력값입니다.");
		}
		
		System.out.println("주문하신 메뉴는 " + menuName + ", 가격은 " + menuPrice + "원 입니다.");
		
		
		// 2. 주문 메뉴 결제
		System.out.print("결제할 요금 입력(숫자로) > ");
		if (scan.hasNextInt()) {
			charge = scan.nextInt();
			if (charge >= menuPrice) {
				change = charge - menuPrice;
			} else {
				System.out.println("요금이 부족합니다. 다시 입력해 주세요");
			}
		} else {
			System.out.println("올바르지 않은 입력값입니다.");
		}
		
			
		// 3. 주문 내역 출력 : 주문한 메뉴는 (햄버거), 결제금액(), 잔돈() 입니다.
		
		System.out.println("주문한 메뉴는 " + menuName + ", 결제금액(" + menuPrice + "), 잔돈(" + change + ") 입니다.");
	}

}
