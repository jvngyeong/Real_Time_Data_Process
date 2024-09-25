<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = 'c' uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartList.jsp</title>
</head>
<body>
	<caption>장바구니입니다.</caption>
	<table border = "1" width = "600" align = "center">
		<tr>
			<td>번호</td>
			<td>이미지</td>
			<td>제품 이름</td>
			<td>수량</td>
			<td>합계 금액</td>
		</tr>
		<c:forEach items="${list }" var = "list" varStatus = "idx">
			<tr>
				<td>
					${idx.count }
				</td>
				<td>
					<img src = "goods/upload/${list.goodsImage }" width = "100" />
				</td>
				<td>
					${list.goodsName }
				</td>
				<td>
					<a href = "#">[ - ]</a>
					${list.cartQty }
					<a href = "#">[ + ]</a>
				</td>
				<td>
					${list.totalPrice }
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>