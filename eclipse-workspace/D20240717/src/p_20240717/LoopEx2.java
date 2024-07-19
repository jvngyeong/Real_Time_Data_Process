package p_20240717;

import java.util.Scanner;

public class LoopEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요. 단, 입력한 수는 1보다 크거나 같아야 합니다. 만일
		 * 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요."를 출력해주세요.
		 */

		/*
		 * System.out.println("숫자를 입력하세요."); int a = sc.nextInt(); if(a < 1) {
		 * System.out.println("1 이상의 숫자를 입력해주세요."); } else { for(int i = 1; i <= a; i++)
		 * { System.out.println(i); } }
		 */

		/*
		 * 2. 위의 예제에서 1 미만의 숫자를 입력하면 사용자가 다시 값을 입력하도록 바꿔보세요.
		 */

		/*
		 * while(true) { System.out.println("숫자를 입력하세요."); int a = sc.nextInt(); if(a <
		 * 1) { System.out.println("1 이상의 숫자를 입력해주세요."); } else { for(int i = 1; i <= a;
		 * i++) { System.out.println(i); } break; } }
		 */

		/*
		 * 3. 사용자로부터 한 개의 값을 입력받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요. 단, 입력한 수는 1보다 크거나 같아야
		 * 합니다.
		 */
		/*
		 * System.out.println("숫자를 입력하세요."); int a = sc.nextInt(); if(a < 1) {
		 * System.out.println("1보다 크거나 같아야 합니다."); } else { for(int i = a; i>=1; i--) {
		 * System.out.println(i); } }
		 * 
		 * /* 4. 위의 예제에서 1 미만의 숫자를 입력하면 사용자가 다시 값을 입력하도록 바꿔보세요.
		 */
		/*
		 * while(true) { System.out.println("숫자를 입력하세요."); int a = sc.nextInt(); if(a <
		 * 1) { System.out.println("1 이상의 숫자를 입력해주세요."); } else { for(int i = a; i >= 1;
		 * i--) { System.out.println(i); } break; } }
		 */

		/*
		 * 5. 1부터 사용자가 입력한 값까지의 합을 구하시오.
		 */
		/*
		 * int sum = 0; System.out.print("숫자를 입력하세요. = "); int a = sc.nextInt(); for(int
		 * i = 1; i <= a; i++) { sum+=i; } System.out.print("합계는 = " + sum);
		 */

		/*
		 * 6. 위 예제를 1+2+3+4+5+...+num = sum으로 출력
		 */
		/*
		 * int sum = 0;
		 * 
		 * System.out.print("숫자를 입력하세요. = "); int a = sc.nextInt(); for(int i = 1; i <=
		 * a; i++) { sum+=i; System.out.print(i); if(i<a) { System.out.print(" + "); } }
		 * System.out.print(" = " + sum);
		 */

		/*
		 * 7. 두 개의 값을 입력받았을 때, 첫 번째 값이 크거나 두 번째 값이 커도 무조건 작은 값부터 출력하세요.
		 */
		/*System.out.print("첫 번째 값을 입력하세요 = ");
		int a = sc.nextInt();
		System.out.print("두 번째 값을 입력하세요 = ");
		int b = sc.nextInt();
		if (a >= 1 && b >= 1) {
			if (a > b) {
				for (int i = b; i <= a; i++) {
					System.out.print(i);
					if (i != a) {
						System.out.print(", ");
					}
				}
			} else {
				for (int i = a; i <= b; i++) {
					System.out.print(i);
					if (i != b) {
						System.out.print(", ");
					}
				}
			}
		} else
			System.out.println("1 이상의 값을 입력하세요.");*/
		
		// 사용자로부터 입력받은 값부터 구구단을 출력하세요.
		// 단 1미만 10 이상의 값을 입력하면 "1부터 9까지의 값만 입력하세요."를 출력.
		/*while(true) {
			System.out.print("단을 입력하세요. = ");
			int a = sc.nextInt();
			if(a < 1 || a >= 10) {
				System.out.println("1부터 9까지의 값만 입력하세요.");
			}
			else {
				for(int i = a; i<=9; i++) {
					System.out.println("==== " + i +"단 ====");
					for(int j = 1; j<=9; j++) {
						System.out.println(i + " * " + j + " = " + i*j);
					}
				}
				break;
			}
		}*/
		
		/*
		 * 두 개의 숫자를 입력받아 하나의 연산자를 입력받아 사칙 연산을 하시오.
		 */
		/*boolean run = true;
		while(run) {
			System.out.print("첫 번째 숫자를 입력 = ");
			int a = sc.nextInt();
			System.out.print("두 번째 숫자를 입력 = ");
			int b = sc.nextInt();
			sc.nextLine();
			System.out.print("연산자를 입력 = ");
			String c = sc.nextLine();
			switch(c) {
			case "+" : System.out.println(a + " + " + b + " = " + (a+b)); run = false; break;
			case "-" : System.out.println(a + " - " + b + " = " + (a-b)); run = false; break;
			case "*" : System.out.println(a + " * " + b + " = " + (a*b)); run = false; break;
			case "/" : 
				if(b == 0) {
					System.out.println("0이 아닌 값을 입력해주세요.");
					continue;
				}
				System.out.println(a + " / " + b + " = " + (a/b)); run = false; break;
			case "%" : System.out.println(a + " % " + b + " = " + (a%b)); run = false; break;
			default : System.out.println("다시 입력해주세요."); break;
			}
		}*/
		System.out.print("정수 입력 = ");
		int a= sc.nextInt();
		
		for(int i = a; i>= 0; i--) {
			for(int j = a; j > a-i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
