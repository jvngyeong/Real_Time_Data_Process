<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<meta charset="UTF-8">
<title>inquire/inquireList.jsp</title>
<script type = "text/javascript">
	$(function(){
		$("#inquire1").click(function(){
			window.open("inquireWrite.inq?goodsNum=${goodsNum}", "문의하기", "width=700, height=650, top=100, left=100");
		});
	});
</script>
</head>
<body>
	<table width = "800" align = "center" border = "1">
		<tr>
			<td colspan = "3" align = "right">
				<button type = "button" id = "inquire1">문의 하기</button>
			</td>
		</tr>
		<tr>
			<th width = "15%">
				답변 상태
			</th>
			<th>
				작성자
			</th>
			<th>
				질문일자
			</th>
		</tr>
		<c:forEach items="${list }" var = "list">
			<tr>
				<th>
					<c:if test="${empty list.inquireAnswer}">
						답변 대기
					</c:if>
					<c:if test="${!empty list.inquireAnswer}">
						답변 완료
					</c:if>
				</th>
				<th>
					${list.memberNum }
				</th>
				<th>
					${list.inquireDate }
				</th>
			</tr>
			<tr>
				<td>
					${list.inquireSubject }
				</td>
				<td colspan = '2'>
					${list.inquireContents }
				</td>
			</tr>
		</c:forEach>
			<tr>
				<th>
					제목
				</th>
				<th colspan = '2'>
					내용
				</th>
			</tr>
	</table>
</body>
</html>