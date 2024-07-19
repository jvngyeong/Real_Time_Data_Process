package p_20240710;

import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 9; i++) {
			System.out.println("5 * " + i + " = " + (5*i));
		}
		
		System.out.println("단을 입력해주세요. = ");
		int dan = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}
	}
}
