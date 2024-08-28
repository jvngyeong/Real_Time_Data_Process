package p_20240828;

public class Ex05 {

	public static void main(String[] args) {
		/*
		 * 변수 단점 : 값을 하나만 저장 가능.
		 * 배열 단점 : 하나의 종류만 저장 가능
		 * 
		 */
		Goods goods = new Goods();
		goods.goodsNum = "miso_10001";
		goods.goodsPrice = 10000;
		goods.weight = 10;
		goods.goodsCompany = "성결회사";
		goods.qty = 100;
		System.out.println(goods.goodsCompany);
		int i2 = 20;
		Goods goods1 = new Goods();
	}
}
