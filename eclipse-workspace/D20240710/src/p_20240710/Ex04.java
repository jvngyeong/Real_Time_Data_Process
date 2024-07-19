package p_20240710;

public class Ex04 {

	public static void main(String[] args) {
		// switch
		char gender = 'M';
		if(gender == 'M') {
			System.out.println("남자입니다.");
		}
		else if(gender == 'F') {
			System.out.println("여자입니다.");
		}
		switch(gender) {
		case'M' : System.out.println("남자입니다."); break;
		case'F' : System.out.println("여자입니다."); break;
		}
		
		switch(gender) {
		case'M' : System.out.println("남자입니다."); break;
		// switch ~ case문의 default는 else와 같다.
		default : System.out.println("여자입니다."); break;
		}
		
		switch(gender) {
		//default가 위에 있어도 상관없음.
		default : System.out.println("여자입니다."); break;
		case'M' : System.out.println("남자입니다."); break;
		}
	}
}
