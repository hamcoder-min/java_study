package chapter05;

/*
 * 중첩 if
 */

import java.util.Scanner;

public class IfOverlabTest2 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean math_pass = false, eng_pass = false;
		
		
		System.out.print("수학점수 > ");
		math_pass = (scan.nextInt() >= 60) ? true : false;
		System.out.print("영어점수 > ");
		eng_pass = (scan.nextInt() >= 60) ? true : false;
		
		// 1. 중첩 if
		// {}(블록)을 생략한 모습 --> 오류가 날 수 있음 아래 구문이 오류가 나서 "불합격"이 출력되지 않음!(에러로는 안뜸)
		
		if (math_pass) if (eng_pass) System.out.println("합격"); 
		else System.out.println("불합격");
		
		
		
		// 2. 논리연산자 &&를 이용하여 if ~ else
		// {}(블록)을 생략한 모습 --> 오류가 날 수 있음
		
		if((math_pass) && (eng_pass)) System.out.println("합격");
		 else System.out.println("불합격");
		
	}
	

}
