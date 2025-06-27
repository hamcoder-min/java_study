package chapter05;

import java.util.Scanner;

/*
 * <<추가 사항>>
 * 1. 예외사항 처리 : 메뉴 선택, 결제금액 입력 시 정수형 타입이 아닌 경우 메세지 출력 후 재입력을 유도함
 * 2. 입력값이 정확할 때까지 재입력을 유도함 --> flag 변수를 이용하여 반복
 * 3. 결제 금액이 부족한 경우 재입력을 통해 금액을 누적으로 계산하여 저장 후 결제
 */

public class LunchOrderTestVer2 {

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
		int menuNo = -1;
		String menuName = "";
		int menuPrice = 0;
		int charge = 0;
		int change = 0;
		boolean menuFlag = true;
		boolean paymentFlag = true;
		
		// 1. 메뉴 주문
		while (menuFlag) {
			System.out.print("메뉴 선택(숫자로) > ");
			if(scan.hasNextInt()) {
				menuNo = scan.nextInt();
				
				switch(menuNo) {
				case 1 :
					menuName = "햄버거(🍔)"; menuPrice = 100;
					break;
				case 2 :
					menuName = "피자(🍕)"; menuPrice = 200;
					break;
				case 3 : 
					menuName = "라멘(🍜)"; menuPrice = 300;
					break;
				case 4 : 
					menuName = "샐러드(🥗)"; menuPrice = 400;
					break;
				case 9 : 
					System.out.println("-- 프로그램을 종료합니다 --");
					System.exit(0);
					break;
				default : 
					System.out.println("메뉴가 준비중입니다.");
				}//switch
				
				menuFlag = false;
				
			} else {
				System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요.");
				scan.next();
			}// if
			
		}// while - menuNo
			
			
			/*
			if(menuNo == 1) {
				System.out.println("햄버거(🍔)");
			} else if (menuNo == 2) {
				System.out.println("피자(🍕)");
			} else if (menuNo == 3) {
				System.out.println("라멘(🍜)");
			} else if (menuNo == 4) {
				System.out.println("샐러드(🥗)");
			} else if (menuNo == 9) {
				System.out.println("-- 프로그램을 종료합니다 --");
				System.exit(0);
			} else {
				System.out.println("메뉴가 준비중입니다.");
			}
			*/
			
		
			System.out.println("주문하신 메뉴는 " + menuName + ", 가격은 " + menuPrice + "원 입니다.");
		
		// 2. 주문 메뉴 결제
			
			while (paymentFlag) {
				System.out.print("결제할 요금 입력(숫자로) > ");
				if(scan.hasNextInt()) {
					charge += scan.nextInt();
					System.out.println("총 입력 금액 : " + charge);
					
					
					if (charge >= menuPrice) {
						change = charge - menuPrice;
						
						paymentFlag = false;
						
					} else {
						System.out.println("요금이 부족합니다. 다시 입력해주세요");
					}
					
					
					
				} else {
					System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요.");
					scan.next();
				
				
				}//if
			}// while - payment
					
			
		
		// 3. 주문 내역 출력 : 주문한 메뉴는 (햄버거), 결제금액(), 잔돈() 입니다.
		
		System.out.println("주문한 메뉴는 " + menuName + ", 결제금액(" + menuPrice + "), 잔돈(" + change + ") 입니다.");
	}

}
