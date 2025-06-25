package chapter03;

public class PrimitiveDataTypeTest {
	public static void main(String[] args) {
		//논리형
		boolean run = true; 
		
		//정수형 데이터 타입
		byte b = 1;
		short s = 10;
		int i = 100;
		long l = 1000;
		long l2 = 1000L;
		
		//실수형 데이터 타입
		float f = 10.0f;
		double d = 100.0;
		
		//문자리터럴 데이터 타입
		char c = 'a';
		char c2 = 'A';
		int c_asc = c;
		int c_asc2 = c2;
		
		
		System.out.println("boolean : " + run);
		System.out.println("byte : " + b);
		System.out.println("short : " + s);
		System.out.println("int : " + i);
		System.out.println("long : " + l);
		System.out.println("long : " + l2);
		System.out.println("float : " + f);
		System.out.println("double : " + d);
		System.out.println("char : " + c);
		System.out.println("char : " + c2);
		System.out.println("char : " + c_asc); //97
		System.out.println("char : " + c_asc2); //65
		
		
	}

}
