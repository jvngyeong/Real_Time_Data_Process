package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("purchaseListDTO")
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseListDTO {
	String goodsNum;
	String purchaseNum;
	Integer purchaseQty;
	Integer goodsUnitPrice;
}
