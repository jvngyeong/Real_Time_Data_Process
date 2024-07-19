package p_20240715;

public class Ex08_Board {
	int num;
	String subject;
	String contents;
	String writer;
	// 생성자가 정의되지 않은 경우 기본 생성자 존재
	// public Ex08_Board(){}	-> 클래스 이름과 같은 메서드!!
	// 멤버를 초기화하기 위해서 생성자를 사용
	public Ex08_Board(int num, String subject, String contents, String writer) {
		this.num = num;
		this.subject = subject;
		this.contents = contents;
		this.writer = writer;
	}
	// 생성자를 정의하면 기본 생성자는 존재하지 않는다.
	// 기본생성자를 정의해줘야 함. (오버로딩으로 !!)
	public Ex08_Board() {}
	
	public void print() {
		System.out.println(num);
		System.out.println(subject);
		System.out.println(contents);
		System.out.println(writer);
	}
}
