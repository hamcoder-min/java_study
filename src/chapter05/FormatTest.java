package chapter05;

public class FormatTest {

	public static void main(String[] args) {
		// 정수를 출력 시 3자리씩 콤마로 구분하는 메소드
		
		int a = 280000000;
		String aa = String.format("%,d", new Object[] { Integer.valueOf(a) });
		System.out.println(aa);

	}

}
