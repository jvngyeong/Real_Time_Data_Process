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
	<table width="800" align="center" border = "1">
		<tr>
			<td>주문번호 / 결제번호</td> <td>상품명</td> <td>주문상태</td><td>현재 상태</td>
		</tr>
		<c:forEach items="${list }" var="dto">
	        <tr>
	            <td>${dto.purchaseNum }/ ${dto.purchaseStatus }</td>
	            <td>${dto.goodsName }</td>
	            <td>${dto.purchaseStatus }</td>
	            <td>
	            <c:if test="${empty dto.applDate }">
	            	<a href="paymentOk.item?purchaseNum=${dto.purchaseNum }">결제하기</a>   
	            </c:if>
	            <c:if test="${!empty dto.applDate }">
	            	<c:if test = "${dto.deliveryNum == 0 }">
	            		<a href="paymentDelete.item?purchaseNum=${dto.purchaseNum }">결제취소</a>
	            	</c:if>
	            	<c:if test = "${dto.deliveryNum > 0 }">
	            		${dto.deliveryStatus }
	            		<c:if test="${dto.deliveryStatus == '배송 완료' and dto.purchaseStatus != '구매 확정' }">
	            			| <a href="purchased.item?purchaseNum=${dto.purchaseNum }">구매 확정</a>
	            		</c:if>
	            		
	            		<c:if test="${dto.deliveryStatus == '배송 완료' and dto.purchaseStatus == '구매 확정' }">
	            			| <a href="reviewRegist.review?purchaseNum=${dto.purchaseNum }&goodsNum=${dto.goodsNum}">리뷰 등록 / 수정</a>
	            			<c:if test="${dto.reviewNum != 0 }">
	            			 | <a href = "reviewDelete.review?reviewNum=${dto.reviewNum }">리뷰 삭제</a>
	            			</c:if>
	            		</c:if>
	            	</c:if>
	            </c:if>
	            </td>	
	        </tr>
      	</c:forEach>

	</table>
</body>
</html>