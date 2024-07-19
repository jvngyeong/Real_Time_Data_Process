package p_20240716;

public class Ex04 {

	public static void main(String[] args) {
		Ex04_Employee emp = new Ex04_Employee("123", "이상범");
		System.out.println(emp.empNum);
		System.out.println(emp.empName);
		System.out.println(emp.empPhone);
		System.out.println(emp.empAddr);
		System.out.println(emp.empGender);
		
		Ex04_Employee emp1 = new Ex04_Employee("구로", "012-3456-7890", 'M');
		System.out.println(emp1.empNum);
		System.out.println(emp1.empName);
		System.out.println(emp1.empPhone);
		System.out.println(emp1.empAddr);
		System.out.println(emp1.empGender);
	}

}
