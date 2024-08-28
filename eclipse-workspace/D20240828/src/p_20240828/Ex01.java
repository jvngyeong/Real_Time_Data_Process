package p_20240828;

public class Ex01 {

	public static void main(String[] args) {
		char[] ch = new char[26];
		ch[0] = 65;
		ch[1] = 'B';
		
		// 반복문을 이용해서 대문자를 저장
		for(int idx = 65; idx<ch.length + 65; idx++) {
			ch[idx-65] = (char)idx;
		}
		for(char c : ch) {
			System.out.println(c);
		}
		// 소문자
		ch[0] = 'A' + 32;
		System.out.println(ch[0]);
		
		for(int idx = 65; idx<ch.length+65; idx++) {
			ch[idx-65] = (char)(idx+32);
		}
		for(char c : ch) {
			System.out.println(c);
		}
	}
}
