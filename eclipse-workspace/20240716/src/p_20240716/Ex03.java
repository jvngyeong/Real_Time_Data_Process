package p_20240716;

public class Ex03 {

	public static void main(String[] args) {
		int i = 10;		//정수형 변수
		//				 변수				객체
		Ex03_Calculator calc = new Ex03_Calculator(10, 20);		//객체 변수
		calc.add();
		System.out.println(calc.getFirst());
		System.out.println(calc.getSecond());
		System.out.println(calc.getResult());
		
		Ex03_Calculator calc1 = new Ex03_Calculator(100, 200);
		calc1.add();
		System.out.println(calc1.getFirst());
		System.out.println(calc1.getSecond());
		System.out.println(calc1.getResult());
		
		Ex03_Calculator calc2 = new Ex03_Calculator(100, 200);
		calc2.add();
		System.out.println(calc2.getFirst());
		System.out.println(calc2.getSecond());
		System.out.println(calc2.getResult());
		intMethod(i);
	}
	public static void intMethod(int a) {		//값 전달 방식, 값을 전달했기 떄문
		System.out.println(a);
	}
	public static void print(Ex03_Calculator c) {	//객체 전달 방식, 객체를 전달했기 때문
		c.add();
		System.out.println(c.getFirst());
		System.out.println(c.getSecond());
		System.out.println(c.getResult());
	}
}
