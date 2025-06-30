package chapter06;

public class ArrayTest05 {

	public static void main(String[] args) {
		int[] nList = new int[3];
//		nList[0] = "1";	//Type mismatch -> 문자열x
//		nList[3] = 99; // -> 크기는 2번지까지 있는데 3을 넣었을 때 여기서는 type만 보기 때문에 오류 안남! Runtime시에 ArrayIndexOutOfException 발생
		
		
		System.out.println(nList.hashCode());
		System.out.println(nList[2]);

		for(int i = 0; i<nList.length; i++) {
			System.out.println(nList[i]);
		}
	}

}
