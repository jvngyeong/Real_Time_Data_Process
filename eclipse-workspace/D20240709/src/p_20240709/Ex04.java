package p_20240709;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		System.out.println(10 + 5);
		int i, j;	//변수 선언
		i = 10;
		j = 5;
		System.out.println("i + j = " + (i + j));
		
		Scanner sc = new Scanner(System.in);	// Scanner 객체 sc를 선언하고, 매개변수로 System.in을 사용하여 초기화함.
		System.out.print("num1의 값을 입력해주세요 = ");	//println 대신 print를 사용해서 줄 변환을 하지 않음.
		int num1 = sc.nextInt();	// Scanner 객체 sc가 System.in에서 사용자가 입력한 정수 값을 읽어와서 num1 변수에 저장함.
		System.out.println("num1 = " + num1);
		System.out.print("num2의 값을 입력해주세요 = ");	
		int num2 = sc.nextInt();
		System.out.println("num2 = " + num2);
		
		System.out.println("num1 + num2 = " + (num1+num2));
		
	}
}
