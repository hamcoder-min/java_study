package chapter06;

import java.util.Arrays;

/*
 * 배열 복사 : for, System.arrayCopy(), Arrays.copyOf()
 */

public class ArrayCopyTest {

	public static void main(String[] args) {
		int[] arrInt = { 1, 2, 3 };
		int[] arrInt2 = new int[5];
		int[] arrInt3 = new int[3];		// System.arrayCopy()
				// Arrays.copyOf()
		
		// 1. for
		for(int i = 0; i<arrInt.length; i++) {
			arrInt2[i] = arrInt[i];
			
		}
		for(int i = 0; i < arrInt2.length; i++) {
			System.out.print(arrInt2[i] + "\t");
		}
		
		
		// 2. System.arrayCopy()
		
		//public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		//System.arraycopy((원본), (복사할 시작 인덱스값), (복제본), (대상 배열의 복사 위치 시작 인덱스), (복사할 길이));
		System.arraycopy(arrInt, 0, arrInt3, 0, arrInt.length);
		System.out.println();
		for(int i = 0; i<arrInt3.length; i++) System.out.print(arrInt3[i] + "\t");
		
		
		// 3. Arrays.copyOf()
		
		// public static int[] copyOf(int[] original, int newLength)
		int[] arrInt4 = Arrays.copyOf(arrInt, arrInt.length);
		System.out.println();
		for(int i = 0; i<arrInt4.length; i++) System.out.print(arrInt4[i] + "\t");
		
		

	}

}
