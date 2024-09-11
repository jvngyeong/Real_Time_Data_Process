package jspMVCMisoShopping.service.user;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.UserDAO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class UserRegistService {
	public void execute(HttpServletRequest request) {
		MemberDTO dto = new MemberDTO();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		dto.setMemberId(request.getParameter("userId"));
		dto.setMemberPw(request.getParameter("userPw"));
		dto.setMemberName(request.getParameter("userName"));
		dto.setMemberPhone1(request.getParameter("userPhone1"));
		dto.setMemberPhone2(request.getParameter("userPhone2"));
		dto.setMemberAddr(request.getParameter("userAddr"));
		dto.setMemberAddrDetail(request.getParameter("userAddrDetail"));
		dto.setMemberPost(request.getParameter("userPost"));
		dto.setMemberEmail(request.getParameter("userEmail"));
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String birth = request.getParameter("userBirth");
		try {
			date = sdf.parse(birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setMemberBirth(date);
		dto.setGender(request.getParameter("gender"));
		UserDAO dao = new UserDAO();
		dao.userInsert(dto);
	}
}
