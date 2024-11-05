package springBootMVCShopping.service.login;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import okhttp3.Response;
import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.LoginMapper;

@Service
public class UserLoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public void execute(LoginCommand loginCommand, BindingResult result, HttpSession session, HttpServletResponse response) {
		AuthInfoDTO auth = loginMapper.loginSelectOne(loginCommand.getUserId());
		if (auth != null) {
			if (passwordEncoder.matches(loginCommand.getUserPw(), auth.getUserPw())) {
				session.setAttribute("auth", auth);
				if(loginCommand.isIdStore()) {
					// 쿠키 생성
					Cookie cookie = new Cookie("isIdStore", auth.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 24 * 30);
					// 웹 브라우저로 전달
					response.addCookie(cookie);
				}
				else {
					// 쿠키 생성
					Cookie cookie = new Cookie("isIdStore", auth.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(0);
					// 웹 브라우저로 전달
					response.addCookie(cookie);
				}
				if(loginCommand.isAutoLogin()) {
					// 쿠키 생성
					Cookie cookie = new Cookie("isAutoLogin", auth.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 24 * 30);
					// 웹 브라우저로 전달
					response.addCookie(cookie);
				}
				else {
					// 쿠키 생성
					Cookie cookie = new Cookie("isAutoLogin", auth.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(0);
					// 웹 브라우저로 전달
					response.addCookie(cookie);
				}
			} else {
				result.rejectValue("userPw", "userPw", "비밀번호가 일치하지 않습니다.");
			}
		} else {
			result.rejectValue("userId", "userId", "아이디가 존재하지 않습니다.");
		}
	}
}
