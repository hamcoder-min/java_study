package chapter06;

public class ArrayTest03 {

	public static void main(String[] args) {
		// 배열 객체 선언 - 1에서 5까지의 데이터를 저장 후 순서대로 출력
		int[] numbers = new int[100]; // 배열의 전체 크기 : 변수명.length
		
		// 데이터 저장
		for (int i=0; i<numbers.length; i++) {
			numbers[i] = i + 1;		//numbers[0] = 1; ...
		}

		// 데이터 출력
		for(int i = 0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		
		
	}

}
