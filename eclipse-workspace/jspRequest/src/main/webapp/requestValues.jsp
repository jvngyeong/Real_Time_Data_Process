<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String userName = request.getParameter("userName");
	String[] item = request.getParameterValues("item");
	String[] cp = request.getParameterValues("cp");
	String M_Status = request.getParameter("M_Status");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : <%=userName%><br>
취미 : <%
	for(String val : item){
		out.print(val+ " ");
	}
%><br>
관심분야 : <%
	for(String val : cp){
		out.print(val+ " ");
	}
%><br>
결혼여부 : <%=M_Status%>


</body>
</html>