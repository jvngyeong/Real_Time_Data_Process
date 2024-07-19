package p_20240715;

//회원 가입
public class Ex09_Member {
	// 회원 번호
	// 회원 이름
	// 회원 ID
	// 회원 Password
	// 회원 연락처
	// 회원 주소
	// 회원 성별
	int memberNum;
	String memberName;
	String memberID;
	String memberPW;
	String memberPhone;
	String memberAddr;
	char memberGender;

	// 생성자, 기본 생성자
	public Ex09_Member() {
	}

	public Ex09_Member(int memberNum, String memberName, String memberID, String memberPW, String memberPhone, String memberAddr, char memberGender) {
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.memberGender = memberGender;
	}

	public void setData(int memberNum, String memberName, String memberID, String memberPW, String memberPhone, String memberAddr, char memberGender) {
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.memberGender = memberGender;
	}
	
	//getter, setter
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public void setMemberGender(char memberGender) {
		this.memberGender = memberGender;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberID() {
		return memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public char getMemberGender() {
		return memberGender;
	}

	// print
	public void print() {
		System.out.println(memberNum);
		System.out.println(memberName);
		System.out.println(memberID);
		System.out.println(memberPW);
		System.out.println(memberPhone);
		System.out.println(memberAddr);
		System.out.println(memberGender);
	}
}
