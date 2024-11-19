package springBootMVCShopping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.LoginMapper;
import springBootMVCShopping.service.EmailSendService;
import springBootMVCShopping.service.SMSMessageService;
import springBootMVCShopping.service.goods.MainGoodsListService;

@SpringBootApplication
@Controller
public class SpringBootMvcShoppingApplication {
	@Autowired
	EmailSendService emailSendService;
	
	@Autowired
	SMSMessageService sMSMessageService;
	
	@Autowired
	MainGoodsListService mainGoodsListService;
	
	@Autowired
	LoginMapper loginMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcShoppingApplication.class, args);
	}

	@GetMapping("/")
	public String index(
			LoginCommand loginCommand, HttpServletRequest req, Model model, HttpSession session
			//@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			//Model model
			) {
		//mainGoodsListService.execute(model, page);
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("isAutoLogin")) {
					AuthInfoDTO auth = loginMapper.loginSelectOne(cookie.getValue());
					session.setAttribute("auth", auth);
				}
				
				if(cookie.getName().equals("isIdStore")) {
					loginCommand.setUserId(cookie.getValue());
					loginCommand.setIdStore(true);
					model.addAttribute("loginCommand", loginCommand);
				}
			}
		}
		return "thymeleaf/index";
	}
	
	@PostMapping("/")
	public ModelAndView index(int page, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		mainGoodsListService.execute(model, page);
		return mav;
	}
	
	@GetMapping("/mailling")
	public String mail() {
		return "thymeleaf/email";
	}
	
	@PostMapping("/mailling")
	public String mail(String fromEmail, String toEmail, String subject, String contents) {
		emailSendService.mailSend(fromEmail, toEmail, subject, contents);
		return "redirect:/";
	}
	
	@GetMapping("/smsSend")
	public String smsSend() {
		return "thymeleaf/sms";
	}
	
	@PostMapping("/smsSend")
	public String smsSend(String userPhone, String message) {
		sMSMessageService.smsSend(userPhone, "010-7146-1970", message);
		return "redirect:/";
	}
}
