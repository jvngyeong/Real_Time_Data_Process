package p_20240718_Array_Example;

import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		/*
		 * "양념", "후라이드", "순살"인 문자열 배열에 사용자가 입력한 값이 배열에 있는지
		 * 검색하여 있으면 "000 치킨 배달 가능", 없으면 "000 치킨은 없는 메뉴입니다"를 출력하세요.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요 = ");
		String chicken = sc.nextLine();
		boolean isExist = false;
		String[] chickens = new String[]{"양념", "후라이드", "순살"};
		for(int i = 0; i<chickens.length; i++) {
			if(chickens[i].equals(chicken)) {
				System.out.println(chickens[i] + "치킨 배달 가능");
				isExist = true; break;
			}
		}
		if(isExist == false) System.out.println(chicken + "치킨은 없는 메뉴입니다.");
	}
}
