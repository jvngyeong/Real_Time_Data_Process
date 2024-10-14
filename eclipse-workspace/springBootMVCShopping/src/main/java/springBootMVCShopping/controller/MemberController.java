package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.member.MemberWriteService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberWriteService memberWriteService;
	
	@Autowired
	AutoNumService autoNumService;
	@GetMapping("memberList")
	public String list() {
		return "thymeleaf/member/memberList";
		//return "member/memberList";	-> jsp파일을 사용하는 것임
	}
	
	@GetMapping("memberWrite")
	public String write(MemberCommand memberCommand, Model model) {
		String autoNum = autoNumService.execute("mem_", "member_num", 5, "members");
		memberCommand.setMemberNum(autoNum);
		model.addAttribute("memberCommand", memberCommand);
		return "thymeleaf/member/memberForm";
		//return "member/memberForm";	-> jsp파일을 사용하는 것임
	}	
	
	@PostMapping("memberRegist")
	public String write(@Validated MemberCommand memberCommand, BindingResult result, Model model) {
		boolean isEqual = memberCommand.isMemberPwEqualMemberPwCon();
		if(result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		
		if(!isEqual) {
			//model.addAttribute("errPw", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return "thymeleaf/member/memberForm";
		}
		else {
			memberWriteService.execute(memberCommand);
			return "redirect:memberList";
		}
	}
}
