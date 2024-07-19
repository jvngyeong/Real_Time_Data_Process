package p_20240718;

public class Ex02_FourCalculator extends Ex02_Calculator {
	// 부모 클래스에 기본 생성자가 존재할 경우, 자식 클래스에는 만들 필요가 없지만,
	// 만들 경우엔 다음과 같이 만들어야 함. | super()를 사용!
	public Ex02_FourCalculator() {
		super();
	}

	public void sub() {
		result = first - second;
	}

	public void mul() {
		result = first * second;
	}
}
