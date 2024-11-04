package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseDTO")
public class PurchaseDTO {
	//String confirmNum;
	String purchaseNum;
	String purchaseName;
	String purchaseStatus;
	Date purchaseDate;
}
