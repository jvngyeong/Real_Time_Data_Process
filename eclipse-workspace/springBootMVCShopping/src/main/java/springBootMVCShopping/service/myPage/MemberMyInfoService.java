package springBootMVCShopping.service.myPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.MemberInfoMapper;

@Service
public class MemberMyInfoService {
	@Autowired
	MemberInfoMapper memberInfoMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String memberId = auth.getUserId();
		MemberDTO memDTO = memberInfoMapper.memberSelectOne(memberId);
		model.addAttribute("memberCommand", memDTO);
	}
}
