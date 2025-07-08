package vanding_machine_ver1;

public class RestArea {
	// Field
	String name;
	User user;
	VendingMachine machine;
	
	// Constructor
	public RestArea() {
		this("만남의 광장");
	}
	public RestArea(String name) {
		this.name = name;
		user = new User("정국");
		welcome();
		machine = new VendingMachine();
	}
	
	// Method
	public void welcome() {
		System.out.println("\n========================================================");
		System.out.println("\t" + name + " ☕🍵🥤 휴게소에 오신것을 환영합니다!");
		System.out.println("========================================================");
	}
	
}
