package bank.view;

import java.util.Scanner;
import bank.*;

public class AccountCreate {
	Scanner scanner = new Scanner(System.in);
	public Request view() {
		System.out.println("--------");
		System.out.println("계좌 생성");
		System.out.println("--------");
		System.out.println("계좌번호 : ");
		int accNo = Integer.parseInt(scanner.nextLine());
		System.out.println("계좌주 : ");
		String owner = scanner.nextLine();
		System.out.println("초기 입금액 : ");
		int money = Integer.parseInt(scanner.nextLine());
		Request request = new Request(accNo, owner, money, 6);
		return request;
	}
}
