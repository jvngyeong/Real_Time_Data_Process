package p_20240717;

public class HomeWork_No1 {
	int memberNum;
	String memberName;
	String memberAddr;
	String memberPhone;
	String memberBirth;
	String memberGender;

	public HomeWork_No1(int memberNum, String memberName, String memberAddr, String memberPhone, String memberBirth,
			String memberGender) {
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.memberAddr = memberAddr;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.memberGender = memberGender;
	}
	
	public void print() {
		System.out.println(memberNum);
		System.out.println(memberName);
		System.out.println(memberAddr);
		System.out.println(memberPhone);
		System.out.println(memberBirth);
		System.out.println(memberGender);
	}
}
