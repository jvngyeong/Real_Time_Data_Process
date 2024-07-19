package p_20240719_collection;

public class Account {
	String accNum;
	String accOwner;
	int money;
	public Account(String accNum, String accOwner, int money) {
		this.accNum = accNum;
		this.accOwner = accOwner;
		this.money = money;
	}
	public Account() {
	}
	public void print() {
		System.out.print(accNum + " ");
		System.out.print(accOwner + " ");
		System.out.println(money);
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getAccOwner() {
		return accOwner;
	}
	public void setAccOwner(String accOwner) {
		this.accOwner = accOwner;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
