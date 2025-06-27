package chapter05;

import java.util.Scanner;

public class DrinkOrderTestVer1_Review {

	public static void main(String[] args) {
		//지역 변수 선언
		Scanner scan = new Scanner(System.in);
		int menuNo = -1;
		boolean  menuFlag = true;
		String menuName = "";
		int menuPrice = 0;
		String menuPriceOutput = "";
		boolean menuPriceFlag = true;
		int charge = 0;
		int change = 0;
		
		// step 1 : 메뉴판 출력
		System.out.println("-----------------------------------------");
		System.out.println("\t☕🍵🥤 Mega Coffee Menu");
		System.out.println("-----------------------------------------");
		System.out.println("\t1. ☕ 아메리카노 - 2,800원");
		System.out.println("\t2. 🍵 바닐라 라떼 - 3,500원");
		System.out.println("\t3. 🥤 딸기 쉐이크 - 4,000원");
		System.out.println("-----------------------------------------");
		
		// step 2 : 음료 주문 기능
		while (menuFlag) {
			System.out.print("주문할 메뉴 번호 입력 >");
			if(scan.hasNextInt()) {
				menuNo = scan.nextInt();
				menuFlag = false;
				switch(menuNo) {
				case 1 :
					menuName = "☕ 아메리카노"; menuPrice = 2800;
					break;
				case 2 : 
					menuName = "🍵 바닐라 라떼"; menuPrice = 3500;
					break;
				case 3 : 
					menuName = "🥤 딸기 쉐이크"; menuPrice = 4000;
					break;
				default : 
					System.out.println("준비중 입니다.");
					menuFlag = true;
				}// switch
				
				menuPriceOutput = String.format("%,d", new Object[] {Integer.valueOf(menuPrice)});
				
			} else {
				System.out.println("올바르지 않은 입력입니다.");
				scan.next();
				
				
			}// if ~ else
		}// while
		System.out.println("=> 주문 메뉴 : " + menuName + ", 결제 예정 금액 : " + menuPriceOutput + "원");
		
		// step 3 : 메뉴 결제 기능
			
		while(menuPriceFlag) {
			System.out.print("결제할 금액 입력 > ");
			if(scan.hasNextInt()) {
				charge += scan.nextInt();
				menuPriceFlag = false;
				System.out.println("총 입금 금액 : " + charge);
				if(menuPrice <= charge) {
					change = charge - menuPrice;
				} else {
					System.out.println("=> 금액이 부족합니다. 다시 입력해주세요.");
					menuPriceFlag = true;
				}
				
			} else {
				System.out.println("올바르지 않은 입력입니다.");
				scan.next();
			}
		}
			
		// step 4 : 주문 완료
		System.out.println("=> 결제 완료! 잔돈 : " + change + "원");
		System.out.println("[종료]");
		System.out.println("이용해주셔서 감사합니다.");
			
	}// main

}

