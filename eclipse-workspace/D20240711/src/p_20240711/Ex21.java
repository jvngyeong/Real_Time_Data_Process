package p_20240711;

public class Ex21 {

	public static void main(String[] args) {
		/*
		   변수의 장점 : 값을 바꿀 수 있다.
		   변수의 단점 : 하나의 값만 저장할 수 있다.
		   
		   배열의 장점 : 여러 값을 저장할 수 있다.
		   배열의 단점 : 하나의 데이터 타입만 저장할 수 있다.
		 */
		Student student = new Student(); // 클래스 객체 생성
		student.name = "이준경";
		student.age = 22;
		student.gender = true;
		student.height = 175.0;
		student.studentNum = 20211008;
		int i = 10;
		System.out.println(i);
		System.out.println(student.name);
		System.out.println(student.age);
		System.out.println(student.gender);
		System.out.println(student.height);
		System.out.println(student.studentNum);
		Student student1 = new Student(); // 클래스 객체 생성
		student1.name = "김찬중";
		System.out.println(student.name);
		System.out.println(student1.name);
	}

}
