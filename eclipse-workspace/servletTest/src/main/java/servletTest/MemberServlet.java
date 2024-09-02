package servletTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String str = request.getParameter("where");
		if(str.equals("main")) {
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<title>Insert title here</title>");
			out.print("</head>");
			out.print("<body>");	
			out.print("<form action = 'test' method = 'post'>");
			out.print("<input type = 'hidden' name = 'where' value = 'req'/>");
		      out.write("아이디 : <input type = \"text\" name = \"userId\"/><br/>\r\n");
		      out.write("관심분야 :\r\n");
		      out.write("<input type =\"checkbox\" name = \"cp\" value = \"엔터테인먼트\"/>엔터테인먼트\r\n");
		      out.write("<input type =\"checkbox\" name = \"cp\" value = \"컴퓨터/인터넷\"/>컴퓨터/인터넷\r\n");
		      out.write("<input type =\"checkbox\" name = \"cp\" value = \"경제/비지니스\"/>경제/비지니스\r\n");
		      out.write("<input type =\"checkbox\" name = \"cp\" value = \"스포츠/건강\"/>스포츠/건강\r\n");
		      out.write("<input type =\"checkbox\" name = \"cp\" value = \"여행/관광\"/>여행/관광\r\n");
		      out.write("<input type = \"submit\" value = \"전송\"/>\r\n");
			out.print("</form>");
			out.print("</body>");
			out.print("</html>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String str = request.getParameter("where");
		if(str.equals("req")) {
			String userId = request.getParameter("userId");
			String cp[] = request.getParameterValues("cp");
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<title>Insert title here</title>");
			out.print("</head>");
			out.print("<body>");	
			out.print("아이디는 : ");
			out.print(userId + "<br/>");
			out.print("관심 분야는 : ");
			for(String val : cp) {
				out.print(val);
			}
			out.print("</form>");
			out.print("</body>");
			out.print("</html>");
		}
	}
}
