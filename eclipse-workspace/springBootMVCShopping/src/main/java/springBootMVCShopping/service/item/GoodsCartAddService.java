package springBootMVCShopping.service.item;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.CartMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class GoodsCartAddService {
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	CartMapper cartMapper;
	public String execute(String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(auth != null) {
			String memberNum = memberMapper.getMemberNum(auth.getUserId());
			cartMapper.goodsCartAdd(goodsNum, memberNum);
			return "200";
		}
		return "000";
	}

}
