package p_20240717;

public class LoopEx1 {

	public static void main(String[] args) {
		System.out.println("나무를 1번 찍었습니다.");
		//...
		System.out.println("나무를 10번 찍었습니다.");
		
		for(int i = 1; i <= 10; i++) {
			System.out.println("나무를 " + i + "번 찍었습니다.");
		}
		
		int i = 0;
		int start = 1;
		while(i<10) {
			System.out.println("나무를 " + start + "번 찍었습니다.");
			i++;
			start++;
		}
	}

}
