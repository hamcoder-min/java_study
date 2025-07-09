package vending_machine_ver1;

public class RestArea {
	// Field
	String name;
	User user;
	VendingMachine machine;
	
	// Constructor
	public RestArea() {
		this("만남의 광장");
	}// 기본생성자
	
	public RestArea(String name) {
		this.name = name; 	// <--- 객체 생성할때 받은 파라미터의 값을 확장 
							//(이 한 줄이 없으면 name은 이 생성자 안에서만 사용 가능한데 이 작업을 통해서 
							//여기서 선언한 name을 전역변수에 넣어서 전체에서 사용 가능하게 함)
		user = new User("정국");
		welcome();
		machine = new VendingMachine(user);
	}// overloading한 생성자
	
	// Method
	public void welcome() {
		System.out.println("\n================================================");
		System.out.println("\t" + name + " ☕🍵🥤 휴게소에 오신것을 환영합니다!");
		System.out.println("================================================");
	}
	
}
