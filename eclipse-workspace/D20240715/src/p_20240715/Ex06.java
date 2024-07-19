package p_20240715;

public class Ex06 {

	public static void main(String[] args) {
		Ex06_Person p = new Ex06_Person();
		p.setData("이준경", "01049051500", "서울", 22, 175.0, true);
		p.print();
		System.out.println(p.isGender());
	}

}
