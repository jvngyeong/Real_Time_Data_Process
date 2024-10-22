package springBootMVCShopping.service.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.MemberInfoMapper;

@Service
public class MemberPwUpdateService {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MemberInfoMapper memberInfoMapper;
	public void execute(String oldPw, String newPw, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(passwordEncoder.matches(oldPw, auth.getUserPw())) {
			auth.setUserPw(newPw);
			newPw = passwordEncoder.encode(newPw);
			memberInfoMapper.memberPwUpdate(newPw, auth.getUserId());
		}
	}
}
