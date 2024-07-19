package p_20240719;

public interface CalculatorImp {	//생성자와 멤버가 없음.
	/*
	 * final double PI = 3.141592; //상수 
	 * int ERROR = 99999; //interface에서는 final을 붙이지 않아도 상수가 됨.
	 */	
	
	//추상 메서드
	void add(int num1, int num2);	//interface에서는 abstract를 붙이지 않아도 추상 메서드가 됨.
	int sub();
	
	// ---9버전 이후---
	//default 메서드	(내용을 담고 있는 메서드)
	default void print() {
		System.out.println("default 메서드입니다.");
	}
	
	//정적 메서드
	static int total(int[] arr) {
		int total = 0;
		for(int i : arr) {
			total += i;
		}
		return total;
	}
}
