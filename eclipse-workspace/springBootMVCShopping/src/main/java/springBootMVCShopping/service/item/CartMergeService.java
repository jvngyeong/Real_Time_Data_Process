package springBootMVCShopping.service.item;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.CartCommand;
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
	public String execute(CartCommand cartCommand, HttpSession session) {
		CartDTO dto = new CartDTO();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = null;
		memberNum = memberMapper.getMemberNum(auth.getUserId());
		dto.setMemberNum(memberNum);
		dto.setCartQty(cartCommand.getCartQty());
		dto.setGoodsNum(cartCommand.getGoodsNum());
		if(memberNum == null) {
			return "900";
		}
		else {
			cartMapper.cartMerge(dto);
			return "200";
		}
	}
}
