package p_20240716;

public class Ex09_Constant {
	final double PI = 3.141592;		//final을 이용해서 PI를 상수로 만들어줌.
	int first;
	int radius;
	double result;
	public void circle(int radius) {
		//this.PI = 10.5;	//final을 사용해서 상수가 되었기 때문에 값을 변경하는 것이 불가능.
		result = radius * radius * PI;
	}
}
