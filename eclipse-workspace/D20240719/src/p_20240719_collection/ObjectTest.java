package p_20240719_collection;

public class ObjectTest {

	public static void main(String[] args) {
		Book book = new Book("산울림", "이숭무");
		book.getAuthor();
		new Book("산울림", "이숭무").getAuthor();	//일회성
	}
}
