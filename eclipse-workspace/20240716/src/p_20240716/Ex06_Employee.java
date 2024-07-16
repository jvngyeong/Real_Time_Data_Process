package p_20240716;

public class Ex06_Employee {
	String empNum;
	String empName;
	String empAddr;
	String empPhone;
	char empGender;
	public Ex06_Employee() {}
	public Ex06_Employee(String empAddr, String empPhone, char empGender) {
		this.empAddr = empAddr;
		this.empPhone = empPhone;
		this.empGender = empGender;
	}
	public Ex06_Employee(String empNum, String empName) {
		this("서울", "010-0101-0101", 'M');
		this.empNum = empNum;
		this.empName = empName;
	}
}
