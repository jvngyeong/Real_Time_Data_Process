package p_20240718_Array_Example;

public class ArrayEx03 {

	public static void main(String[] args) {
		/*
		 * 길이가 5인 String 배열을 선언하고, "사과", "귤", "포도", "복숭아", "참외"로
		 * 초기화한 후, 배열 인덱스를 활용해서 글을 출력하세요.
		 */
		String[] a = new String[5];
		a[0] = "사과";
		a[1] = "귤";
		a[2] = "포도";
		a[3] = "복숭아";
		a[4] = "참외";
		
		for(String val : a) {
			System.out.println(val);
		}
		
		//포도까지만 출력하시오.
		for(String val : a) {
			System.out.println(val);
			if(val.equals("포도")) {
				break;
			}
		}
	}

}
