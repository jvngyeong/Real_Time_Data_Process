package p_20240722_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import p_20240722.Account;

public class BankAccountMap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Account> account = new HashMap<Integer, Account>();
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 입금 | 4. 출금 | 5. 종료");
			System.out.println("-------------------------------------------------");
			String menuNum = sc.nextLine();
			switch (menuNum) {
			case "1":
				System.out.println("--------");
				System.out.println("계좌 생성");
				System.out.println("--------");
				System.out.print("계좌 번호 : ");
				int accNo = Integer.parseInt(sc.nextLine());
				System.out.print("계좌주 : ");
				String owner = sc.nextLine();
				System.out.print("초기 입금액 : ");
				int money = Integer.parseInt(sc.nextLine());
				account.put(accNo, new Account(accNo, owner, money));
				System.out.println("계좌 생성 완료");
				break;
			case "2":
				System.out.println("--------");
				System.out.println("계좌 목록");
				System.out.println("--------");
				// 모든 키 받아오기
				for(Integer key : account.keySet()) {
					Account acc = account.get(key);	//키를 이용해서 객체를 받아옴
					System.out.print(acc.getAccountNo() + "   ");
					System.out.print(acc.getOwner() + "   ");
					System.out.println(acc.getBalance() + "   ");
				}
				break;
			case "3":
				System.out.println("--------");
				System.out.println("입금");
				System.out.println("--------");
				System.out.print("계좌 번호 : ");
				accNo = Integer.parseInt(sc.nextLine());
				System.out.print("입금액 : ");
				money = sc.nextInt();	
				//map을 사용하면 키 값으로 원하는 값에 도달할 수 있기 때문에, 반복문을 사용하지 않아도 된다.
				if(account.get(accNo) != null) {
					Account acc = account.get(accNo);
					acc.deposit(money);
				}
				else {
					System.out.println("일치하는 계좌가 없습니다.");
				}
				break;
			case "4":
				System.out.println("--------");
				System.out.println("출금");
				System.out.println("--------");
				System.out.print("계좌 번호 : ");
				accNo = Integer.parseInt(sc.nextLine());
				System.out.print("출금액 : ");
				money = sc.nextInt();
				if(account.get(accNo) != null) {
					Account acc = account.get(accNo);
					acc.withdraw(money);
				}
				else {
					System.out.println("일치하는 계좌가 없습니다.");
				}
				break;
			case "5":
				run = false;
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
		}
	}
}

// 배열 / Collection(List, set) / Map(HashMap) / Class
