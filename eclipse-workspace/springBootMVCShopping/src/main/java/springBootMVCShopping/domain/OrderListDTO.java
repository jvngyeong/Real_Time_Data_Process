package springBootMVCShopping.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("orderListDTO")
@AllArgsConstructor
@NoArgsConstructor
public class OrderListDTO {
	PurchaseDTO purchaseDTO;
	List<PurchaseListGoodsDTO> purchaseListGoodsDTOs;
}
