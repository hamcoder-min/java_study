package chapter07;

public class ArithmeticTest {

	public static void main(String[] args) {
		Arithmetic arithmetic = new Arithmetic();
		ArithmeticOverloading arithmetic_ol = new ArithmeticOverloading();
		
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(10, 20));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(3.14, 1.5));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("100", "200"));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(1,2,3,4,5,6,7,8,9,10));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("1","2","3"));
		
		
		System.out.println("======================================================");
		int add = arithmetic.add(10.7, 20.8);
		int sub = arithmetic.sub(10, 20);
		double mul = arithmetic.mul(3.14, 10); //결과는 실수값
		int div = arithmetic.div(10, 20);
		int mod = arithmetic.mod(10, 20);
		
		System.out.println("add = " + add);
		System.out.println("sub = " + sub);
		System.out.println("mul = " + mul);
		System.out.println("div = " + div);
		System.out.println("mod = " + mod);

	}

}
