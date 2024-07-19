package p_20240719_collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx01 {

	public static void main(String[] args) {
		// 변수 단점 : 하나의 값만 저장한다.
		// 배열 장점 : 하나 이상의 값을 저장.
		// 배열 단점 : 크기를 변경할 수 없다.
		// 이 떄문에 만들어진 것이 Collection : list, set
		// 장점 : 크기가 유동적이다.
		// 단점 : 하나의 타입만 가능.
		int[] i = new int[4];
		String str[] = new String[3];
		str[0] = "이숭무";
		str[1] = "이상범";
		str[2] = "이장범";
		System.out.println(str.length);
		List<String> list = new ArrayList<String>();
		list.add("이숭무");
		list.add("이상범");
		list.add("이장범");
		list.add("이장범");	// 데이터 중복 허용
		System.out.println(list.size());
		for(String val : str) {
			System.out.println(val);
		}
		for (String val : list) {
			System.out.println(val);
		}
		System.out.println(str[0]);
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println(list.size());
		list.remove("이장범");	// 중복되는 값이 있을 때, 하나만 삭제됨.
		System.out.println(list.size());
		for (String val : list) {
			System.out.println(val);
		}
		list.clear();
		for (String val : list) {
			System.out.println(val);
		}
	}

}
