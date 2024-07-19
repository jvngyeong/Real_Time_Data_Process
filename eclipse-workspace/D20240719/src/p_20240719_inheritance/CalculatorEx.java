package p_20240719_inheritance;

import p_20240719.CalculatorImp;

public class CalculatorEx {

	public static void main(String[] args) {
		Calculator c = new Calculator(20, 30);
		c.add(20, 30);
		System.out.println(c.sub());
		c.print();
		int sum = CalculatorImp.total(new int[] {1,2,3,4});
		System.out.println(sum);
	}
}
