package p_20240708_2;

public class Hello
{
	public static void main(String[] args) {
		// -128 ~ 127
		//byte 20;		// 변수명은 숫자일 수 없다.
		byte LJK = 8;	// byte 변수 LJK 선언, 초기화
		LJK = 20;		// 대입
		
		String JK = "이준경";	// String 변수 JK 선언, 초기화

		String firstName = "이";
		//string firstName;		//변수명은 한 번만 선언한다.
		firstName = "숭";
		
		String firstname;	//변수명은 대소문자를 구분한다.
		firstname = "무";	//초기화를 하지 않으면 오류 발생.
		
		System.out.println("이숭무");
		System.out.println(LJK);
		System.out.println(JK);
		System.out.println(firstName);
		System.out.println(firstname);
	}
}
