package p_20240708_2;

public class TypeTest {

	public static void main(String[] args) {
		//정수형 데이터
		byte b = -128;
		System.out.println(b);
		b = 127;
		System.out.println(b);
		
		short sh = -32768;
		System.out.println(sh);
		sh = 32767;
		System.out.println(sh);
		
		int i = -2147483648;
		System.out.println(i);
		i = 2147483647;
		System.out.println(i);
		
		long l = 10000000000L;	//21억을 넘으면 대문자 L을 붙여줘야 함.
		System.out.println(l);
		l = 100;				//안넘으면 그냥 사용 가능.
		System.out.println(l);
		
		//실수형 데이터
		float f = 12.3f;
		System.out.println(f);
		f = 45.6f;
		System.out.println(f);
		
		double d = 65.4;
		System.out.println(d);
		d = 32.1;
		System.out.println(d);
		
		//논리형 데이터
		boolean bl = true;
		System.out.println(bl);
		bl = false;
		System.out.println(bl);
		
		//문자
		char ch = 'A';
		System.out.println(ch);
		ch = 65;		//ASCII 코드 값으로도 저장 가능.
		System.out.println(ch);
		ch = '이';
		System.out.println(ch);
	}
}
