package p_20240709;

import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		// Scanner를 이용해서 변수 kor, eng, mat에 값을 입력 받자.
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력해주세요. = ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력해주세요. = ");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 입력해주세요. = ");
		int mat = sc.nextInt();
		System.out.println("당신의 국어 점수는 = " + kor);
		System.out.println("당신의 영어 점수는 = " + eng);
		System.out.println("당신의 수학 점수는 = " + mat);
		
		int avg = (kor + eng + mat) / 3;
		
		//각 과목이 40점 이상이어야 하고, 평균이 60점 이상이어야 합격.
		if(kor >= 40 && eng >= 40 && mat >= 40 && avg >= 60) {
			System.out.println("합격입니다.");
		}
		else {
			System.out.println("불합격입니다.");
		}
	}

}
