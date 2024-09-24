package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class IpgoDTO {
	String goodsNum;
	String ipgoNum;
	int ipgoQty;
	Date ipgoDate;
	Date madeDate;
	int ipgoPrice;
	String empNum;
}
