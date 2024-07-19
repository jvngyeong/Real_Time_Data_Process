package p_20240708_2;

public class CastingTest {

	public static void main(String[] args) {
		byte b = 100;
		int i = -2100000000;
		System.out.println(b);
		System.out.println(i);
		i = b;	// byte => int 자동 형 변환(Promotion)
		System.out.println(i);
		
		double d = b;	//byte => double 자동 형 변환(Promotion)
		System.out.println(d);
		
		// byte => short => int => long => float 으로 변환 가능
		//						=> float => double
		b = (byte)i;	//강제 형 변환(Casting)
		System.out.println(b);
		i = 128;
		//0000 0000 0000 0000 0000 0000 1000 0000
		b = (byte)i;
		//1000 0000 => -128
		System.out.println(b);
		
		i = 129;
		// 0000 0000 0000 0000 0000 0000 1000 0001
		b = (byte)i;
		// 1000 0001 => -127
		System.out.println(b);
		// 1111 1111 => -1
	}
}
