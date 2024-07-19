package p_20240718_Array;

public class ArrayEx05 {
	public static void main(String[] args) {
		// 1.
		int[][] i0 = {{1,2,3},{4,5},{6,7,8,9}};
		// 2.
		int[][] i1 = new int[][]{{1,2,3},{4,5},{6,7,8,9}};
		// 3.
		int[][] i2 = new int[2][3];
		// 4.
		int[][] i3 = new int [2][];
		i3[0] = new int[2];	// [][] // [0][0], [0][1]
		i3[1] = new int[3]; // [][][] // [1][0], [1][1], [1][2]
		// 5. 
		int[][] i4;
		i4 = new int[2][3];
		i4 = new int[][]{{1,2,3},{4,5},{6,7,8,9}};
		i4 = new int[2][];
	}
}
