package Day2;

public class Ex14 {

	public static void main(String[] args) {
		// 조건식 : if ~ else문 예제 1
		char gender = 'M';
		if(gender == 'M') {
			System.out.println("남자입니다.");
		}
		else {
			System.out.println("여자입니다.");
		}
		
		// if ~ else문 예제 2
		int money = 1000;
		if (money >= 1450) {
			System.out.println("버스를 타고 가세요.");
		}
		else {
			System.out.println("걸어가세요.");
		}
		// if ~ else문 예제 3
		// 각 과목이 40점 이상이어야 하고, 평균이 60점 이상이어야 합격.
		int eng = 40;
		int kor = 70;
		int mat = 80;
		float avg = (eng + kor + mat) / 3;
		// if문 괄호 안에 result를 넣은 버전
		boolean result;
		result = eng >= 40 && kor >= 40 && mat >= 40 && avg >= 60;
		if(result) {
			System.out.println("합격입니다 !");
		}
		else {
			System.out.println("불합격입니다.");
		}
		// if문 괄호 안에 조건식을 넣은 버전
		if(eng >= 40 && kor >= 40 && mat >= 40 && avg >= 60) {
			System.out.println("합격입니다 !");
		}
		else {
			System.out.println("불합격입니다.");
		}
	}
}