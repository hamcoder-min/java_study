package chapter12;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		String num = String.valueOf(123);
		name2 = "welcometoJava!!";
		
		String phone = "010-1234-5678";
		String subject = "java,css,html,mysql";
		String[] phones = phone.split("-");
		String[] subjects = subject.split(",");
		
		String jphone = String.join(",", phones);
		
		System.out.println(subject.contains("html"));
		System.out.println(jphone);	//010,1234,5678
		System.out.println(subjects[0]);	//java
		System.out.println(phones[0]);	//010
		System.out.println(name2.substring(7, 10));
		System.out.println(name2.substring(7));
		System.out.println(name2.length());
		System.out.println(name2.toUpperCase());
		System.out.println(name2.toLowerCase());
		System.out.println(num + 10);
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		
		if(name1 == name2) System.out.println("동일");
		else System.out.println("다름");
		
		if(name1.equals(name2)) System.out.println("동일");
		else System.out.println("다름");
	}

}
