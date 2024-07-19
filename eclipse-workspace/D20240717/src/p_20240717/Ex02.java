package p_20240717;

import java.util.Scanner;

import p_20240717.Ex02_Account;

public class Ex02 {

	public static void main(String[] args) {
		int ownerNum;
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		System.out.print("고객 수를 입력하세요. = ");
		Ex02_Account[] Owners = new Ex02_Account[sc.nextInt()];

		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("------------------------------------------------");
			System.out.print("선택 > ");
			menuNum = sc.nextInt();
			sc.nextLine();
			switch (menuNum) {
			case 1:
				System.out.println("-------");
				System.out.println("계좌생성");
				System.out.println("-------");
				System.out.print("계좌번호 : ");
				String accountNo = sc.nextLine();
				System.out.print("계좌주 : ");
				String ownerName = sc.nextLine();
				System.out.print("초기입금액 : ");
				int firstMoney = sc.nextInt();
				Owners[Ex02_Account.ownerNum++] = new Ex02_Account(accountNo, ownerName, firstMoney);
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			case 2:
				System.out.println("-------");
				System.out.println("계좌목록");
				System.out.println("-------");
				for(Ex02_Account obj : Owners) {
					if(obj != null) {
						System.out.print(obj.getAccountNo() + "      " + obj.getOwnerName() + "      " + obj.getFirstMoney());
						System.out.println();
					}
					else {
						System.out.println();
						break;
					}
				}

				break;
			case 3:
				System.out.println("-------");
				System.out.println("예금");
				System.out.println("-------");
				System.out.print("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.print("예금액 : ");
				firstMoney = sc.nextInt();
				for(Ex02_Account obj : Owners) {
					if(obj != null) {
						if(obj.getAccountNo().equals(accountNo)) {
							obj.setFirstMoney(obj.getFirstMoney() + firstMoney);
						}
					}
				}
				break;
			case 4:
				System.out.println("-------");
				System.out.println("출금");
				System.out.println("-------");
				System.out.print("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.print("출금액 : ");
				firstMoney = sc.nextInt();
				for(Ex02_Account obj : Owners) {
					if(obj != null) {
						if(obj.getAccountNo().equals(accountNo)) {
							obj.setFirstMoney(obj.getFirstMoney() - firstMoney);
						}
					}
				}
				break;
			case 5:
				run = false; System.out.println("프로그램 종료"); break;
			}
		}
	}

}
