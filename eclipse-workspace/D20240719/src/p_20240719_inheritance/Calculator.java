package p_20240719_inheritance;

public class Calculator implements CalculatorImp2 {
	int first;
	int second;

	public Calculator(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(int num1, int num2) {
		// TODO Auto-generated method stub
	}

	@Override
	public int sub() {
		return first - second;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		CalculatorImp2.super.print();
	}
}
