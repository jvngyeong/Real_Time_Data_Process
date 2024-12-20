package p_20240718_Array_Example;

import java.util.Scanner;

public class ArrayEx05 {

	public static void main(String[] args) {
		/*
		 * '월' ~ '일'까지 초기화된 문자 배열을 만들고 0부터 6까지 숫자를 입력받아
		 * 입력한 숫자와 같은 인덱스에 있는 요일을 출력하고, 범위에 없는 숫자를 입력 시
		 * "잘못 입력하셨습니다."를 출력하세요.
		 */
		Scanner sc = new Scanner(System.in);
		char[] day = new char[] {'월', '화', '수', '목', '금', '토', '일'};
		System.out.print("0부터 6까지 숫자를 입력하세요. = ");
		int num = sc.nextInt();
		if(num > 6 || num < 0) {
			System.out.println("잘못 입력하셨습니다.");
		}
		else {
			System.out.println(day[num]);
		}
	}

}
