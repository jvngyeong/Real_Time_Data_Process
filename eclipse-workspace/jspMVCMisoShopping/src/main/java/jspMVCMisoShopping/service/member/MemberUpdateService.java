package jspMVCMisoShopping.service.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberUpdateService {
	public int execute(HttpServletRequest request) {
		String memberNum = request.getParameter("memberNum");
		HttpSession session = request.getSession();
		AuthInfoDTO authDTO = (AuthInfoDTO) session.getAttribute("auth");
		System.out.println(authDTO);
		MemberDAO dao = new MemberDAO();
		if(memberNum == null) {
			memberNum = dao.memberNumSelect(authDTO.getUserId());
			System.out.println(memberNum);
		}
		MemberDTO dto = new MemberDTO();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setMemberNum(memberNum);
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
		
		int i = 0;
		if(authDTO.getUserPw().equals(request.getParameter("memberPw"))) {
			dao.memberUpdate(dto);
			i = 1;
		}
		else {
			i = 0;
			request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
		}
		return i;
	}
}
