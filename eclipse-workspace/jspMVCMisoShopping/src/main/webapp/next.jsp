<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

String name1 = (String) session.getAttribute("a");
String name2 = (String) request.getAttribute("b");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${a }
${b }
</body>
</html>