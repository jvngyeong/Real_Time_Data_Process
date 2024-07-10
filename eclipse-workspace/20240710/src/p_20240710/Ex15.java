package p_20240710;

public class Ex15 {

	public static void main(String[] args) {
		// while문
		System.out.println("나무를 1번 찍었습니다.");
		for(int i = 1; i<=10; i++) {
			System.out.println("나무를 " + i + "번 찍었습니다.");
		}
		
		int i = 1;
		for(;i<=10;) {
			System.out.println("나무를 " + i + "번 찍었습니다.");
			i++;
		}
		while(i<=10) {
			System.out.println("나무를 " + i + "번 찍었습니다.");
			i++;
		}
	}
}
