package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.UserCommand;
import springBootMVCShopping.service.memberJoin.MemberJoinService;

@Controller
@RequestMapping("regist")
public class MemberJoinController {
	@Autowired
	MemberJoinService memberJoinService;
	
	@ModelAttribute
	public UserCommand userCommand() {
		return new UserCommand();
	}
	
	@RequestMapping("userAgree")
	public String agree() {
		return "thymeleaf/memberJoin/agree";
	}
	
	@GetMapping("userWrite")
	public String userWrite() {
		return "thymeleaf/memberJoin/userForm";
	}
	
	@PostMapping("userWrite")
	public String userWrite(@Validated UserCommand userCommand, BindingResult result) {
		if(!result.hasErrors()) {
			memberJoinService.execute(userCommand);
			return "thymeleaf/memberJoin/welcome";
		}
		if(!userCommand.isMemberPwEqualMemberPwCon()) {
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return "thymeleaf/memberJoin/userForm";
		}
		return "thymeleaf/memberJoin/userForm";
	}
}
