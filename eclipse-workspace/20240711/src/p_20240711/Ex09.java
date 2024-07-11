package p_20240711;

public class Ex09 {

	public static void main(String[] args) {
		int[] i = {1,2,3,4};
		//마지막 요소의 값을 출력
		System.out.println(i[i.length-1]);
		//마지막 요소의 값을 저장.
		i[i.length-1] = 200;
		int idx = i.length-1;
		i[idx] = 100;
	}

}
