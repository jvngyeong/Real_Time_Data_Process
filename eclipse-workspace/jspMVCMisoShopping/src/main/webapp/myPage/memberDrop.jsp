<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   
   <form action = "memberDropOk.my" method = "post">
   비밀번호 : <input type = "password" id = "memberPw" name = "memberPw"/>
   			<input type = "submit" value = "회원탈퇴" />
   			<div style = "color : red" >${errPw }</div>
   </form>
</body>
</html>