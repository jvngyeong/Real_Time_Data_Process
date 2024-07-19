package p_20240710;

import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 값을 입력해주세요. = ");
		int start = sc.nextInt();
		System.out.print("끝 값을 입력해주세요. = ");
		int end = sc.nextInt();
		int result = 0;
		for(int i = start; i<=end; i++) {
			result += i;
		}
		
		System.out.println(result);
	}

}
