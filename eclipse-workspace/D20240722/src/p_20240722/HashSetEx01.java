package p_20240722;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx01 {

	public static void main(String[] args) {
		// list 비슷 : 배열처럼 요소들을 젖아
		// 			순서가 있음 : Index를 가지고 있다.
		// set : 집합
		// 순서가 없음 : Index를 가지고 있지 않다.
		//1. 선언
		Set<String> set = new HashSet<String>();
		//2. 더하기
		set.add("이준경");
		set.add("이준경2");
		set.add("이준경3");
		//3. 출력
		System.out.println(set);
		//4. 크기
		System.out.println(set.size());
		//5. 문자열 변환
		String s = set.toString();
		System.out.println(s);
		//6. 데이터 유무
		System.out.println(set.contains("이준경1"));
		System.out.println(set.contains("이준경2"));
		//7. 삭제
		set.remove("이준경");
		System.out.println(set);
		//8. 모두 삭제
		set.clear();
		System.out.println(set);
	}

}
