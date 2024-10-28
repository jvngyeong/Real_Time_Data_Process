package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.service.EmailCheckService;
import springBootMVCShopping.service.FileDelService;

@RestController
public class CheckRestController {
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	FileDelService fileDelService;
	
	@PostMapping("/checkRest/userEmailCheck")
	public Integer emailCheck(String userEmail) {
		return emailCheckService.execute(userEmail);
	}
	
	@GetMapping("userConfirm")
	public String userConfirm(@RequestParam("chk") String userEmail) {
		Integer i = emailCheckService.update(userEmail);
		if(i == null) {
			return "존재하지 않는 이메일입니다.";
		}
		else {
			if(i == 1) {
				return "인증되었습니다.";
			}
			else {
				return "이미 인증되었습니다.";
			}
		}
	}
	
	@PostMapping("/file/fileDel")
	public int fileDel(String orgFile, String storeFile, HttpSession session) {
		return fileDelService.execute(orgFile, storeFile, session);
	}
}