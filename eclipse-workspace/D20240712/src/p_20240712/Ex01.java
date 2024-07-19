package p_20240712;

import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {
		// 1. 0, 0.0, false, null, blank('',"");
		// 2. 1차원 배열 선언
		int i [] = {1,2,3};
		int[] i1 = new int[]{1,2,3};
		int[] i2 = new int[3];
		int[] i3;
		// 3.
		int[] dan8 = new int[9];
		for(int idx = 0; idx < dan8.length; idx++) {
			dan8[idx] = 8 * (idx+1);
		}
		for(int val : dan8) {
			System.out.println(val);
		}
		
		// 4.
		System.out.println(dan8[4] + dan8[8]);
		
		// 5.
		char [] alphabets = new char[52];
		char ch ='A';
		System.out.println("--- 5번 문제 정답 ---");
		for(int idx = 0; idx < alphabets.length; idx++) {
			if(idx < alphabets.length / 2) {
				alphabets[idx] = (char)(idx + ch);
				System.out.print(alphabets[idx] + " ");
			}
			else if(idx >= alphabets.length / 2) {
				alphabets[idx] = (char)(ch + 57 - (idx - alphabets.length / 2));
				System.out.print(alphabets[idx] + " ");
			}
		}
		
		//6.
		System.out.println("--- 6번 문제 정답 ---");
		int [][] array = new int[8][9];
		for(int rowIdx = 0; rowIdx < array.length; rowIdx++) {
			for(int colIdx = 0; colIdx < array[rowIdx].length; colIdx++) {
				array[rowIdx][colIdx] = (rowIdx+2) * (colIdx+1);
				System.out.println((rowIdx+2) + " * " + (colIdx+1) + " = " + array[rowIdx][colIdx]);
			}
		}
		
		//7.
		System.out.println("--- 7번 문제 정답 ---");
		int [][] array_7 = new int[8][9];
		for(int rowIdx = 0; rowIdx < array.length; rowIdx++) {
			System.out.print((rowIdx+2) + "단 : [");
			for(int colIdx = 0; colIdx < array[rowIdx].length; colIdx++) {
				array_7[rowIdx][colIdx] = (rowIdx+2) * (colIdx+1);
				System.out.print(array_7[rowIdx][colIdx]);
				if(array[rowIdx].length != colIdx + 1) {
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
		
		//8.
		int[][] a = new int[3][];
		a[0] = new int[3];
		a[1] = new int[6];
		a[2] = new int[9];
		for(int rowIdx = 0; rowIdx < a.length; rowIdx++) {
			for(int colIdx=0; colIdx < a[rowIdx].length; colIdx++) {
				a[rowIdx][colIdx] = (rowIdx + 5)*(colIdx+1);
			}
		}
		
		for(int[] qw : a) {
			System.out.println(Arrays.toString(qw));
		}
		
		//9.
		System.out.println("--- 9번 문제 정답 ---");
		int max = 0;
		int [] array_9 = {1,5,3,8,2};
		for(int z : array_9) {
			if(z > max) {
				max = z;
			}
		}
		System.out.println("max : " + max);
		
		//10.
		System.out.println("--- 10번 문제 정답 ---");
		int [][] array_10 = {{95,86},{83,92,96},{78,83,93,87,88}};
		int sum = 0;
		int arrayNum = 0;
		double avg = 0.0;
		
		for(int rowIdx = 0; rowIdx < array_10.length; rowIdx++) {
			for(int colIdx = 0; colIdx < array_10[rowIdx].length; colIdx++) {
				sum += array_10[rowIdx][colIdx];
				arrayNum++;
			}
		}
		System.out.println("sum : " + sum);
		avg = (double)sum / arrayNum;
		System.out.println("avg : " + avg);
	}

}
