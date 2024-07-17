package p_20240717;

public class HomeWork_No7 {
	int ipgoNum;
	int goodsNum;
	int ipgoQty;
	String ipgoDate;
	String madeDate;
	int ipgoPrice;
	int goodsPrice;

	public HomeWork_No7() {
	}

	public HomeWork_No7(int ipgoNum, int goodsNum, int ipgoQty, String ipgoDate, String madeDate, int ipgoPrice,
			int goodsPrice) {
		this.ipgoNum = ipgoNum;
		this.goodsNum = goodsNum;
		this.ipgoQty = ipgoQty;
		this.ipgoDate = ipgoDate;
		this.madeDate = madeDate;
		this.ipgoPrice = ipgoPrice;
		this.goodsPrice = goodsPrice;
	}

	public void setIpgoNum(int ipgoNum) {
		this.ipgoNum = ipgoNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public void setIpgoQty(int ipgoQty) {
		this.ipgoQty = ipgoQty;
	}

	public void setIpgoDate(String ipgoDate) {
		this.ipgoDate = ipgoDate;
	}

	public void setMadeDate(String madeDate) {
		this.madeDate = madeDate;
	}

	public void setIpgoPrice(int ipgoPrice) {
		this.ipgoPrice = ipgoPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getIpgoNum() {
		return ipgoNum;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public int getIpgoQty() {
		return ipgoQty;
	}

	public String getIpgoDate() {
		return ipgoDate;
	}

	public String getMadeDate() {
		return madeDate;
	}

	public int getIpgoPrice() {
		return ipgoPrice;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}
}
