package springBootMVCShopping.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.repository.DeliveryRepository;

@Service
public class DeliveryInsertService {
	@Autowired
	DeliveryRepository deliveryRepository;
	
	public void execute(String purchaseNum, String deliveryNum) {
		deliveryRepository.deliveryInsert(purchaseNum, deliveryNum);
	}
}
