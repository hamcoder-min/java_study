package chapter03;

/*
 * 제어문자 실습
 */
public class EscpateTest {

	public static void main(String[] args) {
		String greet = "안녕하세요~ \n\n반갑습니다. \t\t홍길동입니다.";
		String name = "\"홍길동\"";
		//''는 \가 없어도 이클립스에서는 인식이 가능!
		// ""는 \가 꼭 있어야 한당

		System.out.println(greet);
		System.out.println(name);
	}

}
