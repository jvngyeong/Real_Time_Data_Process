package p_20240722;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx02 {

	public static void main(String[] args) {
		//1. 선언
		List<String> list = new ArrayList<String>();
		//2. 저장
		list.add("0번 인덱스");
		list.add("1번 인덱스");
		list.add("2번 인덱스");
		//3. 출력
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		//4. 수정
		list.set(2, "2번 인덱스 입니다.");
		System.out.println(list.get(2));
		//5. 크기
		System.out.println(list.size());
		//6. 삭제
		System.out.println(list.remove(0));
		System.out.println(list);
		//7. pop : 값을 반환받으면서 삭제
		String pop = list.remove(0);
		System.out.println(pop);
		System.out.println(list);
		//8. 모두 출력
		System.out.println(list);
		for(String s : list) {
			System.out.println(s);
		}
		//9. 문자열 변환
		String result = list.toString();
		System.out.println(result);
		//10. 모두 삭제
		list.clear();
	}
}
