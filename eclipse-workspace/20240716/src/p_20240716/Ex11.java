package p_20240716;

public class Ex11 {

	public static void main(String[] args) {
		Ex11_Student st1 = new Ex11_Student(++Ex11_Student.serialNum, "학생1", 4, "서울");
		
		Ex11_Student st2 = new Ex11_Student(++Ex11_Student.serialNum, "학생2", 3, "서울");
		
		Ex11_Student st3 = new Ex11_Student(++Ex11_Student.serialNum, "학생3", 2, "경기");
		
		st1.print();
		st2.print();
		st3.print();
	}

}
