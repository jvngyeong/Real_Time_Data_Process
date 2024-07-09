package Day2;

public class Ex8 {

	public static void main(String[] args) {
		// 증가감 연산자의 선행 / 후행
		int i = 1;
		i++;	// i = 2
		System.out.println(i);
		++i;	// i = 3
		System.out.println(i);
		
		System.out.println(i = i + 1);	// i = 4
		System.out.println(i++);	//후행	// i = 5지만, 출력부터 한 후에 더해짐
		System.out.println(++i);	//선행	// i = 6
		
		int result;
		result = i++;	//result에는 6이 대입되고, 대입한 후에 i에 1이 더해짐.
		System.out.println(result);
		System.out.println(i);
		result = ++i;
		System.out.println(result);
		System.out.println(i);
	}
}
