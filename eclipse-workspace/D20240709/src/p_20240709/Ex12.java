package p_20240709;

public class Ex12 {

	public static void main(String[] args) {
		int year = 2200;
		boolean result;
		
		result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		
		System.out.println(result);
		
		
		//if문으로 구현-1
		if(result) {
			System.out.println("윤년");
		}
		else {
			System.out.println("평년");
		}
		
		//if문으로 구현-2
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println("윤년");
		}
		else {
			System.out.println("평년");
		}
		
		String str;
		str = result ? "윤년" : "평년";	//삼항연산자 or 조건연산자
		System.out.println(str);
		str = year % 4 == 0 && year % 100 != 0 || year % 400 == 0
				 ? "윤년" : "평년";
		System.out.println(str);
		int num = 10;
		
		num = result ? 10+5 : 10-5;
		System.out.println(num);
		}
}
