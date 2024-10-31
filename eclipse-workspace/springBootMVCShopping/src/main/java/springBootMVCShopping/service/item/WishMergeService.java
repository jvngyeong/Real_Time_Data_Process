package springBootMVCShopping.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.GoodsStockMapper;
import springBootMVCShopping.mapper.MemberMapper;

@Service
public class WishMergeService {
	@Autowired
	GoodsStockMapper goodsStockMapper;
	
	@Autowired
	MemberMapper memberMapper;
	public void execute(String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberId = auth.getUserId();
		String memberNum = memberMapper.getMemberNum(memberId);
		goodsStockMapper.wishMerge(memberNum, goodsNum);
	}
}
