package p_20240716;

public class Ex11_Student {
	static int serialNum;
	static int num1;
	
	int studentID;
	String studentName;
	int grade;
	String address;
	
	static {		//static 블럭, static 변수의 초기값을 주기 위해 사용
		serialNum = 100000;
		//studentID = 1000; 	//멤버 변수는 사용 불가능. 
		//num1 = 10000;
		setNum1();	//static 블럭에서는 static 메서드 또한 실행 가능하다
	}
	public static void setNum1() {
		num1 = 10000;
		//studentID = 1000; 	//멤버 변수는 사용 불가능. 
	}
	public Ex11_Student() {}
	public Ex11_Student(int studentID, String studentName, int grade, String address) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.address = address;
	}
	public void print() {
		System.out.println(studentID);
		System.out.println(studentName);
		System.out.println(grade);
		System.out.println(address);
	}
}
