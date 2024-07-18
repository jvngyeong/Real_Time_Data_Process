package p_20240718_Array_Example;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		/*
		 * 사용자에게 입력받은 양의 정수만큼 배열 크기를 할당하고
		 * 1부터 입력받은 값까지 배열에 초기화한 후 출력하세요.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요. = ");
		int num = sc.nextInt();
		int[] a = new int[num];
		for(int i = 0; i < a.length; i++) {
			a[i] = i+1;
		}
		for(int val : a) {
			System.out.println(val);
		}
	}

}
