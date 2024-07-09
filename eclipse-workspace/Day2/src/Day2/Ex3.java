package Day2;

public class Ex3 {

	public static void main(String[] args) {
		// 형 변환
		// 자동 형 변환
		short s = 10;
		int i = s;
		
		// 강제 형 변환
		byte b = (byte)i;
		System.out.println("b의 값은 = " + b);
		/*  1		 2		 4		8   byte
		 * byte => short => int => long
		 * 
		 * 정수 => 실수 : 자동
		 * 실수 => 정수 : 강제
		 */
		
		float f = i;
		System.out.println("f의 값은 = " + f);
		i = (int)f;
		System.out.println("i의 값은 = "+ i);
	}

}
