package springBootMVCShopping.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("purchaseListGoodsDTO")
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseListGoodsDTO {
	PurchaseListDTO purchaseListDTO;
	GoodsDTO goodsDTO;
	ReviewDTO reviewDTO;
}
