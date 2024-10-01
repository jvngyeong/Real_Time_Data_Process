package jspMVCMisoShopping.model.dto;

import lombok.Data;

@Data
public class ReviewDTO {
	String goodsNum;
	String purchaseNum;
	String reviewContent;
	String memberId;
	String reviewDate;
}
