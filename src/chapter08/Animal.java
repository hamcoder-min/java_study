package chapter08;

public class Animal extends Client {
	Person owner;
	String name;
	int age;
	
	public Animal() {
		this("예삐", 3, null);
	}
	public Animal(String name, int age, Person owner) {
		this.name = name;
		this.age = age;
		this.owner = owner;
	}
	
	public void sound() {
		System.out.println(name + " 짖는다");
	}
	
	@Override
	public void register() {
		System.out.println(owner.name + "고객이 접수를 한다.");
	}
	
	@Override
	public void payment() {}
	
	@Override
	//고객 정보 출력시 owner 정보 포함!!
	public void printInfo() {	//부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(overriding)
		System.out.print("고객(Animal)정보 --> ");
		System.out.print(name + ",");
		System.out.print(age + ",");
		System.out.print(owner.name + ",");
		System.out.print(owner.age + "\n");
	}
}
