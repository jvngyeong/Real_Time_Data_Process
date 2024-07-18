package p_20240718;

public class Ex06_FourCalculator extends Ex06_Calculator{

	public Ex06_FourCalculator(int first, int second) {
		super(first, second);
	}
	public void sub() {
		result = first - second;
	}

	public void mul() {
		result = first * second;
	}
	
	/* final 키워드 때문에 오버라이딩 불가능.
	 * public void div() {
	 * 
	 * }
	 */
}
