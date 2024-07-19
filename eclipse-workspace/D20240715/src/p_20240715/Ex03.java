package p_20240715;

public class Ex03 {

	public static void main(String[] args) {
		Ex03_Student st = new Ex03_Student();
		st.name = "이준경_Ex03";
		Ex03_Student st1 = new Ex03_Student();
		//호출 메서드	: 인자 : 실인자 : arguments
		st1.setData("이준경", "서울", 20211008, 22, 90, 175, true);
		st1.print();
	}
}
