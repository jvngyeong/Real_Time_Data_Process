package p_20240828;

public class Ex03 {

	public static void main(String[] args) {
		// 2차원 배열 선언
		// 1.
		int[][] i1 = {{1, 2, 3, 4},{10, 20, 30, 40}, {50, 60, 70, 80}};
		// 2. 
		int[][] i2 = new int[][] {{1, 2, 3, 4},{10, 20, 30}, {50, 60, 70, 80}};
		// 3.
		int[][] i3 = new int[3][4];	//초기화가 0으로 되어있다.
		i3[0] = new int[] {1, 2, 3, 4};	//위에서 열의 크기를 고정했기 때문에 크기가 4인 1차원 배열만 넣을 수 있다.
		i3[1] = new int[] {5, 6, 7, 8};
		//...
		i3[2][3] = 3000;
		//4.
		int[][] i4 = new int[3][];
		i4[0] = new int[] {1, 2, 3};	// 위에서 열의 크기를 고정하지 않았기 때문에 크기에 상관없이 넣을 수 있음.
		i4[1] = new int[] {4, 5, 6, 7};
		i4[2] = new int[] {7, 8, 9, 10, 11};
		
		//2차원 배열의 크기
		System.out.println(i4.length);
		//2차원의 배열 요소인 1차원 배열의 크기
		System.out.println(i4[0].length);
		System.out.println(i4[1].length);
		System.out.println(i4[2].length);
	}

}
