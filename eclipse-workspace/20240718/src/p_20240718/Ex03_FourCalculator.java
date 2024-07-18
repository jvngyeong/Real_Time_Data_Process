package p_20240718;

public class Ex03_FourCalculator extends Ex03_Calculator {
	//부모 클래스에 매개변수를 받는 생성자가 존재하기 때문에,
	//자식 클래스에서도 매개변수를 받는 생성자를 만들어줘야 한다..
	public Ex03_FourCalculator(int first, int second) {
		super(first, second);
	}
	public void sub() {
		result = first - second;
	}

	public void mul() {
		result = first * second;
	}
}
