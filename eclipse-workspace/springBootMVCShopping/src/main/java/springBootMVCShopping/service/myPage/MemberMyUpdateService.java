package springBootMVCShopping.service.myPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.MemberInfoMapper;

@Service
public class MemberMyUpdateService {
	@Autowired
	MemberInfoMapper memberInfoMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(MemberCommand memberCommand, HttpSession session) {
		MemberDTO dto = new MemberDTO();
		BeanUtils.copyProperties(memberCommand, dto);
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String currentPw = auth.getUserPw();
		if(passwordEncoder.matches(memberCommand.getMemberPw(), currentPw)) {
			memberInfoMapper.memberUpdate(dto);
		}
	}

}
