package p_20240828;

import java.util.Arrays;

public class Ex04 {

	public static void main(String[] args) {
		int i1[] = {1, 2, 3, 4, 5};
		int i2[];
		// i2에 i1의 값을 복사하고 싶다.
		i2 = i1;	//얕은 복사
		System.out.println(Arrays.toString(i1));
		System.out.println(Arrays.toString(i2));
		i2[1] = 200;
		System.out.println(Arrays.toString(i1));
		System.out.println(Arrays.toString(i2));
		int i3[] = new int[i1.length];
		System.arraycopy(i1, 0, i3, 0, i1.length);	//깊은 복사
		i1[0] = 100;
		System.out.println(Arrays.toString(i1));
		System.out.println(Arrays.toString(i3));
	}

}
