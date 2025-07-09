package vending_machine_ver2;

public class RestArea {
	String name;
	User user;
	VendingMachine machine;
	
	public RestArea() {
		this("더조은");
	}
	
	public RestArea(String name) {
		this.name = name;
		user = new User();
		welcome();
		System.out.print("이름을 입력해 주세요 > ");
		user.name = user.getScan().next();
		machine = new VendingMachine(user);
	}
	
	public void welcome() {
		System.out.println("\n================================================");
		System.out.println("\t" + name + " ☕🍵🥤 휴게소에 오신것을 환영합니다!");
		System.out.println("================================================");
	}
}
