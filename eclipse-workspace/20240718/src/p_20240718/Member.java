package p_20240718;

public class Member {
	// setter/getter 단축키로 만들기 | Alt + Shift + S를 누르면 팝업이 나옴. 그때 R을 누르자!
	int memberNum;
	String memberName;
	String memberAddr;
	String memberPhone;
	String memberBirth;
	String memberGender;
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	// 생성자 단축키로 만들기 | Alt + Shift + S를 누르면 팝업이 나옴. 그때 o를 입력!
	// 생성자를 단축키로 만들고나서, 기본 생성자 또한 만들어줘야함!!
	public Member(int memberNum, String memberName, String memberAddr, String memberPhone, String memberBirth,
			String memberGender) {
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.memberAddr = memberAddr;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.memberGender = memberGender;
	}
	public Member() {}

}
