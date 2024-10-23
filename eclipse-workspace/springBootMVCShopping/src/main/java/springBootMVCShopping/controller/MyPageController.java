package springBootMVCShopping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.MemberCommand;
import springBootMVCShopping.service.myPage.EmployeeInfoService;
import springBootMVCShopping.service.myPage.EmployeePwUpdateService;
import springBootMVCShopping.service.myPage.MemberDropService;
import springBootMVCShopping.service.myPage.MemberMyInfoService;
import springBootMVCShopping.service.myPage.MemberMyUpdateService;
import springBootMVCShopping.service.myPage.MemberPwUpdateService;

@Controller
@RequestMapping("myPage")
public class MyPageController {
	@Autowired
	MemberMyInfoService memberMyInfoService;
	
	@Autowired
	MemberMyUpdateService memberMyUpdateService;
	
	@Autowired
	MemberPwUpdateService memberPwUpdateService;
	
	@Autowired
	MemberDropService memberDropService;
	
	@Autowired
	EmployeeInfoService employeeInfoService;
	
	@Autowired
	EmployeePwUpdateService employeePwUpdateService;
	@GetMapping("memberMyPage")
	public String memberMyPage(HttpSession session, Model model) {
		memberMyInfoService.execute(session, model);
		return "thymeleaf/myPage/memberMyPage";
	}
	
	@GetMapping("memberUpdate")
	public String memberUpdate(HttpSession session, Model model) {
		memberMyInfoService.execute(session, model);
		return "thymeleaf/myPage/myModify";
	}
	
	@PostMapping("memberModify")
	public String memberModify(MemberCommand memberCommand, HttpSession session) {
		memberMyUpdateService.execute(memberCommand, session);
		return "redirect:memberMyPage";
	}
	
	@GetMapping("memberPwModify")
	public String memberPwModify() {
		return "thymeleaf/myPage/myNewPw";
	}
	
	@RequestMapping(value = "memberPwPro", method = RequestMethod.POST)
	public String memberPwPro(String oldPw, String newPw, HttpSession session) {
		memberPwUpdateService.execute(oldPw, newPw, session);
		return "redirect:memberMyPage";
	}
	
	@GetMapping("memberDrop")
	public String memberDrop() {
		return "thymeleaf/myPage/memberDrop";
	}
	
	@PostMapping("memberDropOk")
	public String memberDropOk(String userPw, HttpSession session) {
		memberDropService.execute(userPw, session);
		return "redirect:/login/logout";
	}
	
//	@GetMapping("employeeMyPage")
//	public String employeeInfo(HttpSession session, Model model) {
//		employeeInfoService.execute(session, model);
//		return "thymeleaf/myPage/employeeInfo";
//	}
//	@GetMapping("employeeModify")
//	public String employeeModify(HttpSession session, Model model) {
//		employeeInfoService.execute(session, model);
//		return "thymeleaf/employee/employeeDetail";
//	}
	
	@GetMapping("employeeMyPage")
	//jsp 방식으로 사용하는 싱글 페이지 (ModelAndView 객채 사용)
	public String empMyPage() {
		return "thymeleaf/myPage/employeeInfo";
	}
	@PostMapping("empMyPage")
	public ModelAndView empMyPage(HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		employeeInfoService.execute(session, model);
		return mav;
	}
	//Spring 방식 model
	@GetMapping("empModify")
	public @ResponseBody Map<String, Object> employeeModify(HttpSession session, Model model) {
		Map<String, Object> map = employeeInfoService.execute(session, model);
		return map;
	}
	@PostMapping("empPwPro")
	public String empPwPro(@RequestParam("oldPw") String oldPw, String newPw, HttpSession session) {
		employeePwUpdateService.execute(oldPw, newPw, session);
		return "redirect:employeeMyPage";
	}
	
}
