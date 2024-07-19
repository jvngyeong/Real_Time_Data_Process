package p_20240717;

public class HomeWork_No2 {
	int goodsNum;
	String goodsName;
	int goodsPrice;
	String goodsContent;

	public HomeWork_No2(int goodsNum, String goodsName, int goodsPrice, String goodsContent) {
		this.goodsNum = goodsNum;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsContent = goodsContent;
	}
	
	public void print() {
		System.out.println(goodsNum);
		System.out.println(goodsName);
		System.out.println(goodsPrice);
		System.out.println(goodsContent);
	}
}
