package p_20240710;

import java.util.Scanner;

public class Ex18 {

	public static void main(String[] args) {
		// 1 ~ 100까지의 합을 구하는 while문을 만드시오.
		Scanner sc = new Scanner(System.in);
		int result = 0;
		System.out.print("시작 숫자를 입력해주세요. = ");
		int i = sc.nextInt();
		System.out.print("끝 숫자를 입력해주세요. = ");
		int end = sc.nextInt();
		while(i <= end) {
			result += i;
			i++;
		}
		System.out.println(result);
	}
}
