package Day2;

public class Ex9 {

	public static void main(String[] args) {
		// 대입연산자. =
		int i = 10;
		i = 20;
		System.out.println(i);	
		i = i + 1;
		i++;
		++i;
		i += 1;	// 대입연산자
		System.out.println(i);
		i = i + 2;
		i += 2;
		i = i + 3;
		i += 3;
		System.out.println(i);
		
		i = i - 1;
		--i;
		i -= 1;
		i = i - 3;
		i -= 3;
		System.out.println(i);
		
		i *= 2;
		System.out.println(i);
		
		i /= 4;
		System.out.println(i);
		
		i %= 3;
		System.out.println(i);
		/*
		 * +=, -=, *=. /=, %= 피연산자가 산술연산자에서 사용가능.
		 */
	}
}
