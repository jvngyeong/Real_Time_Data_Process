package p_20240719_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeWork_2024_07_19_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		List<Account> accs = new ArrayList<Account>();
		Account acc = new Account();
		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("------------------------------------------------");
			System.out.print("선택 > ");
			int menuNum = sc.nextInt();
			sc.nextLine();
			switch (menuNum) {
			case 1:
				System.out.println("------");
				System.out.println("계좌생성");
				System.out.println("------");
				System.out.print("계좌번호: ");
				String accNum = sc.nextLine();
				System.out.print("계좌주: ");
				String accOwner = sc.nextLine();
				System.out.print("초기입금액: ");
				int money = sc.nextInt();
				acc = new Account(accNum, accOwner, money);
				accs.add(acc);
				System.out.println("계좌가 개설되었습니다.");
				break;
			case 2:
				System.out.println("------");
				System.out.println("계좌목록");
				System.out.println("------");
				for (Account a : accs) {
					a.print();
				}
				break;
			case 3:
				System.out.println("------");
				System.out.println("예금");
				System.out.println("------");
				System.out.print("계좌번호: ");
				accNum = sc.nextLine();
				System.out.print("예금액: ");
				money = sc.nextInt();
				for (Account a : accs) {
					if (a.getAccNum().equals(accNum)) {
						a.setMoney(a.getMoney() + money);
					}
				}
				break;
			case 4:
				System.out.println("------");
				System.out.println("출금");
				System.out.println("------");
				System.out.print("계좌번호: ");
				accNum = sc.nextLine();
				System.out.print("출금액: ");
				money = sc.nextInt();
				for (Account a : accs) {
					if (a.getAccNum().equals(accNum)) {
						a.setMoney(a.getMoney() - money);
					}
				}
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
		}
	}
}
