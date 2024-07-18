package p_20240718_abstract;

public abstract class Calculator {
	// 멤버
	int first;
	int second;
	int result;
	// 생성자
	public Calculator(int first, int second) {
		this.first = first;
		this.second = second;
	}
	// 메서드
	public void add() {
		result = first + second;
	}
	// 추상 메서드
	public abstract void div();
}
