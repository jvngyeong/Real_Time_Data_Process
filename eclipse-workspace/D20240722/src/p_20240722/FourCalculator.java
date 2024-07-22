package p_20240722;

public class FourCalculator extends Calculator{

	public FourCalculator(int first, int second, int result) {
		super(first, second, result);
	}
	public int sub() {
		return first - second;
	}
	public int mul() {
		return first * second;
	}
	@Override
	public int add() {
		return first + second;
	}
	public int div() {
		if(second == 0)return 0;
		else return first /second;
	}
}
