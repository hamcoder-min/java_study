package chapter07;

import java.util.Scanner;

public class DrinkOrderSystemOOP {
	//Field
	Scanner scan = new Scanner(System.in);
	String[] drinkMenuNames = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
	int[] drinkMenuPrice = {2800, 3500, 4000};
	DrinkMenu[] drinkMenuList = new DrinkMenu[3];
	DrinkOrderItem[] orderItemList = new DrinkOrderItem[3];
	DrinkPaymentItem paymentItem;
	int orderCount = 0;
	int amount = 0;
	int change = 0;
	
	//Constructor
	//Method
	/*
	 * 음료메뉴 생성
	 */
	public void createDrinkMenu() {
		DrinkMenu menu = null;
		for(int i = 0; i<drinkMenuNames.length; i++) {
			menu = new DrinkMenu();
			menu.no = i+1;
			menu.name = drinkMenuNames[i];
			menu.price = drinkMenuPrice[i];
			
			drinkMenuList[i] = menu;
		}
	}
	
	/*
	 * 음료메뉴 출력
	 */
	public void showDrinkMenu() {
		System.out.println("-----------------------------------------");
		for(DrinkMenu menu : drinkMenuList) {
			System.out.println(menu.no + ". ");
			System.out.println(menu.name + "\t");
			System.out.println(menu.price + "\n");
		}
		System.out.println("-----------------------------------------");
		
	}
	
	/*
	 * 음료메뉴 선택
	 */
	public void selectDrinkMenu() {
		System.out.print("주문할 메뉴 번호 입력> ");
		
		for(DrinkMenu menu : drinkMenuList) {
			if(scan.hasNextInt()) {
				System.out.println("주문하신 메뉴는 " + menu.name + ", 가격은 " + menu.price) ;
			} else {
				System.out.println("<<입력된 값이 바르지 않습니다. 다시 입력해주세요>>");
				scan.next();
				showDrinkMenu();
			}
		}
	}
	
	/*
	 * 음료메뉴 체크
	 */
	public void orderCheck(int drinkMenu) {
		//drinkMenu : 1~4 값 => 주문가능, 다른 번호 => 메뉴 준비중. 다시 입력
		if(1 <= drinkMenu && drinkMenu <= 3) {
			// 주문 진행 
			order(drinkMenu);
		} else {
			System.out.println("메뉴 준비중입니다!");
			selectDrinkMenu();
		}
	}
	
	/*
	 * 주문아이템의 인덱스 검색
	 */
	public int searchOrderItemIdx(int drinkMenu) {
		int idx = -1;
		for(int i = 0; i < orderCount; i++) {
			DrinkOrderItem orderItem = orderItemList[i];
			if(orderItem.no == drinkMenu) idx = i;
		}
		return idx;
	}
	
	
	/*
	 * 주문 : order()
	 */
	public void order(int drinkMenu) {
		for(DrinkMenu menu : drinkMenuList) {
			if(menu.no == drinkMenu) {
				int idx = searchOrderItemIdx(drinkMenu);
				
				if(idx == -1) {
					orderItemList[orderCount] = new DrinkOrderItem();
					
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty = 1;
					orderCount++;
				} else {
					orderItemList[idx].qty += 1;
				}
				break;
			}
		}
		System.out.println("=> 주문완료!!");
		selectDrinkMenu();
	}
	
	/*
	 * 결제 예정금액 산출
	 */
	public int totalPayment() {
		int sum = 0;
		for(DrinkOrderItem orderItem : orderItemList) {
			if(orderItem != null) {
				sum += orderItem.price * orderItem.qty;
			}
		}
		return sum;
	}
	
	/*
	 * 결제 : payment()
	 */
	public void payment() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역이 존재하지 않습니다. 음료를 주문해주세요!");
		} else {
			int total = totalPayment();
			System.out.println("");
		}
	}
	
	/*
	 * 결제내역 : paymentList()
	 */
	public void paymentList() {
		
	}
	

}//class
