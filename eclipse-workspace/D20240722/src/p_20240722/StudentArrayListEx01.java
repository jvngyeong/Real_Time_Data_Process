package p_20240722;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayListEx01 {

	public static void main(String[] args) {
		Student[] stu = new Student[3];
		stu[0] = new Student(10001, "이준경1", 176.5, true, 100);
		stu[1] = new Student(10002, "이준경2", 176.5, true, 100);
		stu[2] = new Student(10003, "이준경3", 176.5, true, 100);
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(10001, "이준경1", 176.5, true, 110));
		list.add(new Student(10002, "이준경2", 176.4, true, 120));
		list.add(new Student(10003, "이준경3", 176.3, true, 130));
		list.add(new Student(10004, "이준경4", 176.2, true, 140));
		
		list.set(0, new Student(10001, "이준경1", 176.5, true, 100));
		System.out.println(list.size());
		Student stuPop = list.remove(0);
		System.out.println(stuPop.getStudentName());
		list.clear();
		
		for(Student s : list) {
			s.getStudentName();
		}
	}
}
