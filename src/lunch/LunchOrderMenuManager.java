package lunch;

public class LunchOrderMenuManager {
	// Field
	LunchOrderSystemOOP system;
	
	// Constructor
	public LunchOrderMenuManager() {}
	public LunchOrderMenuManager(LunchOrderSystemOOP system) {
		this.system = system;
	}
		
	// Method
	
	/*
	 * 런치메뉴 생성
	 */
	public void createLunchMenu() {
		LunchMenu menu = null;
		for(int i = 0; i < system.lunchMenuNames.length; i++) {
			menu = new LunchMenu();
			menu.no = i+1;
			menu.name = system.lunchMenuNames[i];
			menu.price = system.lunchMenuPrice[i];
			
			system.lunchMenuList[i] = menu;
		}
	}
	
	/*
	 * 런치메뉴 출력
	 */
	public void showLunchMenu() {
		System.out.println("\n********************************************");
		for(LunchMenu menu : system.lunchMenuList) {
			System.out.print(menu.no + ". ");
			System.out.print(menu.name + "\t");
			System.out.print(menu.price + "\n");
		}
		System.out.println("********************************************");
		selectLunchMenu();
	}
	
	/*
	 * 런치메뉴 선택
	 */
	public void selectLunchMenu() {
		System.out.print("주문메뉴 선택(숫자) > ");
		
		if(system.scan.hasNextInt()) {
			lunchMenuCheck(system.scan.nextInt());
		} else {
			System.out.println("<<입력된 값이 바르지 않습니다. 다시 입력해 주세요!>>");
			system.scan.next();
			selectLunchMenu();
		}
	}
	
	
	
	/*
	 * 메인메뉴 출력
	 */
	public void showMainMenu() {
		System.out.println("\n************************************************");
		System.out.println("\t Welcome to [" + system.title + "] Food Mart!!!");
		System.out.println("************************************************");
		System.out.println(" \t\t1. 음식 주문");
		System.out.println(" \t\t2. 주문 내역");
		System.out.println(" \t\t3. 음식 결제");
		System.out.println(" \t\t4. 결제 내역");
		System.out.println(" \t\t9. 프로그램 종료");
		System.out.println("************************************************");
		System.out.println("********** Food Mart에 오신것을 환영합니다 **********");
		
		//createLunchMenu();
		selectMainMenu();
		
		
	}// showMainMenu method
	
	/*
	 * 메인메뉴 선택
	 */
	public void selectMainMenu() {
		System.out.print("메인메뉴 선택(숫자) > ");
		
		if(system.scan.hasNextInt()) {
			mainMenuCheck(system.scan.nextInt());
		} else {
			System.out.println("<<입력된 값이 바르지 않습니다. 다시 입력해 주세요!>>");
			system.scan.next();
			selectMainMenu();
		}
	}
	
	/*
	 * 메인메뉴 체크
	 */
	public void mainMenuCheck(int mainMenu) {
		switch(mainMenu) {
		case 1 : showLunchMenu();	break;
		case 2 : system.orderList();		break;
		case 3 : system.payment();			break;
		case 4 : system.paymentList();		break;
		case 9 :
			System.out.println("=> 음식 주문 시스템을 종료합니다!");
			System.exit(0);
			break;
		default : 
			System.out.println("=> 메뉴 준비중!");
			showMainMenu();
		}
	}
	/*
	 * 런치메뉴 체크
	 */
	public void lunchMenuCheck(int lunchMenu) {
		//lunchMenu : 1~4 값 => 주문가능, 다른 번호 => 메뉴 준비중. 다시 입력
		if(1 <= lunchMenu && lunchMenu <= 4) {
			// 주문 진행 
			system.order(lunchMenu);
		} else {
			System.out.println("메뉴 준비중입니다!");
			showLunchMenu();
		}
	}
	
	
}// class
