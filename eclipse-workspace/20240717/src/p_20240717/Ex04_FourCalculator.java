package p_20240717;

public class Ex04_FourCalculator extends Ex04_Calculator{
	/*int first;
	int second;
	int result;
	
	public void add() {
		result = first + second;
	}
	public void div() {
		result = first / second;
	}*/
	public Ex04_FourCalculator(int first, int second) {
		super(first, second);		//부모 생성자를 자식 Class에서 사용할 때, 부모 생성자의 이름 대신 super라는 이름으로 사용한다.
		System.out.println("자식 객체");
	}
	public void sub() {
		result = first - second;
	}
	public void mul() {
		result = first * second;
	}
}
