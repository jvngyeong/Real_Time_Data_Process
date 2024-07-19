package p_20240718_polymorphism;

public class Car {
	//앞 왼쪽 타이어 : 한국타이어
	Tire frontLeftTire = new HanKookTire(6, "앞 왼쪽");
	Tire frontRightTire = new HanKookTire(7, "앞 오른쪽");
	
	Tire backLeftTire = new HanKookTire(8, "뒤 왼쪽");
	Tire backRightTire = new HanKookTire(9, "뒤 오른쪽");
	
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(frontLeftTire.roll() == false) return 1;	//앞 왼쪽 타이어 터짐
		if(frontRightTire.roll() == false) return 2;	//앞 왼쪽 타이어 터짐
		if(backLeftTire.roll() == false) return 3;	//앞 왼쪽 타이어 터짐
		if(backRightTire.roll() == false) return 4;	//앞 왼쪽 타이어 터짐
		return 0;
	}
	
	void stop() {
		System.out.println("차가 멈췄습니다.");
	}
}
