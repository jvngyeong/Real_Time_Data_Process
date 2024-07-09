package Day2;

public class Ex2 {

	public static void main(String[] args) {
		//정수 리터널
		byte b;		//1 byte
		b = -128;
		System.out.println(b);
		b = 127;
		
		short s;	//2 byte
		s = -32768;
		System.out.println(s);
		s = 32767;
		System.out.println(s);
		
		int i = -2100000000;	//4 byte
		System.out.println(i);
		i = 2100000000;
		System.out.println(i);
		
		long l = 22000000001l;	//8 byte
		System.out.println(l);
		l = -22000000001l;
		System.out.println(l);
		
		//실수 리터널
		float f = 0.1234567890f;	//4 byte
		System.out.println(f);
		
		double d = 0.1234567890;	//8 byte
		System.out.println(d);
		
		//논리형
		boolean bl = true;
		System.out.println(bl);
		bl = false;
		System.out.println(bl);
		
		//문자 & 정수형
		char ch = 'A';
		System.out.println(ch);
		ch = 65;
		System.out.println(ch);
		
		//문자열
		String str = "이준경";
		System.out.println(str);
		str = "입니다";
		System.out.println(str);
	}

}
