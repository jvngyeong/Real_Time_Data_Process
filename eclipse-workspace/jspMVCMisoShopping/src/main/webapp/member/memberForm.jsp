<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm.jsp</title>
</head>
<body>
	회원가입 페이지입니다.<br>
	<form action = "memberRegist.mem" method= "post">
		회원번호 : <input type = "text" name = "memberNum"><br>
		이름 : <input type = "text" name = "memberName"><br>
		아이디 : <input type = "text" name = "memberId"><br>
		비밀번호 : <input type = "password" name = "memberPw"><br>
		비밀번호 확인 : <input type = "password" name = "memberPwCon"><br>
		주소 :  <input type = "text" name = "memberAddr"><br>
		상세주소 : <input type = "text" name = "memberAddrDetail"><br>
		우편번호 : <input type = "text" name = "memberPost"><br>
		연락처 : <input type = "tel" name = "memberPhone1"><br>
		연락처 2 : <input type = "tel" name = "memberPhone2"><br>
		성별 : <br>
			<input type = "checkbox" name = "gender" value = "M">남자<br>
			<input type = "checkbox" name = "gender" value = "F">여자<br>
		생년월일 : <input type = "date" name = "memberBirth"><br>
		이메일 : <input type = "email" name = "memberEmail"><br>
		<input type = "submit" value = "회원가입">
	</form>
</body>
</html>