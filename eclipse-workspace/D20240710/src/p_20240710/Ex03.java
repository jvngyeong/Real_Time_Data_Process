package p_20240710;

public class Ex03 {

	public static void main(String[] args) {
		/*
		 * 다중 if문 if(조건식){ if(조건식){
		 * 
		 * } if(조건식){
		 * 
		 * } else {
		 * 
		 * } } else { ... }
		 */

		/*
		 * if ~ else if ~ else 예제 100 ~ 90 : A, 89 ~ 80 : B, 79 ~ 70 : C, 69 ~ 60 : D,
		 * 59 이하 : F
		 */
		int score = 74;
		if (score <= 100 && score >= 90) {
			System.out.println('A');
		} else if (score <= 89 && score >= 80) {
			System.out.println('B');
		} else if (score <= 79 && score >= 70) {
			System.out.println('C');
		} else if (score <= 69 && score >= 60) {
			System.out.println('D');
		} else if (score <= 59) {
			System.out.println('F');
		} else {
			System.out.println("오류");
		}
		/* 다중 if문 + if ~ else if ~ else문 예제
		   95점 이상이면 "A+", 90점 이상이면 "A",
		   85점 이상이면 "B+", 80점 이상이면 "B",
		   75점 이상이면 "C+", 70점 이상이면 "C",
		   65점 이상이면 "D+", 60점 이상이면 "D",
		   이 외는 "F"
		*/
		if (score >= 90) {
			if(score >= 95) System.out.println("A+");
			else System.out.println("A");
		}
		else if(score >= 80) {
			if(score >= 85) System.out.println("B+");
			else System.out.println("B");
		}
		else if(score >= 70) {
			if(score >= 75) System.out.println("C+");
			else System.out.println("C");
		}
		else if(score >= 60) {
			if(score >= 65) System.out.println("D+");
			else System.out.println("D");
		}
		else System.out.println("F");
		
		
		// 8세 미만은 "미취학 아동입니다.", 입장료가 1000원
		// 14세 미만은 "초등학생입니다.", 입장료가 2000원
		// 20세 미만은 "중, 고등학생입니다.", 입장료가 2500원
		// 20세 이상은 "일반인입니다.", 입장료가 3000원
		int age = 12;
		int charge;
		if(age > 20) {
			charge = 3000;
			System.out.print("일반인입니다. ");
		}
		else if(age < 20 && age >= 14) {
			charge = 2500;
			System.out.print("중, 고등학생입니다. ");
		}
		else if(age < 14 && age >= 8) {
			charge = 2000;
			System.out.print("초등학생입니다. ");
		}
		else if (age < 8 && age >= 0) {
			charge = 1000;
			System.out.print("미취학 아동입니다. ");
		}
		else {
			charge = 0;
			System.out.println("오류입니다. ");
		}
		System.out.print("입장료는 " + charge + "원입니다.");
	}
}
