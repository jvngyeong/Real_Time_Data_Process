package p_20240710;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// 8세 미만은 "미취학 아동입니다.", 입장료가 1000원
		// 14세 미만은 "초등학생입니다.", 입장료가 2000원
		// 20세 미만은 "중, 고등학생입니다.", 입장료가 2500원
		// 20세 이상은 "일반인입니다.", 입장료가 3000원
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력해주세요. = ");
		int age = sc.nextInt();
		int charge;
		if (0 < age && age < 8) {
			charge = 1000;
			System.out.println("미취학 아동입니다. 입장료는 " + charge + "원입니다.");
		} else if (8 <= age && age < 14) {
			charge = 2000;
			System.out.println("초등학생입니다. 입장료는 " + charge + "원입니다.");
		} else if (14 <= age && age < 20) {
			charge = 2500;
			System.out.println("중,고등학생입니다. 입장료는 " + charge + "원입니다.");
		} else if (age >= 20) {
			charge = 3000;
			System.out.println("일반인입니다. 입장료는 " + charge + "원입니다.");
		}

		switch (age) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			charge = 1000;
			System.out.println("미취학 아동입니다. 입장료는 " + charge + "원입니다.");
			break;
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
		case 13:
			charge = 2000;
			System.out.println("초등학생입니다. 입장료는 " + charge + "원입니다.");
			break;
		case 14:
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
			charge = 2500;
			System.out.println("중,고등학생입니다. 입장료는 " + charge + "원입니다.");
			break;
		default:
			charge = 3000;
			System.out.println("일반인입니다. 입장료는 " + charge + "원입니다.");
			break;
		}
	}

}
