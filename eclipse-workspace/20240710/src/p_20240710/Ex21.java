package p_20240710;

public class Ex21 {

	public static void main(String[] args) {
		// 1 ~ 100까지의 합을 구할 때 홀수의 합만 구하시오.
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 != 0) {
				result1 += i;
			}
		}
		System.out.println(result1);
		
		int i = 1;
		while(true) {
			if(i % 2 != 0) {
				result2 += i;
			}
			i++;
			if(i == 100) {
				break;
			}
		}
		System.out.println(result2);
		
		int j = 0;
		while(true) {
			if(j >= 100) {
				break;
			}
			j++;
			if(j % 2 == 0) {
				continue;
			}
			result3 += j;
		}
		System.out.println(result3);
	}
}
