package p_20240722_wrapper;

public class StringEx01 {
	public static void main(String[] args) {
		// 리터럴 : 정수, 실수, 문자, 부울, 문자열
		// 비지니스 타입 : int, double, float, char, boolean
		String str1 = "이상범";
		String str2 = "이상범";
		if(str1 == str2) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
		String str = new String("이상범");
	}
}
