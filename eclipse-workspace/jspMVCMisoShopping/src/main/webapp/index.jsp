<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<style>

</style>
</head>
<body>
안녕하세요. 미소쇼핑몰입니다.<br><br>
<ui>
	<li><a href = "memberList.mem">회원 목록</a></li>
	<li><a href = "employeeList.emp">직원 목록</a></li>
</ui>

<table border = "1" style = "margin : 0 auto">
	<tr>
		<td colspan = "2">로그인 유지 | 아이디 저장</td>
	</tr>
	<tr>
		<td>
			<input type = "text" name = "memberId" placeholder = "아이디">
		</td>
		<td rowspan = "2">
			<input type = "submit" value = "로그인">
		</td>
	</tr>
	<tr>
		<td>
			<input type = "text" name = "memberId" placeholder = "비밀번호">
		</td>
	</tr>
	<tr>
		<td colspan = "2">아이디 / 비밀번호 찾기 | <a href = "">회원가입</a></td>
	</tr>
</table>
</body>
</html>