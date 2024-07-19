package p_20240719;

public class CalculatorEx {

	public static void main(String[] args) {
		Calculator c = new Calculator(10, 20);
		c.add(20,30);
		System.out.println(c.sub());
		c.print();
		System.out.println(CalculatorImp.total(new int[] {1,2,3,4}));
	}
}