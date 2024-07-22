package p_20240722;

public class StudentArrayEx01 {
	public static void main(String[] args) {
		int i1 = 10;
		int i2 = 20;
		int i3 = 30;
		int[] i = new int[3];	//배열 생성
		i[0] = i1;
		i[1] = i2;
		i[2] = i3;
		
		Student stu1 = new Student(10001, "이준경1", 176.5, true, 100);
		Student stu2 = new Student(10002, "이준경2", 176.5, true, 100);
		Student stu3 = new Student(10003, "이준경3", 176.5, true, 100);
		Student[] stu = new Student[3];
		stu[0] = stu1;
		stu[1] = stu2;
		stu[2] = stu3;
		System.out.println(stu[0].getStudentNum());
		stu[0].setGender(true);
		
	}
}
