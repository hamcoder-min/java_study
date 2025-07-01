package chapter06;

import java.util.Scanner;

/*
 * 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
 * - 과목은 국어, 영어, 수학 3과목의 점수를 입력
 * - 입력받은 과목의 총점과 평균을 구함
 * - 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * - 출력을 위해서 각 배열의 주소를 통일시킨다
 * 
 * 프로그래밍 방식 : 구조적(Structured) 방식, 객체지향적(Object Oriented) 방식
 */

public class ScoreTestVer2 {

	public static void main(String[] args) {
		System.out.println("----------------------------------------------");
		System.out.println("\t더조은 고등학교 성적관리 프로그램");
		System.out.println("----------------------------------------------");
		
		// step 1 : 배열, 변수 선언
		
		Scanner scan = new Scanner(System.in);
		System.out.print("크기 입력 > ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[] korList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
		
		// step 2 : 데이터 입력 - 실행시 외부에서 입력
		for (int i = 0; i < nameList.length; i++) {
			System.out.print("학생명 > ");
			nameList[i] = scan.next();
			
			System.out.print("국어점수 > ");
			korList[i] = scan.nextInt();
			
			System.out.print("영어점수 > ");
			engList[i] = scan.nextInt();
			
			System.out.print("수학점수 > ");
			mathList[i] = scan.nextInt();
			
			totList[i] = korList[i] + engList[i] + mathList[i]; // 총점
			avgList[i] = totList[i] / 3; 						// 평균
			
			
			System.out.print("계속 입력 하시겠습니까(계속 : 아무키나 누르세요, 종료 : n)? > ");
			if(scan.next().equals("n")) {
				// 종료
				i = nameList.length; // break; -> 둘 중 하나 진행
				
			}	
		}
		
		// step 3 : 데이터 출력
		System.out.println("\n----------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------");
		
		for (int i = 0; i < nameList.length; i++) {
			// 이름이 null이 아닌 경우에만 출력
			
			if(nameList[i] != null) {
			System.out.print(nameList[i] + "\t");
			System.out.print(korList[i] + "\t");
			System.out.print(engList[i] + "\t");
			System.out.print(mathList[i] + "\t");
			System.out.print(totList[i] + "\t");
			System.out.print(avgList[i] + "\n");
			
			}
			
		}
		System.out.println("----------------------------------------------");
		
		
		boolean searchFlag = true;
		while(searchFlag) {
			// step 4 : 데이터 조회
			// 조회할 학생명 입력
				System.out.print("학생명 검색 > ");
			String searchName = scan.next();
			
			// nameList에서 입력한 학생명을 검색 --> 학생의 nameList 주소를 변수에 저장한다. (변수는 for블럭 밖에 생성해야함)
			int searchIdx = -1;
			int count = 0;
			for(String name : nameList) {
				if (name != null) {
					if(name.equals(searchName)) searchIdx = count;
					count++;
				}
			}
			System.out.println("검색결과 주소 : " + searchIdx);
			
			// step 5 : 데이터 조회 결과 출력
			
			System.out.println("\n----------------------------------------------");
			System.out.println("\t\t검색 결과");
			System.out.println("----------------------------------------------");
			System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
			System.out.println("----------------------------------------------");
			
			
			System.out.print(nameList[searchIdx] + "\t");
			System.out.print(korList[searchIdx] + "\t");
			System.out.print(engList[searchIdx] + "\t");
			System.out.print(mathList[searchIdx] + "\t");
			System.out.print(totList[searchIdx] + "\t");
			System.out.print(avgList[searchIdx] + "\n");
			
			System.out.println("----------------------------------------------");
			
			
			System.out.print("계속 검색 하시겠습니까(계속 : 아무키나 누르세요, 종료 : n)? > ");
			if(scan.next().equals("n")) {
				// 종료
				searchFlag = false; // break; -> 둘 중 하나 진행
			}
			
		}// while - searchFlag : step 4, step 5 반복
		
		System.out.println("-- 프로그램 종료 --");
		System.exit(0);
		
	}// main

}// class
