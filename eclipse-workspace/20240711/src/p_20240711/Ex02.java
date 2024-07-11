package p_20240711;

public class Ex02 {

	public static void main(String[] args) {
		// 변수 : 한 변수에 하나의 값만 저장 가능
		int i = 10;
		i = 20;
		System.out.println(i);
		int i0 = 10;
		int i1 = 20;
		
		//배열 : 한 변수에 여러 개의 값을 저장 가능
		int y[] = {10, 20, 30, 40};
		//		    0,  1,  2,  3
		System.out.println(y[0]);
		System.out.println(y[1]);
		y[0] = 100;
		System.out.println(y[0]);
		
		//배열을 선언하는 방법
		//1. 배열 선언과 초기화
		int j[] = {10, 20, 30, 40};
		System.out.println(j[0]);
		j[0] = 100;
		System.out.println(j[0]);
		//2. 배열 선언과 초기화
		int j1[] = new int[] {10, 20, 30, 40};
		System.out.println(j1[0]);
		j1[0] = 200;
		System.out.println(j1[0]);
		//3.
		int [] j2 = new int[4];
		// j2 [0][1][2][3] -> index
		j2[0] = 10;
		j2[1] = 20;
		j2[2] = 30;
		j2[3] = 40;
		
		System.out.println(j2[0]);
		System.out.println(j2[1]);
		System.out.println(j2[2]);
		System.out.println(j2[3]);
		
		for(int idx = 0; idx <= 3; idx++) {
			System.out.println(j2[idx]);
		}
		
		//배열을 사용할 때는 for 대신 foreach문을 사용하는게 좋음.
		for(int z : j2) {
			System.out.println(z);
		}
	}

}
