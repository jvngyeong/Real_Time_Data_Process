<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>

</head>
<body>
안녕하세요. 미소쇼핑몰입니다.<br><br>
<ui>
	<li><a href = "memberList.mem">회원 목록</a></li>
	<li><a href = "employeeList.emp">직원 목록</a></li>
</ui>

<table border = "1" align= "center">
	<tr>
		<td colspan = "2">로그인 유지 | 아이디 저장</td>
	</tr>
	<tr>
		<td>
			<input type = "text" name = "userId" placeholder = "아이디">
		</td>
		<td rowspan = "2">
			<input type = "submit" value = "로그인">
		</td>
	</tr>
	<tr>
		<td>
			<input type = "text" name = "userId" placeholder = "비밀번호">
		</td>
	</tr>
	<tr>
		<td colspan = "2">
		<a href = "idInquiry.help">아이디</a>
		/ 
		<a href = "pwInquiry.help">비밀번호 찾기</a>
		| 
		<a href = "userAgree.nhn">회원가입</a></td>
	</tr>
</table>
</body>
</html>