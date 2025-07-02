package chapter06;

import java.util.Scanner;

/*
 * 음식 주문/결제 프로그램
 * - 음식을 주문(1), 결제(2), 프로그램 종료(9)하는 메뉴로 구성된다.
 * - 프로그램 종료를 제외하고 나머지 메뉴는 반복 선택 가능하다.
 * - 메뉴 선택 시 체크하는 기능은 switch ~ case를 이용하여 구현한다.
 * 
 * <<추가 사항>>
 * 1. 예외사항 처리 : 메뉴 선택, 결제금액 입력 시 정수형 타입이 아닌 경우 메세지 출력 후 재입력을 유도함
 * 2. 입력값이 정확할 때까지 재입력을 유도함 --> flag 변수를 이용하여 반복
 * 3. 결제 금액이 부족한 경우 재입력을 통해 금액을 누적으로 계산하여 저장 후 결제
 */

public class LunchOrderTestVer3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean menuFlag = true;
		
		// 주문 음식 리스트
		String[] menuList = { "햄버거(🍔)", "피자요(🍕)", "라멘요(🍜)", "샐러드(🥗)" };
		int[] priceList = { 100, 200, 300, 400 };
		
		// 주문 리스트 선언 및 생성
		System.out.print("주문 리스트 크기 > ");
		final int MAX_SIZE = scan.nextInt();
		String[] orderMenuList = new String[MAX_SIZE];
		int[] orderPriceList = new int[MAX_SIZE];
		int count = 0;
		
		// 결제 리스트 선언 및 생성
		String[]paymentMenuList = new String[MAX_SIZE];		// 결제메뉴
		int[]totalAmountList = new int[MAX_SIZE];			// 결제금액
		int[]paidAmountList = new int[MAX_SIZE];			// 입금액
		int[]changeList = new int[MAX_SIZE];				// 잔돈
		int paymentCount = 0;
		
		while(menuFlag) {
			//메뉴판
			System.out.println("\n********************************************");
			System.out.println("\t Welcome to Food Mart!!!");
			System.out.println("********************************************");
			System.out.println(" \t\t1. 음식 주문");
			System.out.println(" \t\t2. 주문 내역");
			System.out.println(" \t\t3. 음식 결제");
			System.out.println(" \t\t4. 결제 내역");
			System.out.println(" \t\t9. 프로그램 종료");
			System.out.println("********************************************");
			System.out.println("******** Food Mart에 오신것을 환영합니다 ********");
			System.out.print("메뉴 선택 > ");
			int menu = scan.nextInt();
			
			switch (menu) {
				case 1 : // 음식 주문
					boolean orderFlag = true;
					while (orderFlag) {
						System.out.println("\n============================================");
						System.out.println(" 1. 햄버거(🍔) : 100\t 2. 피자(🍕) : 200");
						System.out.println(" 3. 라멘(🍜) : 300\t 4. 샐러드(🥗) : 400");
						System.out.println(" 9. 나가기");
						System.out.println("============================================");
						System.out.print("주문 메뉴(숫자로) > ");
						if(scan.hasNextInt()) {
							int menuNo = scan.nextInt();
							
							if(1 <= menuNo && menuNo <= 4) {
								orderMenuList[count] = menuList[menuNo-1];
								orderPriceList[count] = priceList[menuNo-1];
							} else {
								System.out.println("=> 메뉴가 준비중입니다.");
							}
							
						count++;

						System.out.println("=>" + menuList[menuNo - 1] + "주문 완료!!");
		
						//주문 갯수 체크
						if(count == MAX_SIZE) {
							System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능합니다!\n");
							orderFlag = false;
						} else {
							System.out.print("계속 주문 하시겠습니까?(계속 : 아무키나, 종료 : n) > ");
							if(scan.next().equals("n")) {
								orderFlag = false;
							} 
						}
					} else {
						System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요.");
						scan.next();
					}// if
				}// while - menuNo
				break;
			case 2 : // 음식 주문 리스트
				if(count != 0) {
					System.out.println("\n============================================");
					System.out.println("\t\t음식 주문 리스트");
					System.out.println("============================================");
					System.out.println("번호\t메뉴명\t\t가격");
					System.out.println("============================================");
					for(int i = 0; i < count; i++) {
						System.out.print((i+1) + "\t");
						System.out.print(orderMenuList[i] + "\t");
						System.out.println(orderPriceList[i] + "\t");
					}
					System.out.println("============================================\n");
				} else {
					System.out.println("주문 내역 없음!");
				}
				break;
			case 3 : // 음식 결제
				boolean paymentFlag = true;
				int charge = 0;
				int change = 0;
				int totalPayment = 0;
				for(int i=0; i<count; i++) {
					totalPayment += orderPriceList[i];
				}
				while (paymentFlag) {	// 결제요금 부족시 반복 실행
						// 결제 예정 금액 출력 : orderPriceList
					System.out.println("=> 결제 예정 금액 : " + totalPayment);
					System.out.print("결제할 요금 입력(숫자로) > ");
					
					if(scan.hasNextInt()) {
						charge += scan.nextInt();
						System.out.println("=> 총 입력 금액 : " + charge);

						if (charge >= totalPayment) {
							change = charge - totalPayment;
							
							paymentFlag = false;
							
						} else {
							System.out.println("❗요금이 부족합니다. 다시 입력해주세요❗");
						}
						
					} else {
						System.out.println("올바르지 않은 입력값입니다. 다시 입력해주세요.");
						scan.next();
					}//if
				}// while - payment
				

				paymentMenuList[paymentCount] = orderMenuList[0] + "등...";
				totalAmountList[paymentCount] = totalPayment;
				paidAmountList[paymentCount] = charge;
				changeList[paymentCount] = change;
				System.out.println("=> 결제 완료!");
				System.out.println("------------------------------------------------------------");
				System.out.println("\t주문메뉴\t\t결제금액\t\t입금금액\t\t잔돈");
				System.out.println("------------------------------------------------------------");
				System.out.print("\t" + paymentMenuList[paymentCount] + "\t");
				System.out.print(totalAmountList[paymentCount] + "\t\t");
				System.out.print(paidAmountList[paymentCount] + "\t\t");
				System.out.print(changeList[paymentCount] + "\n");
				System.out.println();
				System.out.println("------------------------------------------------------------");
				
				// orderMenuList, orderPriceList 초기화
//				for(int i = 0; i<count; i++) {
//					orderMenuList[i] = null;
//					orderPriceList[i] = 0;
//					
//				}
				orderMenuList = new String[MAX_SIZE];
				orderPriceList = new int[MAX_SIZE];
				
				count = 0;	// order count
				paymentCount++;
				
				break;
			case 4 :
				System.out.println("------------------------------------------------------------");
				System.out.println("\t\t\t결제 내역");
				System.out.println("------------------------------------------------------------");
				System.out.println("번호\t주문메뉴\t\t결제금액\t\t입금금액\t\t잔돈");
				System.out.println("------------------------------------------------------------");
				for(int i = 0; i < paymentCount; i++) {
					System.out.print((i+1));
					System.out.print("\t" + paymentMenuList[i] + "\t");
					System.out.print(totalAmountList[i] + "\t\t");
					System.out.print(paidAmountList[i] + "\t\t");
					System.out.print(changeList[i] + "\t\n");
				}
				System.out.println();
				System.out.println("------------------------------------------------------------");
				break;
			case 9 :
				System.out.println("-- 프로그램 종료 --");
				System.exit(0);
				break;
			default : 
				System.out.println("메뉴 준비중입니다!\n\n");
			}
		
		
		}// while - menuFlag

	}// main

}// class
