package p_20240710;

import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {
		// 5단 while
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 곱을 입력해주세요. = ");
		int startGop = sc.nextInt();
		System.out.print("끝 곱을 입력해주세요. = ");
		int endGop = sc.nextInt();
		int gop = startGop;
		while(gop <= endGop) {
			System.out.println("5 * " + gop + " = " + 5 * gop);
			gop++;
		}

	}

}
