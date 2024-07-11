package p_20240711;

public class Ex08 {

	public static void main(String[] args) {
		//
		double[] dd = new double[5];
		int size = 0;
		//10.5, 20.5, 30.5를 넣고, 저장된 값을 출력하고 싶다.
		//단, 숫자와 length를 사용하지 않고, 반복문을 사용해서 출력하시오.
		dd[0] = 10.5;
		dd[1] = 20.5;
		dd[2] = 30.5;
		for(int idx = 0;; idx++) {
			if(dd[idx] != 0) {
				size++;
			}
			else {
				break;
			}
		}
		for(int idx = 0; idx < size; idx++) {
			System.out.println(dd[idx]);
		}
	}

}
