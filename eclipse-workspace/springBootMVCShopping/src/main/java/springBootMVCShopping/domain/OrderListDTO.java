package springBootMVCShopping.domain;

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
	PaymentDTO paymentDTO;
	DeliveryDTO deliveryDTO;
	List<PurchaseListGoodsDTO> purchaseListGoodsDTOs;
}
