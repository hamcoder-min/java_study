package chapter21_mini_project_exercise.application;

import java.util.Scanner;

import chapter21_mini_project_exercise.service.BookMarketService;
import chapter21_mini_project_exercise.service.DefaultBookMarketService;

public class BookMarketApplication {
	public static final int MENU_GUEST_INFO = 1;
	public static final int MENU_CART_ITEM_LIST = 2;
	public static final int MENU_CART_CLEAR = 3;
	public static final int MENU_CART_ADD_ITEM = 4;
	public static final int MENU_CART_REMOVE_ITEM_COUNT = 5;
	public static final int MENU_CART_REMOVE_ITEM = 6;
	public static final int MENU_CART_BILL = 7;
	public static final int MENU_EXIT = 8;
	public Scanner scan = new Scanner(System.in);
	public BookMarketService service;
	
	
	public BookMarketApplication() {
		showMenu();
	}

	
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		System.out.println("\n********************************************************");
		System.out.println("\t\tWelcome to Shopping Mall");
		System.out.println("\t\tWelcome to Book Market!!");
		System.out.println("********************************************************");
		System.out.println("1. 고객정보 확인하기\t\t5. 장바구니의 항목 삭제하기");
		System.out.println("2. 장바구니 상품 목록 보기\t	6. 영수증 표시하기");
		System.out.println("3. 장바구니 비우기\t\t\t7. 종료");
		System.out.println("4. 장바구니에 항목 추가하기");
		System.out.println("********************************************************");
		selectMenu();
	}
	
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴 번호를 선택해주세요 : ");
		if(scan.hasNextInt()) {
			switch(scan.nextInt()) {
			case MENU_GUEST_INFO				:	service.menuGuestInfo();			break;
			case MENU_CART_ITEM_LIST			:	service.menuCartItemList();			break;
			case MENU_CART_CLEAR				:	service.menuCartClear();			break;
			case MENU_CART_ADD_ITEM				:	service.menuCartAddItem();			break;
			case MENU_CART_REMOVE_ITEM_COUNT	:	service.menuCartRemoveItemCount();	break;
			case MENU_CART_REMOVE_ITEM			:	service.menuCartRemoveItem();		break;
			case MENU_CART_BILL					:	service.menuCartBill();				break;
			case MENU_EXIT						:	service.menuExit();					break;
			default : 
				System.out.println("=> 메뉴 준비중 입니다.");
				selectMenu();
			}
		} else {
			System.out.println("🚫 올바르지 않은 형식입니다. 다시 선택해주세요.");
			scan.next();
			selectMenu();
		}
	}
	
	public static void main(String[] args) {
		BookMarketApplication bma = new BookMarketApplication();
		bma.service = new DefaultBookMarketService(bma);
		bma.service.customerInfo();
		bma.showMenu();
	}
}
