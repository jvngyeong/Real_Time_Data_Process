package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.service.IdCheckService;
import springBootMVCShopping.service.login.UserLoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	IdCheckService idCheckService;
	
	@Autowired
	UserLoginService userLoginService;
	
	// ajax를 사용할 때, Spring 방식
	// 원래 Controller에서는 html이나 jsp의 주소를 return 해야하지만, ResponseBody를 사용하면 Text 값을 return 가능
	@PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		return idCheckService.execute(userId);
	}
	
	@PostMapping("login")
	public String login(@Validated LoginCommand loginCommand, 
			BindingResult result,
			HttpSession session,
			HttpServletResponse response,
			HttpServletRequest request) {
		if(result.hasErrors()) {
			return "thymeleaf/index";
		}
		userLoginService.execute(loginCommand, result, session, response);
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletResponse resp, HttpServletRequest req, HttpSession session, Model model, LoginCommand loginCommand) {
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			if(!cookie.getName().equals("isIdStore")) {
				cookie.setPath("/");
				cookie.setMaxAge(0);
			}
			resp.addCookie(cookie);
		}
		
		session.invalidate();
		return "redirect:/";
	}
}
