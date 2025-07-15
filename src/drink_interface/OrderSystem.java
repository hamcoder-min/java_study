package drink_interface;

import java.util.Scanner;

//import commons.Menu;

public class OrderSystem {
	// Field
	String title;
	Scanner scan = new Scanner(System.in);
	String[] names = { "☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크" };
	int[] price = { 2800, 3500, 4000 };
	Menu[] menuList = new MenuItem[names.length];
	Order order;
	Payment payment;
	
	// Constructor
	public OrderSystem() {
		this("Mega");
	}
	
	public OrderSystem(String title) {
		this.title = title;
		init();
	}
	
	// Method
	public void init() {
		payment = new Payment();
		createMenuList();
		showMenu();
		selectMenu();
	}
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴 선택(숫자) > ");
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			if(1<= menu && menu <= 3) {
				placeOrder(menu);	// 주문 진행
			} else {
				System.out.println("=> 메뉴 준비중 입니다.");
			}
		} else {
			System.out.println("=> 올바르지 않은 입력값 입니다. 다시 선택해주세요!");
			scan.next();
			selectMenu();
		}
	}
	
	/*
	 * 주문
	 */
	public void placeOrder(int menu) {
		//번호에 맞는 메뉴를 메뉴리스트에서 검색한다. 검색한 메뉴를 Order 생성자에 매개변수로 입력한다.
		order = new Order(searchMenu(menu));
		if(order.orderMenu != null) order.getInfo();
		System.out.println("=> 주문완료!!");
		
		processPayment();
	}
	
	/*
	 * 결제
	 */
	public void processPayment() {
		
		System.out.print("결제 금액(숫자) > ");
		if(scan.hasNextInt()) {
			payment.setAmount(scan.nextInt());
			System.out.println("=> 총 입금 금액 : " + payment.getAmount());
			if (payment.getPayment(order.orderMenu.getPrice())) {
				//결제완료
				System.out.println("=> 결제 완료!! 잔돈 : " + payment.getChange());
				showMenu();
				selectMenu();
			} else {
				//결제 금액 부족
				System.out.println("=> 결제 실패, 결제 금액 부족, 다시 입력!!");
				processPayment();
			}
			
		} else {
			System.out.println("=> 올바르지 않은 입력값 입니다. 다시 입력해주세요!");
			scan.next();
			processPayment();
		}
	}//processPayment
	
	
	
	
	public Menu searchMenu(int menuNo) {
		Menu menu = null;
		
		for(Menu m : menuList) {	// menuList[0] --> m --> Menu(아메리카노);
			if(m.getNo() == menuNo) {
				menu = m;
				break;
			}
		}
		
		return menu;
	}
	
	public void showMenu() {
			System.out.println("\n=========================================");
			System.out.println("\t☕🍵🥤 " + title +  " Coffee Menu");
			System.out.println("=========================================");
			for(Menu menu : menuList) {
				System.out.print(menu.getNo() + "\t");
				System.out.print(menu.getName() + "\t");
				System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
			}
			System.out.println("=========================================");
			
		/* 일반 for문을 이용하여 메뉴리스트 출력
		for(int i=0; i<menuList.length; i++) {
			Menu menu = menuList[i];
			System.out.print(menu.no + "\t");
			System.out.print(menu.name + "\t");
			System.out.print(menu.price + "\n");
		}
		*/
	}
	
	public void createMenuList() {
		for(int i = 0; i<names.length; i++) {
			Menu menu = new MenuItem((i+1), names[i], price[i]);
			menuList[i] = menu;
		}
	}
}//class
