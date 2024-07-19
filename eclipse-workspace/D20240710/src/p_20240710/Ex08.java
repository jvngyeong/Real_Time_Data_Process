package p_20240710;

public class Ex08 {

	public static void main(String[] args) {
		// 반복문 : for, while
		//		: 반복하고싶은 명령문이 있을 때 사용함.
		for(int i = 1; i <= 10; i++) {
			System.out.println("나무를 " + i + "번 찍었습니다.");
		}
		System.out.println("나무가 쓰러졌습니다!");
		
		for(int i = 0, j = 1; i<=9; i++, j++) {
			System.out.println("나무를 " + j + "번 찍었습니다.");
		}
		System.out.println("나무가 쓰러졌습니다!");
	}
}
