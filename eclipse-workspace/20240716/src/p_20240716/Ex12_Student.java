package p_20240716;

public class Ex12_Student {
	int studentID;
	String studentName;
	int grade;
	String address;
	
	public Ex12_Student() {}
	public Ex12_Student(int studentID, String studentName, int grade, String address) {
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
