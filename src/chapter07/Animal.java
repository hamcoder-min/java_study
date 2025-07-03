package chapter07;

public class Animal {
	// Field : 전역변수
	String name;
	int age;
	
	// Constructor
	public Animal() { // 기본 생성자 (클래스의 이름과 동일하고 ()안에 아무것도 없는 아이)
		// 생성자 호출시 실행되는 내용 => new Animal(); 코드 실행시 실행됨!!!
		
		System.out.println("객체를 생성한다.");
	}
	
	// Method
	public void/*[반환타입=리턴타입]*/ sleep() {
		System.out.println(name + "가 잠을 잔다.");
	}

}
