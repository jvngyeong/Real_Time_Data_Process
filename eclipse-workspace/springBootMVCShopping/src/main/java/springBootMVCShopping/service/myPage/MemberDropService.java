package springBootMVCShopping.service.myPage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.MemberInfoMapper;

@Service
public class MemberDropService {
	@Autowired
	MemberInfoMapper memberInfoMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(String userPw, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(passwordEncoder.matches(userPw, auth.getUserPw())) {
			memberInfoMapper.memberDrop(auth.getUserId());
		}
	}
}
