package Day2;

public class Ex18 {

	public static void main(String[] args) {
		// 100 ~ 90 : A, 89 ~ 80 : B, 79 ~ 70 : C, 69 ~ 60 : D, 59 이하 : F
		int score = 74;
		// else if 문
		if (90 <= score && score <= 100) {
			System.out.println('A');
		} else if (80 <= score && score <= 89) {
			System.out.println('B');
		} else if (70 <= score && score <= 79) {
			System.out.println('C');
		} else if (60 <= score && score <= 69) {
			System.out.println('D');
		} else if (score <= 59) {
			System.out.println('F');
		} else {
			System.out.println("다시 입력해주세요.");
		}
	}
}