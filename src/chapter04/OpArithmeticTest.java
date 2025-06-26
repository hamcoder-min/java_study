package chapter04;

/*
 * 사칙 연산자 : +, -, *, /, % 
 */

public class OpArithmeticTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		
		System.out.println("number1 + number2 = " + (number1 + number2));
		System.out.println("number1 - number2 = " + (number1 - number2));
		System.out.println("number1 * number2 = " + (number1 * number2));
		System.out.println("number1 / number2 = " + (number1 / number2));
		System.out.println("number1 % number2 = " + (number1 % number2));
		// 문자열로 시작하는 연산자는 무조건 접합 연산자 (사칙연산이 되는 것이 아닌 그냥 이어붙이는 역할)
		// System.out.println("number1 + number2 = " + number1 + number2); ---> number1 + number2 = 52
		// 사칙연산 하려고 하는 부분을 ()로 묶어주면 사칙연산으로 적용 가능
		// System.out.println("number1 + number2 = " + (number1 + number2)); ---> number1 + number2 = 7

	}

}
