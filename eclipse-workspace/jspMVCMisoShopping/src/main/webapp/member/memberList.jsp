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
			<td>비밀번호</td>
			<td>주소</td>
			<td>상세주소</td>
			<td>우편번호</td>
			<td>연락처</td>
			<td>연락처 2</td>
			<td>성별</td>
			<td>생년월일</td>
			<td>이메일</td>
		</tr>
		<c:forEach items = "${list }" var = "dto">
			<tr>
				<td>
					${dto.memberNum }
				</td>
				<td>
					${dto.memberName }
				</td>
				<td>
					${dto.memberId }
				</td>
				<td>
					${dto.memberPw }
				</td>
				<td>
					${dto.memberAddr }
				</td>
				<td>
					${dto.memberAddrDetail }
				</td>
				<td>
					${dto.memberPost }
				</td>
				<td>
					${dto.memberPhone1 }
				</td>
				<td>
					${dto.memberPhone2 }
				</td>
				<td>
					${dto.gender }
				</td>
				<td>
					${dto.memberBirth }
				</td>
				<td>
					${dto.memberEmail }
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>