package chapter07;

import java.util.Scanner;

/*
 * - 학생 3명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 */

public class ScoreMgmSystem {
	// Field
	String admin;
	Student student;
	Scanner scan = new Scanner(System.in);
	Student[] slist = new Student[3];
	
	// Constructor
	public ScoreMgmSystem() {
		
	}
	// Method
//	insert(), update(), remove(), search()
	public void insert() {
		student = new Student();
		
		for(int i = 0; i < slist.length; i++) {
		System.out.print("학생명 > ");
		student.name = scan.next();
		
		System.out.print("국어성적 > ");
		student.kor = scan.nextInt();
		
		System.out.print("영어성적 > ");
		student.eng = scan.nextInt();
		
		System.out.print("수학성적 > ");
		student.math = scan.nextInt();
		
		System.out.print("계속 입력 하시겠습니까? (계속 : 아무키나, 종료 : n) >");
		
		if(scan.next().equals("n")) {
			i = slist.length;
		}
		
		}
		
		System.out.println("=> 등록완료!!");
	}
	
	public void show() {
		System.out.println("***********************************************************");
		System.out.print("\t학생명\t국어\t영어\t수학\t총점\t평균\n");
		System.out.println("***********************************************************");
		System.out.print("\t" + student.name + "\t");
		System.out.print(student.kor + "\t");
		System.out.print(student.eng + "\t");
		System.out.print(student.math + "\t");
		System.out.print(student.getTot() + "\t");
		System.out.print(student.getAvg() + "\t");
		System.out.println();
		System.out.println("***********************************************************");
	}
	
	public void update() {
		System.out.println("update");
	}
	
	public void remove() {
		System.out.println("remove");
	}
	
	public void search() {
		System.out.println("search");
	}

}
