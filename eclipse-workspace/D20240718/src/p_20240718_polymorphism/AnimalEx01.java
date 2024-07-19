package p_20240718_polymorphism;

public class AnimalEx01 {

	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.move();
		Human h = new Human();
		h.move();
		
		Animal animal = new Eagle();
		animal.move();
		animal = new Human();
		animal.move();
		animal = new Tiger();
		animal.move();
		animal = new Eagle();
		animal.move();

		Eagle eagle = (Eagle)animal;	//강제 형변환 (캐스팅, Casting) | Animal 타입인 animal을 Eagle 타입으로 강제 형변환
		eagle.flying();
		
		animal = new Human();
		Human ex01 = (Human)animal;
		ex01.readBook();
	}

}
