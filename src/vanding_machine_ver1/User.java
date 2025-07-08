package vanding_machine_ver1;

import java.util.Scanner;

public class User {
	// Field
	String name;
	Scanner scan;
	
	// Constructor
	public User() { this("아무개"); }
	public User(String name) { 
		this.name = name; 
		scan = new Scanner(System.in);
	}
	
	// Method
	public boolean coinCheck(int coin) {
		boolean result = false;
		if(coin == 100 || coin == 500) {
			result = true;
		}
		return false;
	}
	
	public int insertCoin() {
		// 동전 체크 : 100원, 500원만 입력 가능
		int coin = scan.nextInt();
		resultCoin = coin;
//		if(coinCheck(coin)) {
//			
//		}
		
	}
	
	
	public int selectMenu() {
		int menu = 0;
		System.out.println("[" + name + "] 메뉴선택 > ");
		if(scan.hasNextInt()) {
			menu = scan.nextInt();
		} else {
			System.out.println("=> 올바르지 않은 값입니다. 다시 입력해주세요!");
			scan.next();
			insertCoin();
		}
		
		return menu;
	}
	
	selectMenu() {}
}
