package springBootMVCShopping.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.PurchaseDTO;
import springBootMVCShopping.mapper.MemberMapper;
import springBootMVCShopping.mapper.PurchaseMapper;

@Service
public class PurchaseListService {
	@Autowired
	PurchaseMapper purchaseMapper;
	
	@Autowired
	MemberMapper memberMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getUserId());
		List<PurchaseDTO> list = purchaseMapper.getPurchaseList(memberNum);
		model.addAttribute("list", list);
	}
}
