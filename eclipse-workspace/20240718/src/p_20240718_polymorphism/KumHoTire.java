package p_20240718_polymorphism;

public class KumHoTire extends Tire{

	public KumHoTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	public boolean roll() {
		accumulatedRotation++;
		if(maxRotation > accumulatedRotation) {
			System.out.println(location + "금호타이어 수명은 " + (maxRotation - accumulatedRotation) + "회");
			return true;
		}
		else {
			System.out.println(location + " 금호타이어 펑크");
			return false;
		}
	}
}
