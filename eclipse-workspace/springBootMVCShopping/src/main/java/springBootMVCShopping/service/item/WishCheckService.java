package springBootMVCShopping.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.GoodsStockMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class WishCheckService {
	@Autowired
	GoodsStockMapper goodsStockMapper;
	
	@Autowired
	MemberMapper memberMapper;
	public String execute(String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		String memberNum = memberMapper.getMemberNum(memberId);
		String i = goodsStockMapper.wishCheck(goodsNum, memberNum);
		if(i == null) i = "0";
		return i;
	}
}
