package p_20240722_wrapper;

public class WrapperEx01 {

	public static void main(String[] args) {
		//리터럴 자료형 |  wrapper 자료형
		byte b;		 	Byte b1;
		Short sh;		Short sh1;
		int i; 			Integer i1;
		long l;			Long l1;
		float f;		Float f1;
		double d;		Double d1;
		boolean bl;		Boolean bl1;
		char ch;		Character ch1;
		String str = "10";
		i = Integer.parseInt(str);
		System.out.println(i);
		//null 값 처리 / 문자열을 리터널로 변환
		d = Double.parseDouble(str);
		System.out.println(d);
		f = Float.parseFloat(str);
		System.out.println(f);
	}
}
