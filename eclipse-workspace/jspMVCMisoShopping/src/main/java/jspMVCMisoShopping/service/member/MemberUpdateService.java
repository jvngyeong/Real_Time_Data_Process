package jspMVCMisoShopping.service.member;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberUpdateService {
	public void execute(HttpServletRequest request) {
		MemberDTO dto = new MemberDTO();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setMemberNum(request.getParameter("memberNum"));
		System.out.println(request.getParameter("memberNum"));
		dto.setMemberName(request.getParameter("memberName"));
		dto.setMemberId(request.getParameter("memberId"));
		dto.setMemberAddr(request.getParameter("memberAddr"));
		dto.setMemberAddrDetail(request.getParameter("memberAddrDetail"));
		dto.setMemberPost(request.getParameter("memberPost"));
		dto.setMemberPhone1(request.getParameter("memberPhone1"));
		dto.setMemberPhone2(request.getParameter("memberPhone2"));
		dto.setGender(request.getParameter("gender"));
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String birth = request.getParameter("memberBirth"); // yyyy-mm-dd
		try {
			date = sdf.parse(birth);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		dto.setMemberBirth(date);

		
		dto.setMemberEmail(request.getParameter("memberEmail"));
		MemberDAO dao = new MemberDAO();
		dao.memberUpdate(dto);
	}
}
