package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootMVCShopping.service.help.IdFindService;
import springBootMVCShopping.service.help.PwFindService;

@Controller
@RequestMapping("help")
public class HelpController {
	@Autowired
	IdFindService idFindService;
	
	@Autowired
	PwFindService pwFindService;
	
	@GetMapping("findId")
	public String findId() {
		return "thymeleaf/help/findId";
	}
	
	@PostMapping("findId")
	public String findId(String userPhone, String userEmail, Model model) {
		idFindService.execute(userPhone, userEmail, model);
		return "thymeleaf/help/findIdOk";
	}
	
	@GetMapping("findPassword")
	public String findPassword() {
		return "thymeleaf/help/findPw";
	}
	
	@PostMapping("findPassword")
	public String findPassword(String userId, String userPhone, Model model) {
		pwFindService.execute(userId, userPhone, model);
		return "thymeleaf/help/findPwOk";
	}
}
