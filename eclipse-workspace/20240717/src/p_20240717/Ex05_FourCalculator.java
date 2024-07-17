package p_20240717;

public class Ex05_FourCalculator extends Ex05_Calculator{
	public Ex05_FourCalculator() {
		super();
	}
	public Ex05_FourCalculator(int first, int second) {
		/*
		this.first = first;
		this.second = second;
		*/
		super(first, second);
	}
	public void sub() {
		result = first - second;
	}
	public void mul() {
		result = first * second;
	}
}
