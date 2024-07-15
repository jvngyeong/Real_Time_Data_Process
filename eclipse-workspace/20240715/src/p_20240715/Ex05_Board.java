package p_20240715;

public class Ex05_Board {
	//캡슐화를 함으로써 멤버들을 은닉시킬 수 있다.
	//접근지정자 : 엑세스를 할 수 있도록 하는 권한
	private int num;
	private String subject;
	private String contents;
	private String writer;
	
	// setter : 은닉멤버를 액세스하여 값을 저장하기 위해 사용
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public void setwriter(String writer) {
		this.writer = writer;
	}
	public void setData(int num, String subject, String contents, String writer) {
		this.num = num;
		this.subject = subject;
		this.contents = contents;
		this.writer = writer;
	}
	//getter
	public int getNum() {		//피호출 메서드
		return num;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getContents() {
		return contents;
	}
	public void print() {
		System.out.println(num);
		System.out.println(subject);
		System.out.println(contents);
		System.out.println(writer);
	}
}
