package p_20240718;

public /*final*/class Ex07_Calculator {
	int first;
	int second;
	int result;

	public Ex07_Calculator(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public void add() {
		result = first + second;
	}

	public void div() {
		result = first / second;
	}
}
