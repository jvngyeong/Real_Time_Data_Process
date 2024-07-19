package p_20240718_Array;

public class ArrayEx07 {
	public static void main(String[] args) {
		int[][] i1 = new int[][]{{1,2,3},{4,5},{6,7,8,9}};
		// 0  1  2
		//[1][2][3]		: 0행
		//[4][5]		: 1행
		//[6][7][8][9] 	: 2행
		System.out.println(i1[0][0]);
		System.out.println(i1[0][1]);
		System.out.println(i1[0][2]);
		System.out.println(i1[1][0]);
		System.out.println(i1[1][1]);
		System.out.println(i1[2][0]);
		System.out.println(i1[2][1]);
		System.out.println(i1[2][2]);
		System.out.println(i1[2][3]);
		for(int row = 0; row < i1.length; row++) {
			for(int col = 0; col < i1[row].length; col++) {
				System.out.println(i1[row][col]);
			}
		}
		
		for(int[] row : i1) {
			for(int col : row) {
				System.out.println(col);
			}
		}
	}
}
