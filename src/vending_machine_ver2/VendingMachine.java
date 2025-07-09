package vending_machine_ver2;

import commons.Menu;


public class VendingMachine {
	//Field
	String[] nameList = { "☕ 밀크커피", "☕ 아메리카노", "🍋 유자차아", "🥛 초코우유" };
	int [] priceList = { 300, 400, 300, 200 };
	Menu[] menuList;
	Menu[] orderMenuList;
	int orderMenuCount = 0;
	String title;
	User user;
	int totalCoin;
	Menu orderMenu;
	int change;
	
	public static final int EXIT = 9;
	
	
	//Constructor
	public VendingMachine(User user) {
		this("Mega", user);
	}
	
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	//Method
	
	//메뉴 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for (int i = 0; i < nameList.length; i++) {
			int no = i+1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}
	}
	
	//메뉴 출력
	public void showMenuList() {
		System.out.println("\n=======================================");
		System.out.println("\t☕🍵🥤 " + title +  " Coffee Machine");
		System.out.println("=======================================");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ".\t  ");
			System.out.print(menu.getName() + "\t    ");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("=======================================");
	}
	
	public void showMenuList(String msg) {
		System.out.println("\n=======================================");
		System.out.println("\t☕🍵🥤 " + title +  " Coffee Machine");
		System.out.println("=======================================");
		System.out.println("\t    " + msg);
		System.out.println("==========================================");
		for(int i = 0; i < orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			System.out.print(menu.getNo() + ".\t  ");
			System.out.print(menu.getName() + "\t    ");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("=======================================");
	}
	
	//코인 체크
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입해 주세요!");
		int coin = user.insertCoin();
		if(coin == 100 || coin == 500) {
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			if(totalCoin < 200) {
				System.out.println("=> 투입 금액이 부족합니다.");
				checkInsertCoin();
			} else {
				System.out.print("=> 메뉴선택(n), 동전 투입 계속(아무키) > ");
				if(user.scan.next().equals("n")) {
					createOrderMenuList(totalCoin);
					showMenuList("주문 가능 메뉴 리스트");
					selectMenu();
				} else checkInsertCoin();
			}
		} else {
			System.out.println("=> 동전은 100원, 500원만 사용 가능합니다. 동전이 반환됩니다.");
			checkInsertCoin();
		}
	}
	
	public void createOrderMenuList(int totalCoin) {
		orderMenuList = new Menu[menuList.length];
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}
	}
	
	//메뉴 선택
	public void selectMenu() {
		System.out.println("=> 메뉴를 선택해 주세요.");
		System.out.println("=> 취소는 [" + VendingMachine.EXIT + "]번을 입력해 주세요.");
		int menuNo = user.selectMenu();
		if(menuNo != VendingMachine.EXIT) {
			if(menuCheck(menuNo)) {
				placeOrder(menuNo);
			} else {
				selectMenu();
			}
		} else {
			System.out.println("\n*************************************");
				System.out.println("=> 동전을 반환합니다. 프로그램을 종료합니다.");
				System.out.println("=> 반환 동전 : " + totalCoin);
		}
	}
	
	public boolean menuCheck(int menuNo) {
		boolean result = false;
		for(int i = 0; i < orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo) result = true;
		}
		return result;
	}
	
	//주문
	public void placeOrder(int menuNo) {
		for(Menu menu : orderMenuList) {
			if(menu != null) {
				if(menu.getNo() == menuNo) orderMenu = menu;
			} else break;
		}
		System.out.println("=> 주문완료!!");
		processPayment();
	}
	
	
	//결제
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			if(price <= totalCoin) {
				change = totalCoin - price;
				System.out.println("=> 결제완료!!");
				init();
			}
		}
		finalCheck();
	}
	
	public void init() {
		orderMenuList = null;
		orderMenu = null;
		orderMenuCount = 0;
		totalCoin = 0;
	}
	
	
	//파이널체크
	public void finalCheck() {
		int price = menuList[menuList.length - 1].getPrice();
		if(change >= price) {
			totalCoin = change;
			System.out.println("=> 잔돈 : " + change);
			createOrderMenuList(totalCoin);
			showMenuList("주문 가능 메뉴 리스트");
			selectMenu();
		} else {
			System.out.println("=> 결제 내역!!");
			System.out.println("=> 잔돈 : " + change);
			System.out.println("=> 이용해 주셔서 감사합니다!!");
		}
	}
	
}
