package p_20240717;

public class HomeWork_No4 {
	int purchaseNum;
	String cardNum;
	int totalPrice;
	String applDate;
	String applTime;
	public HomeWork_No4() {}
	public HomeWork_No4(int purchaseNum, String cardNum, int totalPrice, String applDate,
	String applTime) {
		this.purchaseNum = purchaseNum;
		this.cardNum = cardNum;
		this.totalPrice = totalPrice;
		this.applDate = applDate;
		this.applTime = applTime;
	}
	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setApplDate(String applDate) {
		this.applDate = applDate;
	}
	public void setApplTime(String applTime) {
		this.applTime = applTime;
	}
	
	public int getPurchaseNum() {
		return purchaseNum;
	}
	public String getCardNum() {
		return cardNum;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public String getApplDate() {
		return applDate;
	}
	public String getApplTime() {
		return applTime;
	}
}
