package jspMVCMisoShopping.service.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.UserDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class UserLoginService {
	public int execute(HttpServletRequest request) {
		int i = 0;
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println(userId + " = userID값");
		System.out.println(userPw+ " = userPw값");
		UserDAO dao = new UserDAO();
		AuthInfoDTO auth = dao.loginSelect(userId);
		HttpSession session	= request.getSession();	//로그인은 " 세션 " 이 존재할 때를 말함!!
		if(auth != null) {
			System.out.println("아이디가 존재합니다.");
			if(auth.getUserPw().equals(userPw)) {
				System.out.println("비밀번호가 일치합니다.");
				session.setAttribute("auth", auth);
				i = 1;
			}
			else{
				System.out.println("비밀번호가 일치하지 않습니다.");
				request.setAttribute("errPw", "비밀번호가 일치하지 않습니다.");
			}
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.");
			request.setAttribute("errId", "존재하지 않는 아이디입니다.");
		}
		return i;
	}
}
