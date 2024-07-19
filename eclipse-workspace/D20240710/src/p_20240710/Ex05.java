package p_20240710;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈");
		System.out.print("숫자를 입력해주세요. = ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch (i) {
		case 1:
			System.out.println("덧셈의 결과 = " + (num1 + num2));
			break;
		case 2:
			System.out.println("뺄셈의 결과 = " + (num1 - num2));
			break;
		case 3:
			System.out.println("곱셈의 결과 = " + (num1 * num2));
			break;
		case 4:
			System.out.println("나눗셈의 결과 = 몫은 " + (num1 / num2) + ", 나머지는 = " + (num1 % num2));
			break;
		default:
			System.out.println("입력값이 잘못되었습니다.");
			break;
		}
	}
}
