package p_20240722;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx01 {

	public static void main(String[] args) {
		// 변수 : 하나의 값만 저장
		// 배열 : 하나 이상의 값을 저장
		//		 크기가 고정
		// 컬렉션 : 하나 이상의 값을 저장
		//		  크키가 유동적. : list(ArrayList), set
		//						[][][][][][]
		int[] i = new int[2];
		i[0] = 10;
		i[1] = 20;
		//i[2] = 30;	크기가 고정이기 때문에 오류
		//List의 선언
		List<Integer> intList = new ArrayList<Integer>();
		//List에 값 저장(add)
		intList.add(10);	//0
		intList.add(20);	//1
		intList.add(30);	//2
		//List 수정(set)
		intList.set(0, 11);
		intList.set(1, 22);
		intList.set(2, 33);
		//List 출력(print(리스트.get(인덱스))
		System.out.println(intList.get(0));
		System.out.println(intList.get(1));
		System.out.println(intList.get(2));
		//모두 출력(리스트의 변수명 적어주기)
		System.out.println(intList);
		//크기 출력
		System.out.println(intList.size());
		//요소 삭제(remove(인덱스))
		intList.remove(0);
		//intList.remove("10"); // 정수는 값으로 삭제할 수 없음.
		System.out.println(intList);
		//요소의 값을 받아오면서 삭세
		int pop = intList.remove(0);
		System.out.println(pop);
		System.out.println(intList);
		//모두 삭제
		intList.clear();
		System.out.println(intList);
		
	}

}
