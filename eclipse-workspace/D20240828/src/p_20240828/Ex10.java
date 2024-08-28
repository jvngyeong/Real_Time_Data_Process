package p_20240828;

public class Ex10 {

	public static void main(String[] args) {
		int i[] = new int[3];
		i[0] = 10;
		i[1] = 20;
		i[2] = 30;
		String str0 = "이숭무";
		String str1 = "이상범";
		String str2 = "이장범";
		//객체(문자열) 배열
		String str[] = new String[3];
		str[0] = str0;
		str[1] = str1;
		str[2] = str2;
		
		Inquire inq0 = new Inquire(1, "제목", "배송", "내용", "답변");
		Inquire inq1 = new Inquire(2, "제목", "배송", "내용", "답변1");
		Inquire inq2 = new Inquire(3, "제목", "배송", "내용", "답변2");
		//객체 배열
		Inquire[] inq = new Inquire[3];
		
		inq[0] = new Inquire(1, "제목", "배송", "내용", "답변");
		inq[1] = new Inquire(2, "제목", "배송", "내용", "답변1");
		inq[2] = new Inquire(3, "제목", "배송", "내용", "답변2");
		
		for(Inquire aaa : inq) {
			System.out.println(aaa);
		}
	}
}
