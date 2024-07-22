package p_20240722;

public class FourCalculatorImp implements CalculatorImp{
	int first;
	int second;
	@Override
	public int add() {
		return first + second;
	}

	@Override
	public int sub() {
		return first - second;
	}
	
	@Override
	public void print() {
		System.out.println(first * second);
	}
}
