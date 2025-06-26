package chapter04;

/*
 * 논리연산자 : &&(AND), || (OR), !(NOT)
 * &&, || 연산자는 앞의 식의 결과에 따라 shortcut으로 진행됨
 */

public class OpLogicTest {

	public static void main(String[] args) {
		int a = 10;
		int b= 5;
		
		// AND(&&) : 두 개의 항의 결과가 모두 true인 경우에만 실행 결과가 true
		System.out.println((a > b) && (a == 10));	// true
		System.out.println((a > b) && (b == 10));	// false
		System.out.println((a < b) && (a == 10));	// false	shortcut 진행 (앞 식으로 인해 false로 판명 되었기 때문에 뒷 식을 볼 필요x)
		System.out.println((a < b) && (b == 10));	// false	shortcut 진행
		
		// OR(||) : 두 개의 항의 결과 중 하나라도 true이면 실행결과가 true
		System.out.println((a > b) || (a == 10));	// true		shortcut 진행
		System.out.println((a > b) || (b == 10));	// true		shortcut 진행
		System.out.println((a < b) || (a == 10));	// true
		System.out.println((a < b) || (b == 10));	// false
		
		// NOT(!) : 결과를 반대의 boolean 값으로 변경
		System.out.println(!(a > b) || (a == 10));		// true
		System.out.println(!(a > b) || !(a == 10));		// false
		System.out.println(!(!(a > b) || !(a == 10)));	// true
		// System.out.println(!a);  오류가 뜸 --> a는 int 타입으로 NOT 연선자가 적용되지 않음
	}

}
