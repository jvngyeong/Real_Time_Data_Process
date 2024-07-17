package p_20240717;

public class Ex02_Account {
	public static int ownerNum = 0;
	
	private String accountNo;
	private String ownerName;
	private int firstMoney;

	public Ex02_Account() {}
	public Ex02_Account(String accountNo, String ownerName, int firstMoney) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.firstMoney = firstMoney;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setFirstMoney(int firstMoney) {
		this.firstMoney = firstMoney;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public int getFirstMoney() {
		return firstMoney;
	}
}
