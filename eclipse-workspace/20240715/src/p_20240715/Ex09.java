package p_20240715;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		// 3명의 회원을 입력하시오. 2명은 생성자를 이용해서 초기화
		// 1명은 기본 생성자를 이용해서 객체 생성 후 메서드를 이용해 초기화
		Scanner sc = new Scanner(System.in);
		int num;
		String name;
		String ID;
		String PW;
		String phone;
		String addr;
		char gender;
		System.out.print("회원 번호를 입력해주세요. = ");
		num = sc.nextInt();
		sc.nextLine();
		System.out.print("회원 이름를 입력해주세요. = ");
		name = sc.nextLine();
		System.out.print("회원 ID를 입력해주세요. = ");
		ID = sc.nextLine();
		System.out.print("회원 PW를 입력해주세요. = ");
		PW = sc.nextLine();
		System.out.print("회원 연락처를 입력해주세요. = ");
		phone = sc.nextLine();
		System.out.print("회원 주소를 입력해주세요. = ");
		addr = sc.nextLine();
		System.out.print("회원 성별를 입력해주세요. = ");
		gender = sc.next().charAt(0);  // 문자열을 입력받아 첫 번째 문자를 추출
		Ex09_Member mem1 = new Ex09_Member(num, name, ID, PW, phone, addr, gender);
		
		System.out.print("회원 번호를 입력해주세요. = ");
		num = sc.nextInt();
		sc.nextLine();
		System.out.print("회원 이름를 입력해주세요. = ");
		name = sc.nextLine();
		System.out.print("회원 ID를 입력해주세요. = ");
		ID = sc.nextLine();
		System.out.print("회원 PW를 입력해주세요. = ");
		PW = sc.nextLine();
		System.out.print("회원 연락처를 입력해주세요. = ");
		phone = sc.nextLine();
		System.out.print("회원 주소를 입력해주세요. = ");
		addr = sc.nextLine();
		System.out.print("회원 성별를 입력해주세요. = ");
		gender = sc.next().charAt(0);  // 문자열을 입력받아 첫 번째 문자를 추출
		Ex09_Member mem2 = new Ex09_Member(num, name, ID, PW, phone, addr, gender);
		
		Ex09_Member mem3 = new Ex09_Member();
		mem3.setData(3, "회원3", "ID3", "PW3", "333-3333-3333", "주소3", 'M');
		mem1.print();
		mem2.print();
		mem3.print();
	}
}
