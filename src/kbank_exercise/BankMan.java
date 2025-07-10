package kbank_exercise;

public class BankMan {
	Customer customer;
	AccountVo accountvo;
	AccountPaperVo accountpapervo;
	
	
	
	public void check() {
		System.out.println("출금하실 금액이 어떻게 되십니까?");
		customer.rewrite();
	}
	
	public void checkAccoutPaperVo() {
		System.out.println("네, 비밀번호 입력 부탁드립니다.");
	}
	
}

