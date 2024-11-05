package springBootMVCShopping.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.GoodsCartDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class GoodsBuyService {
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	CartMapper cartMapper;
	public void execute(String[] nums, HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getUserId());
		List<GoodsCartDTO> list = cartMapper.cartListSelect(memberNum, nums);
		model.addAttribute("list", list);
		
		Integer sumPrice = 0;
		Integer sumDeliveryCost = 3000;

		String goodsNums = "";
		for(GoodsCartDTO dto : list) {
			sumPrice += dto.getGoodsDTO().getGoodsPrice() * dto.getCartDTO().getCartQty();
			goodsNums += dto.getGoodsDTO().getGoodsNum() + "-";
		}
		if(sumPrice >= 30000) {
			sumDeliveryCost = 0;
		}
		model.addAttribute("sumPrice", sumPrice);
		model.addAttribute("sumDeliveryCost", sumDeliveryCost);
		model.addAttribute("goodsNums", goodsNums);
	}
}
