package p_20240709;

public class Ex07 {

	public static void main(String[] args) {
		// 증가감 연산자
		int result, i;
		i = 1;
		result = i + 1; 
		System.out.println(result);
		result = result + 1;
		System.out.println(result);
		result = result + 1;
		System.out.println(result);
		result++;	//result = result + 1;과 같음 / 하지만 변수의 값을 사용한 후에, 1을 더해줌.
		System.out.println(result);
		result++;
		System.out.println(result);
		++result;   //result = result + 1;과 같음 / 변수의 값을 사용하기 전에 1을 먼저 더해줌.
		
		result = result - 1;
		System.out.println(result);
		result--;	//result = result - 1;과 같음 / 하지만 변수의 값을 사용한 후에, 1을 빼줌.
		System.out.println(result);
		--result;	//result = result - 1;과 같음 / 변수의 값을 사용하기 전에 1을 먼저 빼줌.
		System.out.println(result);
	}
}
