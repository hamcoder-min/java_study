package kbank_exercise;

import java.util.Scanner;

public class Customer {
	Scanner scan = new Scanner(System.in);
	String name = "홍길동";
	String accountNum = "123-45-67890-12";
	int amount = 5000000;
	int withdraw = 1000000;
	private int password;
	AccountPaperVo accountpapervo;
	BankMan bankman;
	
	
	

	public Customer() {
		customerInfo();
	}
	
	public void customerInfo() {
			System.out.println("성함 : " + name);
			System.out.println("계좌번호 : " + accountNum);
			System.out.println("출금 가능 금액 : " + amount);
			System.out.println("출금 예정 금액 : ");
			System.out.println("출금 후 잔액 : " + (amount - withdraw));
			bankman.check();
		}
	
	public void rewrite() {
		System.out.println("100만원 인출 부탁드립니다");
		bankman.checkAccoutPaperVo();
	}
	
	
}
