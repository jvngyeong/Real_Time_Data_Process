<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="<c:url value='/' />">홈으로 이동</a></li>
		<li><a href="memberMyPage.my">내 정보 보기</a></li>
		<li><a href="memberUpdate.my">내 정보 수정</a></li>
		<li><a href="userPwModify.my">비밀번호 변경</a></li>
		<li><a href = "memberDrop.my">회원 탈퇴</a></li>
	</ul>
	
	<form action = "memberModify.my" method = "post">
	<br> 이름 : <input type = "text" name = "memberName" value = "${attDTO.memberName }">
	<br> 아이디 : <input type = "text" name = "memberId" value = "${attDTO.memberId }" readonly="readonly">
	<br> 현재 비밀번호 : <input type = "text" name = "memberPw"><span>${errPw }</span>
	<br> 주소 : <input type = "text" name = "memberAddr" value = "${attDTO.memberAddr }">
	<br> 상세주소 : <input type = "text" name = "memberAddrDetail" value = "${attDTO.memberAddrDetail }">
	<br> 우편번호 : <input type = "text" name = "memberPost" value = "${attDTO.memberPost }">
	<br> 연락처 1 : <input type = "tel" name = "memberPhone1" value = "${attDTO.memberPhone1 }">
	<br> 연락처 2 : <input type = "tel" name = "memberPhone2" value = "${attDTO.memberPhone2 }">
	<br> 성별 : 
	<input type = "radio" name="gender" value = "M" ${attDTO.gender == 'M' ? 'checked': ''}> 남자
	<input type = "radio" name="gender" value = "F" ${attDTO.gender == 'F' ? 'checked' : '' }> 여자
	<br> 등록일 : <input type = "date" name = "memberRegist" value = "${attDTO.memberRegist }" readonly>
	<br> 생년월일 : <input type = "date" name = "memberBirth" value = "${attDTO.memberBirth }">
	<br> 이메일 : <input type = "text" name = "memberEmail" value = "${attDTO.memberEmail }">
	<br> <input type = "submit" value = "수정" />
	</form>
</body>
</html>