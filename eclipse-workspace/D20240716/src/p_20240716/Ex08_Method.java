package p_20240716;

public class Ex08_Method {
	int first = 10;
	int second = 20;
	int result;
	public Ex08_Method() {}			//생성자 오버로딩
	public Ex08_Method(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void add() {
		result = first + second;	//멤버 변수들
	}
	public void add(int first) {	//메서드 오버로딩
		result = first + second;	//result, second = 멤버 | first = 매개변수
	}
	/*public int add() {
		오버로딩 성립 X
	}*/
	public void add(int first, int second) {
		this.first = first;
		this.second = second;
		result = this.first + this.second;
	}
}
