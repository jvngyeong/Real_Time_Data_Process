package p_20240715;

public class Ex10 {

	public static void main(String[] args) {
		Ex10_QnA qna = new Ex10_QnA();
		qna.setInquireNum(1);
		qna.setInquireKind("상담종류1");
		qna.setInquireSuject("상담주제1");
		qna.setInquireContent("상담내용1");
		qna.setInquireDate("상담일1");
		qna.setInquireAnswer("답변1");
		qna.setInquireAnswerDate("답변일1");
		
		System.out.println(qna.getInquireNum());
		System.out.println(qna.getInquireKind());
		System.out.println(qna.getInquireSubject());
		System.out.println(qna.getInquireContent());
		System.out.println(qna.getInquireDate());
		System.out.println(qna.getInquireAnswer());
		System.out.println(qna.getInquireAnswerDate());
	}

}
