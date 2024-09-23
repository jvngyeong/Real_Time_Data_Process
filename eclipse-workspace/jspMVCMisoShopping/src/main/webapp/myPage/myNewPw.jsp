<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#frm").submit(function() {
			if ($("#newPw").val() != $("#newPwCon").val()) {
				alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				$("#newPw").val("");
				$("#newPwCon").val("");
				$("#newPw").focus();
				return false;
			}
		});
	});
</script>
</head>
<body>
	<ul>
		<li><a href="<c:url value='/' />">홈으로 이동</a></li>
		<li><a href="memberMyPage.my">내 정보 보기</a></li>
		<li><a href="memberUpdate.my">내 정보 수정</a></li>
		<li><a href="userPwModify.my">비밀번호 변경</a></li>
		<li><a href="memberDrop.my">회원 탈퇴</a></li>
	</ul>
	<form action="memberPwPro.my" method="post" id="frm">
		비밀번호 확인 : <input type="password" name="oldPw" id="oldPw"
			required="required" /><br> 
		새 비밀번호 : <input type="password"
			name="newPw" id="newPw" required="required" /><br> 
		새 비밀번호 확인 :
		<input type="password" name="newPwCon" id="newPwCon"
			required="required" /><br> <input type="submit" value="비밀번호 변경" />
	</form>
</body>
</html>