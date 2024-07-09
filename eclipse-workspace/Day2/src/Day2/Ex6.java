package Day2;

public class Ex6 {

	public static void main(String[] args) {
		String str1, str2;
		str1 = "Hello";
		str2 = "Java";
		// 문자열에서 + 연산자는 연결 연산자.
		System.out.println(str1 + str2);
		System.out.println(str1 + " " + str2);
		int i, j;
		i = 10;
		j = 20;
		System.out.println(str1 + i + j);	//println에서의 + 연산자의 역할은 문자열 연결. 때문에 문자열 연결이 수행됨.
		System.out.println(str1 + (i + j));
	}
}