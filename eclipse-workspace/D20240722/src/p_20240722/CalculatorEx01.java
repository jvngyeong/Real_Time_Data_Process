package p_20240722;

public class CalculatorEx01{

	public static void main(String[] args) {
		//CalculatorAbstract ex01 = new CalculatorAbstract(10, 20);
		FourCalculatorExtends ex02 = new FourCalculatorExtends(10, 20);
		//다형성
		CalculatorAbstract ex03 = new FourCalculatorExtends(10, 20);
	}
}

//객체 지향의 특징
//1. 캡슐화 : 은닉
//2. 상속 : 오버라이딩
//3. 다형성 : 같은 부모 클래스로 상속받은 객체가 부모 이름으로 같이 쓸 수 있는 것