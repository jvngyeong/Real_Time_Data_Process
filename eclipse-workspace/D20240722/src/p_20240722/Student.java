package p_20240722;

import java.io.Serial;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
//멤버를 초기화하기 위해서 생성자
@AllArgsConstructor
@NoArgsConstructor
//Setter, Getter
@Setter
@Getter
public class Student {	//캡슐화 
	//변수 : 하나의 값만 저장
	//배열 : 하나 이상의 값을 저장
	//		크기가 고정적임
	//		하나의 타입만 저장 가능
	int studentNum;
	String studentName;
	double height;
	boolean gender;
	int grade;
	//메서드
	public void print() {
		System.out.println(studentName);
	}
}
