package p_20240715;

public class Ex04 {

	public static void main(String[] args) {
		Ex04_Board board = new Ex04_Board();
		board.setData(1, "04번 예제 제목입니다.", "04번 예제 내용입니다.", "이준경");
		board.print();
		Ex04_Board board1 = new Ex04_Board();
		board1.setData(2, "04번 예제 재목2 입니다.", "04번 예제 내용2 입니다.", "이준경2");
		board1.print();
		board1.setSubject("04번 예제 제목2 입니다.");
		board1.print();
	}

}
