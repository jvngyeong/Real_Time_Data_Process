package p_20240715;

public class Ex02 {

	public static void main(String[] args) {
		// 변수 단점 : 하나의 값만 저장 가능 / 정해진 타입만 저장 가능
		// 배열 장점 : 하나 이상의 값을 저장 가능
		// 배열 단점 : 크기가 고정 / 정해진 타입만 저장 가능
		// class : 하나 이상의 값을 저장할 수 있고, 여러 타입의 값을 저장 가능함
		int i = 10; //정수 리터럴 변수
		Ex02_Student st = new Ex02_Student();	//st : Class 변수
		//			 new Student(); // 객체 생성,	st는 객체를 저장하고 있는 변수(객체 변수)
		st.name = "이준경";
		st.age = 22;
		st.studentNum = 20211008;
		st.addr = "Seoul";
		System.out.println(st.name);
		
		int i1 = 20;
		Ex02_Student st1 = new Ex02_Student();
		st1.name = "이준경123";
		System.out.println(st1.name);
	}

}
