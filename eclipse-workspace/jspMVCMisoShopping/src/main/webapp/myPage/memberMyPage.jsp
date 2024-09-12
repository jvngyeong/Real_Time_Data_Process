<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberMyPage.jsp</title>
</head>
<body>

	<ul>
		<li><a href = "<c:url value = '/' />">홈으로 이동</a></li>
		<li><a href = "memberMyPage.my">내 정보 보기</a></li>
		<li><a href = "memberUpdate.my">내 정보 수정</a></li>
		<li><a href = "userPwModify.my">비밀번호 변경</a></li>
		<li><a href = "memberDrop.my">회원 탈퇴</a></li>
	</ul>
	<br> 이름 : ${attDTO.memberName }
	<br> 아이디 : ${attDTO.memberId }
	<br> 주소 : ${attDTO.memberAddr }
	<br> 상세주소 : ${attDTO.memberAddrDetail }
	<br> 우편번호 : ${attDTO.memberPost }
	<br> 연락처 1 : ${attDTO.memberPhone1 }
	<br> 연락처 2 : ${attDTO.memberPhone2 }
	<br> 성별 : <c:if test = "${attDTO.gender == 'M'}">남자</c:if>
			   <c:if test = "${attDTO.gender == 'F'}">여자</c:if>
	<br> 등록일 : ${attDTO.memberRegist }
	<br> 생년월일 : ${attDTO.memberBirth }
	<br> 이메일 : ${attDTO.memberEmail }
</body>
</html>