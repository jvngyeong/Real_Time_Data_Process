package p_20240711;

public class Ex14 {

	public static void main(String[] args) {
		// 2차원 배열
		// 1.
		int[][] i1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] i2 = new int[][] {{1, 2, 3, 4}, {5, 6}, {7, 8, 9}};
		for(int[] z : i1) {
			for(int x : z) {
				System.out.println(x);
			}
			System.out.println(".");
		}
		
		for(int[] z : i2) {
			for(int x : z) {
				System.out.println(x);
			}
			System.out.println(".");
		}
		
		System.out.println(i1.length);	//2차원 배열의 요소(1차원 배열들)의 숫자
		System.out.println(i1[0].length);
		System.out.println(i1[1].length);
		System.out.println(i1[2].length);
		for(int idx = 0; idx < i2.length; idx++) {
			for(int val = 0; val < i2[idx].length; val++) {
				System.out.println("i2[" + idx + "][" + val + "] = " + i2[idx][val]);
			}
		}
	}

}
