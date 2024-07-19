package p_20240718_polymorphism;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		for(int i=0; i<=10; i++) {
			int num = car.run();
			switch(num) {
				case 1 : 
					System.out.println("앞 왼쪽 금호타이어 교체");
					car.frontLeftTire = new KumHoTire(6, "앞 왼쪽"); break;
				case 2 : 
					System.out.println("앞 오른쪽 금호타이어 교체");
					car.frontRightTire = new KumHoTire(7, "앞 오른쪽"); break;
				case 3 : 
					System.out.println("뒤 왼쪽 금호타이어 교체");
					car.backLeftTire = new KumHoTire(8, "뒤 왼쪽"); break;
				case 4 : 
					System.out.println("뒤 오른쪽 금호타이어 교체");
					car.backRightTire = new KumHoTire(9, "뒤 오른쪽"); break;
			}

			
		}
	}

}
