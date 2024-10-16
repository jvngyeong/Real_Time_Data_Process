package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.service.AutoNumService;
import springBootMVCShopping.service.member.MemberDetailService;
import springBootMVCShopping.service.member.MemberListService;
import springBootMVCShopping.service.member.MemberUpdateService;
import springBootMVCShopping.service.member.MemberWriteService;
import springBootMVCShopping.service.member.MembersDeleteService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberWriteService memberWriteService;
	
	@Autowired
	AutoNumService autoNumService;
	
	@Autowired
	MemberListService memberListService;
	
	@Autowired
	MembersDeleteService membersDeleteService;
	
	@Autowired
	MemberDetailService memberDetailService;
	
	@Autowired
	MemberUpdateService memberUpdateService;
	@GetMapping("memberList")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "searchWord", required = false) String searchWord,
			Model model) {
		memberListService.execute(searchWord, page, model);
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
	
	@RequestMapping("membersDelete")
	public String membersDelete(@RequestParam("nums") String[] memberNums) {
		membersDeleteService.execute(memberNums);
		return "redirect:memberList";
	}
	
	//@PathVariable() -> 쿼리스트링 대신에 쿼리스트링에 넣을 값을 주소로 사용할 때, 주소가 사람마다 다르기 때문에 사용
	@GetMapping("memberDetail/{memberNum}")
	public String memberDetail(@PathVariable("memberNum") String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberInfo";
	}
	
	@GetMapping("memberUpdate")
	public String memberUpdate(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberModify";
	}
	
	@PostMapping("memberModify")
	public String memberModify(@Validated MemberCommand memberCommand,
			BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberModify";
		}
		memberUpdateService.execute(memberCommand);
		return "redirect:memberDetail/"+memberCommand.getMemberNum();
	}
	
	@GetMapping("memberDelete/{memberNum}")
	public String memberDelete(@PathVariable("memberNum") String[] memberNum) {
		membersDeleteService.execute(memberNum);
		return "redirect:../memberList";
	}
}
