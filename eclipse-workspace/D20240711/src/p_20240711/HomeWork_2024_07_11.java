package p_20240711;

public class HomeWork_2024_07_11 {

	public static void main(String[] args) {
//		1. 정수 배열을 만들었을 때 초기값은?
//		   실수 배열을 만들엇을 때 초기값은?
//		   부울 배열을 만들었을 때 초기값은?
//		   문자열 배열을 만들었을 때 초기값은?
//		   문자를 배열을 만들었을 때 초기값은?
		System.out.println("--- 1번 문제 정답 ---");
		int[] i_1 = new int[1];
		double[] d_1 = new double[1];
		boolean[] bl_1 = new boolean[1];
		String[] Str_1 = new String[1];
		char[] ch_1 = new char[1];
		System.out.println("정수 배열을 만들었을 때 초기값 = " + i_1[0]);
		System.out.println("실수 배열을 만들엇을 때 초기값 = " + d_1[0]);
		System.out.println("부울 배열을 만들었을 때 초기값 = " + bl_1[0]);
		System.out.println("문자열 배열을 만들었을 때 초기값 = " + Str_1[0]);
		System.out.println("문자를 배열을 만들었을 때 초기값 = " + ch_1[0]);
//		2. 1차원배열을 선언하는 4가지 방법에 대해서 나열하시오.
		System.out.println("--- 2번 문제 정답 ---");
		System.out.println("1. int[] i_2_1 = {1, 2, 3};");
		System.out.println("2. int[] i_2_2 = new int[]{1, 2, 3};");
		System.out.println("3. int[] i_2_3 = new int[3];");
		System.out.println("4. int[] i_2_4;");
		
//		3. int [] dan8 = new int[9]을 이용해서 8단을 저장하고 foreach를 이용해서 출력하시오.
		System.out.println("--- 3번 문제 정답 ---");
		int [] dan8 = new int[9];
		for(int idx = 0; idx < dan8.length; idx++) {
			dan8[idx] = (idx+1) * 8;
		}
		for(int z : dan8) {
			System.out.println(z);
		}
//		4.  위 예제에서 4번요소와 8번요소를 더한값을 출력하시오.
		System.out.println("--- 4번 문제 정답 ---");
		int result_4 = 0;
		for(int idx = 0; idx <= dan8.length; idx ++) {
			if(idx == 4 || idx == 8) {
				result_4 += dan8[idx];
			}
		}
		System.out.println(result_4);

//		5. char [] alphabets = new char[52];
//		   char ch ='A';
//		   을 이용해서 alphabets배열에 문자를 A~Z z~a가지 저장하시오. 
		char [] alphabets = new char[52];
		char ch ='A';
		System.out.println("--- 5번 문제 정답 ---");
		for(int idx = 0; idx < alphabets.length; idx++) {
			if(idx < alphabets.length / 2) {
				alphabets[idx] = (char)(idx + ch);
				System.out.print(alphabets[idx] + " ");
			}
			else if(idx >= alphabets.length / 2 && idx < alphabets.length) {
				alphabets[idx] = (char)(ch + 57 - (idx - alphabets.length / 2));
				System.out.print(alphabets[idx] + " ");
			}
		}

		System.out.println();
//		6. 구구단을 다음 배열에 저장하시오.
//		int [][] array = new int[8][9];// 2 부터 구구단을 저장할 2차원 배열
		System.out.println("--- 6번 문제 정답 ---");
		int [][] array = new int[8][9];
		for(int rowIdx = 0; rowIdx < array.length; rowIdx++) {
			for(int colIdx = 0; colIdx < array[rowIdx].length; colIdx++) {
				array[rowIdx][colIdx] = (rowIdx+2) * (colIdx+1);
				System.out.println((rowIdx+2) + " * " + (colIdx+1) + " = " + array[rowIdx][colIdx]);
			}
		}
		
//		7. 구구단을 다음과 같이 출력하시오
//		2단 : [2,4,6,8,10,12,14,16,18]
//		3단 : [3,6,9,12,15,18,21,24,27]
//		4단 : [4,8,12,16,20,24,28,32,36]
//		5단 : 
//		6단 : 
//		7단 :
//		8단 :
//		9단 : 
		System.out.println("--- 7번 문제 정답 ---");
		int [][] array_7 = new int[8][9];
		for(int rowIdx = 0; rowIdx < array.length; rowIdx++) {
			System.out.print((rowIdx+2) + "단 : [");
			for(int colIdx = 0; colIdx < array[rowIdx].length; colIdx++) {
				array_7[rowIdx][colIdx] = (rowIdx+2) * (colIdx+1);
				System.out.print(array_7[rowIdx][colIdx]);
				if(array[rowIdx].length != colIdx + 1) {
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
//		8. 가변 2차원 배열을 이용해서
//		첫번째 행은 5단에서 1 ~ 3까지의 곱을 저장
//		두번재 행은 6단에서 1 ~ 6까지의 곱을 저장
//		세번째 행은 7단에서 1 ~ 9까지의 곱을 저장
		System.out.println("--- 8번 문제 정답 ---");
		int[][] a = new int[3][];
		int[] b = new int[3];
		int[] c = new int[6];
		int[] d = new int[9];
		
		for(int idx = 0; idx < b.length; idx++) {
			b[idx] = 5 * (idx+1);
		}
		for(int idx = 0; idx < c.length; idx++) {
			c[idx] = 6 * (idx+1);
		}
		for(int idx = 0; idx < d.length; idx++) {
			d[idx] = 7 * (idx+1);
		}
		a[0] = b;
		a[1] = c;
		a[2] = d;
		int idx = 0;
		for(int[] z : a) {
			System.out.print("a[" + idx +  "][n]의 값들 = ");
			for(int x : z) {
				System.out.print(x + " ");
			}
			idx++;
			System.out.println();
		}
		//9. 주어진 배열에서 최대값을 구하시오.
		System.out.println("--- 9번 문제 정답 ---");
		int max = 0;
		int [] array_9 = {1,5,3,8,2};
		for(int z : array_9) {
			if(z > max) {
				max = z;
			}
		}
		System.out.println("max : " + max);


		//10. 주어진 배열에 있는 요소들의 합과 평균을 구하시오.
		System.out.println("--- 10번 문제 정답 ---");
		int [][] array_10 = {{95,86},{83,92,96},{78,83,93,87,88}};
		int sum = 0;
		int arrayNum = 0;
		double avg = 0.0;
		
		for(int rowIdx = 0; rowIdx < array_10.length; rowIdx++) {
			for(int colIdx = 0; colIdx < array_10[rowIdx].length; colIdx++) {
				sum += array_10[rowIdx][colIdx];
				arrayNum++;
			}
		}
		System.out.println("sum : " + sum);
		avg = (double)sum / arrayNum;
		System.out.println("avg : " + avg);
	}
}