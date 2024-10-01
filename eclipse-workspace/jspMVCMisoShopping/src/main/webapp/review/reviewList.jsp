<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = 'c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = 'fn' uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review/reviewList.jsp</title>
</head>
<body>
	<table width = "800" align = "center" border = '1'>
		<tr>
			<td>
				아이디 | 작성일
			</td>
			<td>
				내용
			</td>
		</tr>
		<c:forEach items="${list }" var = "list">
			<tr>
				<td>
					${list.memberId } | ${list.reviewDate }
				</td>
				<td>
					${fn:replace(list.reviewContent, newLine, '<br />') }
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr />
</body>
</html>