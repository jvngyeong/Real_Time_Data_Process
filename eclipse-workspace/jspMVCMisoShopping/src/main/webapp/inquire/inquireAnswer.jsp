<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inquire/inquireAnswer.jsp</title>
</head>
<body>
	<form action = "inquireAnswer" method = "post">
			<input type = "hidden" name = "inquireNum" value = "${dto.inquireNum }"/>
	<table width="600" border='1'>
		<tr>
			<th>문의 번호</th>
			<td>${dto.inquireNum }</td>
		</tr>
		<tr>
			<th>질문일</th>
			<td>${dto.inquireDate }</td>
		</tr>
		<tr>
			<th>질문자</th>
			<td>${dto.memberNum }</td>
		</tr>
		<tr>
			<th>문의 제목</th>
			<td>${dto.inquireSubject }</td>
		</tr>
		<tr>
			<th>문의 내용</th>
			<td>${fn:replace(dto.inquireContents, newLine, '<br />') }</td>
		</tr>
		<tr>
			<th>답변한 사람</th>
			<td>${dto.empNum }</td>
		</tr>
		<tr>
			<th>답변일</th>
			<td>${dto.inquireAnswerDate }</td>
		</tr>
		<tr>
			<th>문의 답변</th>
			<td>
				<textarea rows="10" cols="50" name = "inquireAnswer">${dto.inquireAnswer }</textarea>
			</td>
		</tr>
		<tr>
			<th colspan = '2'>
				<input type = "submit" value = "답변하기" />
			</th>
		</tr>
	</table>
	</form>
</body>
</html>