package chapter21_mini_project.application;

import java.util.Scanner;

import chapter21_mini_project.service.BookMarketServiceImpl;

public class BookMarketSystem {
	public static final int MEMBER_INFO = 1;
	public static final int CART_LIST = 2;
	public static final int CART_CLEAR = 3;
	public static final int CART_ADD = 4;
	public static final int CART_DELETE_ITEM = 5;
	public static final int PRINT_BILL = 6;
	public static final int EXIT = 7;
	
	public Scanner scan;
	BookMarketServiceImpl service;
	
	public BookMarketSystem() {
		scan = new Scanner(System.in);
		service = new BookMarketServiceImpl(this);
		createMember();
		showMenu();
	}
	
	public void createMember() {
		System.out.println("회원 등록을 진행해 주세요~!");
		service.menuMemberAdd();
	}
	
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
	
	public void selectMenu() {
		System.out.print("메뉴(숫자) > ");
		if(scan.hasNextInt()) {
			switch(scan.nextInt()) {
			case MEMBER_INFO : 		service.menuMemberInfo();		break;
			case CART_LIST : 		service.menuCartList();			break;
			case CART_CLEAR : 		service.menuCartClear();		break;
			case CART_ADD : 		service.menuCartAddItem();		break;
			case CART_DELETE_ITEM : service.menuCartRemoveItem();	break;
			case PRINT_BILL : 		service.menuCartBill();			break;
			case EXIT : 			service.exit();					break;
			default : 
				System.out.println("메뉴 준비중입니다.");
				selectMenu();
			}
			
		} else {
			System.out.println("잘못된 입력값입니다.");
			scan.next();
		}
	}
	
	public static void main(String[] args) {
		new BookMarketSystem();
	}
}
