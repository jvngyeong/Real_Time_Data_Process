package jspMVCMisoShopping.model.dto;

import lombok.Data;

@Data
public class PurchaseInfoDTO {
	//goods
	String goodsNum;
	String goodsImage;
	String goodsName;
	
	//purchase
	Long purchaseNum;
	Long purchasePrice;
	String purchaseStatus;
	String memberNum;
	
	//payment
	String confirmNum;
	String applDate;
	
	//delivery
	Long deliveryNum;
	String deliveryStatus;
	
	//review
	int reviewNum;
}
