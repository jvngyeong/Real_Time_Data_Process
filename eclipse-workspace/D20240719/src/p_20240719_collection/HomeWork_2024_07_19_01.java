package p_20240719_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeWork_2024_07_19_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 수량을 입력하세요 = ");
		int qty = sc.nextInt();
		int[] lottoNum = new int[6];
		for (int k = 0; k < qty; k++) {
			for (int i = 0; i < 6; i++) {
				int num = (int) ((Math.random() * 45) + 1);
				for (int a : lottoNum) {
					if (a == num) {
						i--;
						break;
					}
					if (a == lottoNum[lottoNum.length - 1]) {
						lottoNum[i] = num;
					}
				}
			}
			System.out.println();
			for (int j : lottoNum) {
				System.out.print(j + " ");
			}
		}
	}
}
