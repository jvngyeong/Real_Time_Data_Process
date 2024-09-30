<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item/purchaseList.jsp</title>
</head>
<body>
	<table width="800" align="center">
		<tr>
			<td>주문번호 / 결제번호</td> <td>상품명</td> <td>주문상태</td>
		</tr>
		<c:forEach items="${list }" var="dto">
	        <tr>
	            <td>${dto.purchaseNum }/ 결제대기중</td>
	            <td>${dto.goodsName }</td>
	            <td> ${dto.purchaseStatus }</td>
	            <td>
	            <c:if test="${empty dto.applDate }">
	            	<a href="paymentOk.item?purchaseNum=${dto.purchaseNum }">결제하기</a>   
	            </c:if>
	            <c:if test="${!empty dto.applDate }">
	            	<a href="paymentDelete.item?purchaseNum=${dto.purchaseNum }">결제취소</a>
	            </c:if>
	            </td>	
	        </tr>
      	</c:forEach>

	</table>
</body>
</html>