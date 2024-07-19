package p_20240709;

public class Ex11 {

	public static void main(String[] args) {
		// +, -, *, /, % : 산술연산자
		// 문자열 + : 연결연산자
		// ++, -- : 증감연산자, 선행/후행
		// +=, -=, *=, /=, %=, = : 대입연산자
		// <, >, >=, <=, ==, != : 비교연산자 or 관계연산자.
		// 논리연산자 : &&, || : 결과를 true, false
		//					  피연산자도 논리값이다.
		boolean i, j, result;
		i = true;
		j = false;
		result = i && j;
		System.out.println(result);
		result = i || j;
		System.out.println(result);
		result = true && true;
		//논리연산자를 사용하는 경우에는 비교연산자를 같이 사용.
		int eng = 60;
		int kor = 70;
		int mat = 40;
		int avg;
		avg = (eng + kor + mat) / 3;
		// 과목 중 적어도 한 과목이 40점 미만이면 false
		// 평균이 60점 미만이어도 false
		result = mat < 40 && eng < 40 && kor < 40 && (avg) / 3 < 60;
		System.out.println(result);
		
		
		
		
		//if문으로 구현
		if(eng < 40 || kor < 40 || mat < 40 || avg < 60) {
			System.out.println(false);
		}
		else {
			System.out.println(true);
		}
	}
}
