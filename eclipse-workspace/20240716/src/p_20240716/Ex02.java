package p_20240716;

public class Ex02 {
	static Ex02_Calculator calc = new Ex02_Calculator();
	static Ex02_Calculator calc1 = new Ex02_Calculator(100, 200);
	public static void main(String[] args) {
		calc.add();
		calc.print();
		
		calc1.add();
		calc1.print();
		print();
	}
	
	public static void print() {
		System.out.println(calc.getFirst());
		System.out.println(calc.getSecond());
		System.out.println(calc.getResult());
	}

}
