package p_20240718;

public class Ex04_FourCalculator extends Ex04_Calculator {
	
	public Ex04_FourCalculator(int first, int second) {
		super(first, second);
	}

	public Ex04_FourCalculator() {
		super();
	}

	public void sub() {
		result = first - second;
	}

	public void mul() {
		result = first * second;
	}
}