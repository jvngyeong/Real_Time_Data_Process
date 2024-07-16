package p_20240716;

public class Ex07_Method {
	int first = 10;
	int second = 20;
	int result;
	public Ex07_Method() {}		//생성자 오버로딩
	public Ex07_Method(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void add(int first) { 	//메서드 오버로딩
		this.first = first;
		result = first + second;
	}
	
	public void add() {
		result = first + second;
	}
	public void print() {
		System.out.println(first);
		System.out.println(second);
		System.out.println(result);
	}
}
