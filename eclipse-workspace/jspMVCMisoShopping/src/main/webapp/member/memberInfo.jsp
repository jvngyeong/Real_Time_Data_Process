<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
</head>
<body>
	회원상세정보 페이지입니다.
	<br> 회원번호 : ${attDTO.memberNum }
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
	<br>
	<a href="memberModify.mem?memberNum=${attDTO.memberNum }">수정</a> |
	<a href="memberDelete.mem?memberNum=${attDTO.memberNum }">탈퇴</a>
	<a href = "memberList.mem">회원 리스트로 이동</a>
</body>
</html>