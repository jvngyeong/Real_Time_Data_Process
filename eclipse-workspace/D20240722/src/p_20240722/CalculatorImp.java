package p_20240722;

public interface CalculatorImp {
	//인터페이스에는 final 변수만 존재!!!
	double PI = 3.141592;
	int ERROR = 999;
	
	public abstract int add();	//추상메서드
	public int sub();
	default void print() {
		System.out.println("디펄드 메서드");
	}
}
