package p_20240718_Array;

public class ArrayEx03 {

	public static void main(String[] args) {
		int[] i = { 1, 2, 3, 4, 5 };
		for (int j = 0; j <= 4; j++) {
			System.out.println(i[j]);
		}
		System.out.println(i.length);
		for (int j = 0; j < i.length; j++) {
			System.out.println(i[j]);
		}
		for(int a : i) {
			System.out.println(a);
		}
	}
}
