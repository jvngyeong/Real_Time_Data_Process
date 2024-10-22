package springBootMVCShopping.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.UserCommand;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.UserMapper;
import springBootMVCShopping.service.EmailSendService;
import springBootMVCShopping.service.SMSMessageService;

@Service
public class MemberJoinService {
	@Autowired
	EmailSendService emailSendService;
	
	@Autowired
	SMSMessageService sMSMessageService;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(UserCommand userCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setGender(userCommand.getGender());
		dto.setMemberAddr(userCommand.getMemberAddr());
		dto.setMemberAddrDetail(userCommand.getMemberAddrDetail());
		dto.setMemberBirth(userCommand.getMemberBirth());
		dto.setMemberEmail(userCommand.getMemberEmail());
		dto.setMemberId(userCommand.getMemberId());
		dto.setMemberName(userCommand.getMemberName());
		dto.setMemberPhone1(userCommand.getMemberPhone1());
		dto.setMemberPhone2(userCommand.getMemberPhone2());
		dto.setMemberPost(userCommand.getMemberPost());
		String encodedPw = passwordEncoder.encode(userCommand.getMemberPw());
		dto.setMemberPw(encodedPw);
		int i = userMapper.userInsert(dto);
		if(i > 0) {
			String contents = "<html><body>";
				   contents += dto.getMemberName() + "님 가입을 환영합니다.<br/>";
				   contents += "가입을 완료하시려면 ";
				   contents += "<a href = 'http://localhost:8080/userConfirm?chk="+dto.getMemberEmail()+"'>여기</a>를 클릭하세요.";
			String subject = "환영 인사임당~~";
			String fromEmail = "highland0@nate.com"; //요거는 안중요해요 어차피 강사님걸로 날아감
			String toEmail = dto.getMemberEmail();
			emailSendService.mailSend(fromEmail, toEmail, subject, contents);
			//sMSMessageService.smsSend(dto.getMemberPhone1(), "010-7146-1970", contents);
		}
	}
}
