package Day2;

public class Ex17 {

	public static void main(String[] args) {
		// 100 ~ 90 : A, 89 ~ 80 : B, 79 ~ 70 : C, 69 ~ 60 : D, 59 이하 : F
		int score = 74;

		// 다중 if문
		if (score >= 90) {
			System.out.println('A');
		} else {
			if (score >= 80) {
				System.out.println('B');
			} else {
				if (score >= 70) {
					System.out.println('C');
				} else {
					if (score >= 60) {
						System.out.println('D');
					} else {
						System.out.println('F');
					}
				}
			}

		}
	}
}
