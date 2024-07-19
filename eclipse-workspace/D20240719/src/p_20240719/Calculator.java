package p_20240719;

public class Calculator implements CalculatorImp {
	int first = 10;
	int second = 20;

	public Calculator() {
	}

	public Calculator(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public void add(int num1, int num2) {
		System.out.println(num1 + num2);
	}

	@Override
	public int sub() {
		return first - second;
	}
	public void print() {
		System.out.println("Calculator에서 default 메서드를 재정의");
	}
}
