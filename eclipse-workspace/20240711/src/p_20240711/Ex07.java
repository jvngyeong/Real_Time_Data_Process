package p_20240711;

public class Ex07 {

	public static void main(String[] args) {
		char[] ch = {'A', 'B', 'C'};
		char[] ch1 = new char[] {'A', 'B', 'C'};
		char[] ch2 = new char[26];	//"" 저장(Blank)
		
		for(int idx = 0; idx < ch2.length; idx++) {
			ch2[idx] = (char)(idx+65);
			System.out.println(ch2[idx]);
		}
		char character = 'A';		//65
		for(int idx = 0; idx < ch2.length; idx++, character++) {
			ch2[idx] = character;
			System.out.println(ch2[idx]);
		}
		//소문자
		for(int idx = 0; idx < ch2.length; idx++) {
			ch2[idx] = (char)(idx+65+32);
			System.out.println(ch2[idx]);
		}
	}

}
