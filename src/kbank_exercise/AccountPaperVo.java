package kbank_exercise;

public class AccountPaperVo {
	String name;
	Customer customer;
	AccountVo accountvo;
	
	public AccountPaperVo() {
		this("하나");
	}
	
	public AccountPaperVo(String name) {
		this.name = name;
		welcome();
		customer = new Customer();
		accountvo = new AccountVo(customer);
	}
	
	
	public void welcome() {
		System.out.println("\n================================================");
		System.out.println("\t💰🏛" + name + " 은행 출금 용지입니다!🏛💰 ");
		System.out.println("================================================");
	}
	

	
	
	
	
	

}
