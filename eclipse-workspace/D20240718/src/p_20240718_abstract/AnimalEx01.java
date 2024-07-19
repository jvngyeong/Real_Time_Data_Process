package p_20240718_abstract;

public class AnimalEx01 {
	public static void main(String[] args) {
		Eagle eagle = new Eagle();
		eagle.move();
		Tiger tiger = new Tiger();
		tiger.move();
		Animal a = new Eagle();
		a.move();
		a = new Tiger();
		a.move();
	}
}
