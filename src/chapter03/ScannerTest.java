package chapter03;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 > ");
		String name = scan.next();
		
		System.out.print("나이 > ");
		int age = scan.nextInt();
		
		System.out.print("과목 > ");
		String subject = scan.next(); 
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("과목 : " + subject);

	}

}
