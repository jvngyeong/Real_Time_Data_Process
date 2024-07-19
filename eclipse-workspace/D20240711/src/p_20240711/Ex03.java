package p_20240711;

public class Ex03 {

	public static void main(String[] args) {
		// 배열 선언법
		//1.
		double d[] = {10.0, 20.0, 30.0, 40.0};
		for(double z : d) {
			System.out.println(z);
		}
		//2.
		double d1[] = new double[] {10.0, 20.0, 30.0, 40.0};
		
		//3.
		double[] d2 = new double[4];
		for(double z : d2) {
			System.out.println(z);
		}
		System.out.println("배열 d2의 크기 = " + d2.length);
		
		for(int idx = 0; idx < d2.length; idx++) {
			d2[idx] = idx + 1;
		}
		for(double z : d2) {
			System.out.println(z);
		}
		for(int idx = 0; idx <= d2.length - 1; idx++) {
			d2[idx] = idx + 10;
		}
		for(double z : d2) {
			System.out.println(z);
		}
	}
}
