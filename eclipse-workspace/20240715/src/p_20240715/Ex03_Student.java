package p_20240715;

public class Ex03_Student {
	//멤버 필드, 멤버 변수
	String name;
	String addr;
	int studentNum;
	int age;
	int grade;
	double height;
	boolean gender;
	
	//피호출 메서드, 매개변수 : 가인자 : parameter
	public void setData(String name, String addr, int studentNum, int age, int grade, double height, boolean gender) {
		this.name = name;				//this.을 써서 앞의 변수가 멤버변수라는 것을 알림.
		this.addr = addr;
		this.studentNum = studentNum;
		this.age = age;
		this.grade = grade;
		this.height = height;
		this.gender = gender;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(addr);
		System.out.println(studentNum);
		System.out.println(age);
		System.out.println(grade);
		System.out.println(height);
		System.out.println(gender);
	}
}