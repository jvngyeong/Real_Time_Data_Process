package p_20240710;

public class Ex11 {

	public static void main(String[] args) {
		//1부터 5까지의 합을 구하시오.
		int j = 1;
		int sum = 0;
		sum = sum + j++;
		sum = sum + j++;
		sum = sum + j++;
		sum = sum + j++;
		sum = sum + j++;
		System.out.println(sum);
		
		//1부터 100까지의 합을 구하시오.
		int result = 0;
		for(int i = 1; i<=100; i++) {
			result += i;
		}
		
		System.out.println(result);
	}

}
