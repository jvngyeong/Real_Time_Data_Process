<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = 'c' uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inquire/inquireUpdate.jsp</title>
</head>
<body>
	<form method = "post" action = "inquireModify.inq">
		<input type = "hidden" value = "${dto.inquireNum }" name = "inquireNum"/>
		<table width="600" align = "center" border = '1'>
			<tr>
				<td>
					<select name = "queryType" >
						<option value = "상품" <c:if test="${dto.inquireKind == '상품' }">selected</c:if>>상품(성능 / 사이즈)</option>
						<option value = "배송" <c:if test="${dto.inquireKind == '배송' }">selected</c:if>>배송</option>
						<option value = "교환" <c:if test="${dto.inquireKind == '교환' }">selected</c:if>>교환</option>
						<option value = "반품 / 취소 / 환불" <c:if test="${dto.inquireKind == '반품 / 취소 / 환불' }">selected</c:if>>반품 / 취소 / 환불</option>
						<option value = "기타" <c:if test="${dto.inquireKind == '기타' }">selected</c:if>>기타</option>
					</select>
				</td>
				<td align = "right">
					<input type = "submit" id = "btnInsert" value = "문의수정" />
				</td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td>
					<input type = "text" name = "inquireSubject" value = "${dto.inquireSubject }"/>
				</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="50" name = "inquireContent">${dto.inquireContents }</textarea>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>