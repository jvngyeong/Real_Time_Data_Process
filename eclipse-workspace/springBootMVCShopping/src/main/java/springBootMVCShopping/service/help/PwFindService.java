package springBootMVCShopping.service.help;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.HelpMapper;
import springBootMVCShopping.service.EmailSendService;

@Service
public class PwFindService {
	@Autowired
	HelpMapper helpMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	EmailSendService emailSendService;
	public void execute(String userId, String userPhone, Model model) {
		AuthInfoDTO auth = helpMapper.findPw(userId, userPhone);
		model.addAttribute("auth", auth);
		if(auth != null) {
			String newPw = UUID.randomUUID().toString().substring(0, 8);
			String encodedPw = passwordEncoder.encode(newPw);
			auth.setUserPw(encodedPw);
			helpMapper.changePw(auth);
			String contents = "<html><body>";
			   contents += "새로운 비밀번호는 " + newPw + "입니다.";
			String subject = "새로운 비밀번호 안내";
			String fromEmail = "highland0@nate.com"; //요거는 안중요해요 어차피 강사님걸로 날아감
			String toEmail = auth.getUserEmail();
			emailSendService.mailSend(fromEmail, toEmail, subject, contents);
			//sMSMessageService.smsSend(dto.getMemberPhone1(), "010-7146-1970", contents);
		}
		
	}
	
}
