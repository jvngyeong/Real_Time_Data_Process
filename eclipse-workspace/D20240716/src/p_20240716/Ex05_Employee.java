package p_20240716;

public class Ex05_Employee {
	//직원 번호
	String empNum;
	//직원 이름
	String empName;
	//직원 주소
	String empAddr;
	//직원 연락처
	String empPhone;
	//직원 성별
	char empGender;
	public Ex05_Employee() {}
	public Ex05_Employee(String empNum, String empName) {	//메서드의 이름이 같은 것을 오버로딩!!!!!
		this(empNum, empName, "서울", "010-1234-5678", 'M');
	}																			//오버로딩을 할 때, 매개변수의 타입이 같으면서 개수가 같으면 안됨
																				//적어도 순서가 다르거나 타입이 달라야함!
	public Ex05_Employee(String empAddr, String empPhone, char empGender) {		//메서드의 이름이 같은 것을 오버로딩!!!!!
		this("123456", "이숭무", empAddr, empPhone, empGender);
		//this 메서드 : 생성자 내에서 다른 생성자를 실행시킬 때 사용
	}
	
	public Ex05_Employee(String empNum, String empName, String empAddr, String empPhone, char empGender) {	//메서드의 이름이 같은 것을 오버로딩!!!!!
		this.empNum = empNum;
		this.empName = empName;
		this.empAddr = empAddr;
		this.empPhone = empPhone;
		this.empGender = empGender;
	}
}
