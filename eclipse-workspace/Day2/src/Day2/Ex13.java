package Day2;

public class Ex13 {

	public static void main(String[] args) {
		/*
		 제어문 :
		 	조건문 : if, switch
		 	반복문 : for, while, do ~ while
		 조건문 :
		   if(조건식){
		   	 명령어
		   }
		   조건식에는 bool 타입인 결과가 오는 식이나 값이어야 한다.
		   ex)
		   		if(true)
		   		if(a > b)
		   명령어는 조건식의 결과값이 true일 때 실행할 코드 작성.
		 */
		
		//if문 예제 1
		int money = 1000;
		//버스를 타려면 1450원이 있어야 한다.
		if(money >= 1450) {
			System.out.println("버스를 타고 가세요.");
		}
		//if문 예제 2
		int age = 8;
		if(age >= 7) {
			System.out.println("학교에 다녀요.");
		}
		//if문 예제 3
		int eng = 60;
		int kor = 70;
		int mat = 50;

		if(eng >= 60) {
			System.out.println("Pass");
		}
		if(kor >= 60) {
			System.out.println("Pass");
		}
		if(mat >= 60) {
			System.out.println("Pass");
		}
	}
}
