package p_20240719_collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx05 {

	public static void main(String[] args) {
		//선언
		List<Book> list = new ArrayList<Book>();
		//저장
		list.add(new Book("책1", "저자1"));
		list.add(new Book("책2", "저자2"));
		//수정
		list.set(0, new Book("1책", "1저자"));
		//출력
		System.out.println(list.get(1).getAuthor());
		String str = list.get(1).getAuthor();
		System.out.println(str);
		
		Book book = list.get(1);
		System.out.println(book.getAuthor());
		System.out.println(list.get(1).getAuthor());
		//모두 출력
		System.out.println(list);
		//크기
		System.out.println(list.size());
		//삭제
		list.remove(0);
		for(int idx = 0; idx < list.size(); idx++) {
			if(list.get(idx).getAuthor().equals("이숭무")) {
				list.remove(idx);
				break;
			}
		}
		//모두 삭제
		list.clear();
		//반복문
		for(Book b : list) {
			b.print();
		}
	}

}
