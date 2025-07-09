package vending_machine_ver2;

import java.util.Scanner;

public class User {
	// 이름, 입력을 위한 스캐너 객체
	String name;
	Scanner scan;
	
	public User() {
		scan = new Scanner(System.in);
	}
	
	//getter 메소드 생성
	public String getName() { return name; }
	public Scanner getScan() { return scan; }
	
	
	public int insertCoin() {
		int resultCoin = 0;
		System.out.print("[" + name + "] 동전입력 > ");
		if(scan.hasNextInt()) {
			int coin = scan.nextInt();
			resultCoin = coin;
		} else {
			System.out.println("=> 올바르지 않은 값입니다. 다시 입력해주세요!");
			scan.next();
			insertCoin();
		}
		return resultCoin;
	}
	
	public int selectMenu() {
		int menu = 0;
		System.out.print("[" + name + "] 메뉴선택 > ");
		if(scan.hasNextInt()) {
			menu = scan.nextInt();
		} else {
			System.out.println("=> 올바르지 않은 값입니다. 다시 입력해주세요!");
			scan.next();
			insertCoin();
		}
		return menu;
	}
}
