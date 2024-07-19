package p_20240718_polymorphism;

public class Tire {
	int maxRotation;	//최대 회전
	int accumulatedRotation; //현재 회전 수
	String location;

	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	public boolean roll() {
		accumulatedRotation++;
		if(maxRotation > accumulatedRotation) {
			System.out.println(location + "Tire 수명은 " + accumulatedRotation + "회");
			return true;
		}
		else {
			System.out.println(location + " Tire 펑크");
			return false;
		}
	}
}
