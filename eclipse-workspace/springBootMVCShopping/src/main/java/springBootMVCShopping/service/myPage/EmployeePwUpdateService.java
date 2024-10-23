package springBootMVCShopping.service.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.EmployeeInfoMapper;

@Service
public class EmployeePwUpdateService {
	@Autowired
	EmployeeInfoMapper employeeInfoMapper;

	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(String oldPw, String newPw, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(passwordEncoder.matches(oldPw, auth.getUserPw())) {
			newPw = passwordEncoder.encode(newPw);
			auth.setUserPw(newPw);
			employeeInfoMapper.employeePwUpdate(newPw, auth.getUserId());
		}
	}
}
