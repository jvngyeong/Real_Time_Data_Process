package springBootMVCShopping;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
public class SpringBootConfig {
	//ModelAndView 객체 만들기
	@Bean(value = "jsonView")
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}
	
	//security에 의한 로그인 화면을 사용하지 않도록 설정
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.formLogin().disable().csrf().disable();
		return httpSecurity.build();
	}
}
