package board.command;

public class BoardCommand {
	String boardWriter;
	String boardSubject;
	String boardContent;
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
}

/*
 * dto == Table의 Column들과 같다.
 * request.getParameter("input의 Name")
 * request == command
 * command의 멤버 변수들은 input의 Name과 같아야 한다!!
 */
