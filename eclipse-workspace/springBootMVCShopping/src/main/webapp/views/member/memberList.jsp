<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
</head>
<body>
	회원 목록입니다.<br/>
	<a href = "memberWrite.mem">회원 등록</a><br/>
	회원 수 : ${list.size() }
	<table border = "1">
		<tr>
			<td>회원번호</td>
			<td>이름</td>
			<td>아이디</td>
			<td>가입일</td>
		</tr>
		<c:forEach items = "${list }" var = "dto">
			<tr>
				<td>
					<a href = "memberDetail.mem?memberNum=${dto.memberNum }">${dto.memberNum }</a>
				</td>
				<td>
					<a href = "memberDetail.mem?memberNum=${dto.memberNum }">${dto.memberName }</a>
				</td>
				<td>
					${dto.memberId }
				</td>
				<td>
					${dto.memberRegist }
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href = "index.jsp">메인화면으로 돌아가기</a><br/>
</body>
</html>