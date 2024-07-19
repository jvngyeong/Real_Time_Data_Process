package p_20240715;

public class Ex05 {

	public static void main(String[] args) {
		Ex05_Board board = new Ex05_Board();
		board.setData(1, "1번 제목", "1번 내용", "이준경");
		board.print();
		Ex05_Board board2 = new Ex05_Board();
		board2.setData(2, "2번 재목", "2번 내용", "이준경2");
		board2.print();
		//board2.subject = "2번 제목";	subject가 private이기 때문에 불가능
		board2.setSubject("2번 제목");
		board2.print();
		int num = board2.getNum();
	}
}
