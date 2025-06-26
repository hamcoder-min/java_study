package chapter04;

/*
 * 증감 연산자 : ++, --
 */

public class OpIncrementTest {

	public static void main(String[] args) {
		int number = 10;
		
		System.out.println(++number);	// 계산 먼저 하고 변수값을 콘솔에 출력 -->11
		System.out.println(number++);	// 콘솔에 먼저 출력하고 변수값을 메모리에서 계산 --> 11
		System.out.println(number);		// 위에서 진행된 메모리에 있는 계산값을 출력 --> 12
		
		System.out.println(--number);	// 11
		System.out.println(number--);	// 11
		System.out.println(number);		// 10

	}

}
