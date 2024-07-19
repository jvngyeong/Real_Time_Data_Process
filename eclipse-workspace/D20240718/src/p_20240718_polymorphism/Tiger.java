package p_20240718_polymorphism;

public class Tiger extends Animal{
	@Override
	public void move() {
		System.out.println("호랑이가 움직입니다.");
	}
	public void hunting() {
		System.out.println("호랑이가 사냥합니다.");
	}
}
