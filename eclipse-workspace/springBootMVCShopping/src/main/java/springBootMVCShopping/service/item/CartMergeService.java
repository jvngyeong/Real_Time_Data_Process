package springBootMVCShopping.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.CartDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class CartMergeService {
	@Autowired
	CartMapper cartMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String goodsNum, Integer cartQty, HttpSession session) {
		CartDTO dto = new CartDTO();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getUserId());
		dto.setMemberNum(memberNum);
		dto.setCartQty(cartQty);
		dto.setGoodsNum(goodsNum);
		cartMapper.cartMerge(dto);
	}
}
