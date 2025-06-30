package chapter06;

public class ArrayTest02 {

	public static void main(String[] args) {
		// names 문자열 변수 선언 및 생성
		String[] names;
		String names2[];
		
		names = new String [3];
		names2 = new String[5];
		names[0] = "홍길동";
		
		int[] scores = new int [10];
		int scores2[] = new int[3];
		int scores3[] = { 10, 20, 30 };
		String[] names3 = { "홍길동", "홍길순" };
		
		
		scores[0] = 100;
		scores[1] = 200;
		scores[2] = 300;
		
		// names 2번째 공간에 "이순신" 저장
		names[1] = "이순신";
		
		System.out.println(names);
		System.out.println(names2);
		System.out.println(names3[0]);
		System.out.println(scores[0]);
		System.out.println(scores2[0]);
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(scores3[2]);
	}

}
