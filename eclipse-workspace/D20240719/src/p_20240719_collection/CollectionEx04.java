package p_20240719_collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx04 {

	public static void main(String[] args) {
		int i1 = 10;
		int i2 = 20;
		int[] i = new int[2];
		i[0] = i1;
		i[1] = i2;
		Book b1 = new Book("태백산맥", "이숭무");
		Book b2 = new Book("무궁화꽃이 피었습니다.", "이상범");
		Book[] b = new Book[2];
		b[0] = b1;
		b[1] = b2;
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		List<Book> list2 = new ArrayList<Book>();
		list2.add(b1);
		list2.add(b2);
		b[0].getAuthor();
		list2.get(0).getAuthor();
	}

}
