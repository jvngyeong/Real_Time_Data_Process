package p_20240828;

public abstract class CalculatorAbstract {
	int num1;
	int num2;
	public CalculatorAbstract(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int add() {
		return num1 + num2;
	}
	
	//추상메서드
	public abstract int div();
	
}
