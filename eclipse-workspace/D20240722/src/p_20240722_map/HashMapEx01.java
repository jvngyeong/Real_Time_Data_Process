package p_20240722_map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapEx01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		//1. 선언
		Map<Integer, String> map = new HashMap<Integer, String>();
		//2. 저장
		map.put(1, "이숭무");
		map.put(10, "이상범");
		map.put(3, "이장범");
		map.put(20, "김찬중");
		map.put(20, "이상희");
		System.out.println(map);
		//3. 수정
		map.put(1, "이준경");
		map.replace(1, "이숭무");
		//4. 요소 출력
		System.out.println(map.get(1));
		
		//5. 키 값 가져오기
		for(int key : map.keySet()) {
			System.out.println(key);
		}
		//6. 밸류 가져오기
		System.out.println(map.values());
		Collection<String> val = (Collection<String>)map.values();
		
		//7. 크기
		System.out.println(map.size());
		
		//8. 삭제
		map.remove(1);
		map.remove(10, "이상범");
		System.out.println(map);
		
		//9. 모두 삭제
		map.clear();


	}
}
