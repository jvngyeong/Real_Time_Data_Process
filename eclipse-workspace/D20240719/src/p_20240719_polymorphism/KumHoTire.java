package p_20240719_polymorphism;

public class KumHoTire implements Tire{
	int maxRotation;	//최대 회전
	int accumulatedRotation; //현재 회전 수
	String location;	//타이어의 위치
	
	public KumHoTire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	@Override
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
