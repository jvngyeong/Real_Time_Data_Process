package p_20240719_polymorphism;

public class Car {
	Tire tire[] = {
			new HanKookTire(10, "앞 왼쪽"),
			new KumHoTire(10, "앞 오른쪽"),
			new HanKookTire(10, "뒤 오른쪽"),
			new KumHoTire(10, "뒤 왼쪽")
			};

	public int run() {
		System.out.println("자동차가 달립니다.");
		if(tire[0].roll() == false) {stop(); return 1;}
		if(tire[1].roll() == false) {stop(); return 2;}
		if(tire[2].roll() == false) {stop(); return 3;}
		if(tire[3].roll() == false) {stop(); return 4;}
		return 0;
	}
	private void stop() {
		System.out.println("차를 멈췄습니다.");
	}
}
