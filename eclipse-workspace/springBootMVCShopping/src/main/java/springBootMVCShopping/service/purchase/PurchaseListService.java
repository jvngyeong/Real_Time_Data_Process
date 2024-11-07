package springBootMVCShopping.service.purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.OrderListDTO;
import springBootMVCShopping.domain.PurchaseListGoodsDTO;
import springBootMVCShopping.mapper.MemberMapper;
import springBootMVCShopping.mapper.PurchaseMapper;
import springBootMVCShopping.repository.PurchaseRepository;

@Service
public class PurchaseListService {
	@Autowired
	PurchaseMapper purchaseMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	public void execute(Model model, HttpSession session, String purchaseNum) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getUserId());
//		List<PurchaseDTO> list = purchaseMapper.getPurchaseList(memberNum);
		Map<String, String> map = new HashMap<String, String>();
		map.put("purchaseNum", purchaseNum);
		map.put("memberNum", memberNum);
		List<OrderListDTO> list = purchaseRepository.orderList(map);
		for(OrderListDTO old : list) {
			for(PurchaseListGoodsDTO PLD : old.getPurchaseListGoodsDTOs()) {
				System.out.println(PLD.getGoodsDTO().getGoodsContents() + "\n\n\n\n\n\n\n\n");
			}
		}
		model.addAttribute("list", list);
	}
}
