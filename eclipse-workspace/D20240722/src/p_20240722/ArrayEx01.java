package p_20240722;

public class ArrayEx01 {

	public static void main(String[] args) {
		//변수 : 하나의 값만을 저장
		//배열 : 하나 이상의 값을 저장
		//		단점 : 하나의 타입만 저장 가능
		//				크기가 정해져 있음
		//calss : 여러 개의 타입을 저장 가능
		
		String str1 = "이숭무";
		String str2 = "이상범";
		String str3 = "이장범";
		String[] str = new String[3];
		//index: 배열에 있는 요소가 가지는 고유의 번호
		str[0] = "이숭무";
		str[1] = "이상범";
		str[2] = "이장범";
		System.out.println(str1);
		System.out.println(str[0]);
		//배열의 크기 : 요소의 갯수
		System.out.println(str.length);
		//배열 안에 있는 요소의 값을 출력
		for(String s : str) {
			System.out.println(s);
		}
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

}
