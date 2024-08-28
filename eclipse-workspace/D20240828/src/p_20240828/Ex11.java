package p_20240828;

public class Ex11 {

	public static void main(String[] args) {
		Calculator cal = new Calculator(10, 20);
		int result = cal.add();
		System.out.println(result);
		result = cal.div();
		System.out.println(result);
		
		FourCalculator cal1 = new FourCalculator(20, 10);
		result = cal1.add();
		System.out.println(result);
		result = cal1.sub();
		System.out.println(result);
		result = cal1.mul();
		System.out.println(result);
		result = cal1.div();
		System.out.println(result);
		
		FourCalculator cal2 = new FourCalculator(20, 0);
		result = cal2.div();
		System.out.println(result);
		
		cal = cal2;	//다형성
		result = cal.div();
		System.out.println(result);
	}

}
