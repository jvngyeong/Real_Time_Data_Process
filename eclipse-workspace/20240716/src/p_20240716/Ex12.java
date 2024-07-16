package p_20240716;

public class Ex12 {

	public static void main(String[] args) {
		//학생을 5명
		Ex12_Student st1 = new Ex12_Student(100001, "학생1", 1, "서울1");
		int i1 = 10;
		int i2 = 20;
		int i3 = 30;
		int i4 = 40;
		int[] i = new int[4];
		i[0] = 10;
		i[1] = 20;
		i[2] = 30;
		i[3] = 40;
		
		Ex12_Student[] Students = new Ex12_Student[3];
		Students[0] = new Ex12_Student(100001, "학생1", 1, "서울1");
		Students[1] = new Ex12_Student(100001, "학생2", 2, "서울2");
		Students[2] = new Ex12_Student(100001, "학생3", 3, "서울3");
		for(Ex12_Student obj : Students) {
			obj.print();
		}
	}

}
