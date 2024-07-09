package Day2;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 덧셈, 2. 뺄셈");
		System.out.print("1부터 2사이의 값을 입력하세요. = ");
		int inputNum = sc.nextInt();
		if(inputNum == 1) {
			System.out.println("더한 값은 = " + (num1 + num2));
		}
		else if(inputNum == 2) {
			System.out.println("뺀 값은 = " + (num1 - num2));
		}
		else {
			System.out.println("다시 입력해주세요.");
		}
	}
}
