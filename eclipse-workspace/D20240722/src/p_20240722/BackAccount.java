package p_20240722;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackAccount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		List<Account> account = new ArrayList<Account>();
		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 입금 | 4. 출금 | 5. 종료");
			System.out.println("-------------------------------------------------");
			int menuNum = Integer.parseInt(sc.nextLine());
			switch (menuNum) {
			case 1:
				System.out.println("--------");
				System.out.println("계좌 생성");
				System.out.println("--------");
				System.out.print("계좌 번호 : ");
				int accNo = Integer.parseInt(sc.nextLine());
				System.out.print("계좌주 : ");
				String owner = sc.nextLine();
				System.out.print("초기 입금액 : ");
				int money = Integer.parseInt(sc.nextLine());
				account.add(new Account(accNo, owner, money));
				System.out.println("계좌 생성 완료");
				break;
			case 2:
				System.out.println("--------");
				System.out.println("계좌 목록");
				System.out.println("--------");
				for(Account a : account) {
					System.out.print(a.getAccountNo() + "   ");
					System.out.print(a.getBalance() + "   ");
					System.out.print(a.getOwner() + "   ");
				}
				break;
			case 3:
				System.out.println("--------");
				System.out.println("입금");
				System.out.println("--------");
				System.out.print("계좌 번호 : ");
				accNo = Integer.parseInt(sc.nextLine());
				System.out.print("입금액 : ");
				money = sc.nextInt();
				boolean noAccNum = true;
				for(Account a : account) {
					if(accNo == a.getAccountNo()) {
						a.deposit(money);
					}
				}
				if(noAccNum == true) System.out.println("일치하는 계좌가 없습니다.");
				break;
			case 4:
				System.out.println("--------");
				System.out.println("출금");
				System.out.println("--------");
				System.out.print("계좌 번호 : ");
				accNo = Integer.parseInt(sc.nextLine());
				System.out.print("출금액 : ");
				money = sc.nextInt();
				noAccNum = true;
				for(Account a : account) {
					if(accNo == a.getAccountNo()) {
						a.withdraw(money);
						noAccNum = false;
					}
				}
				if(noAccNum == true) System.out.println("일치하는 계좌가 없습니다.");
				break;
			case 5:
				run = false;
				System.out.println("프로그램 종료");
				break;
			default : System.out.println("입력 번호가 잘못됐습니다.");
			}
		}
	}
}
