<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>goodsList.jsp</title>
</head>
<body>
	<ul>
		<li><a href = "<c:url value = '/' />">홈으로 이동</a></li>
		<li><a href = "goodsList.goods">상품 리스트</a></li>
		<li><a href="goodsWrite.goods">상품 추가</a></li>
		<li><a href="goodsIpgo.ipgo">상품 입고</a></li>
		<li><a href="goodsIpgoList.ipgo">상품 입고 현황</a></li>
	</ul>
<table border=1 width="600" align="center">
	<caption>상품 목록</caption>
	<tr><th>번호</th><th>상품번호</th><th>상품명</th><th>상품가격</th></tr>
	<c:set var="i" value="1" />
	<c:forEach items="${list }" var="list" >
		<tr>
			<th><a href = "goodsInfo.goods?goodsNum=${list.goodsNum }">${i }</a></th>
			<th><a href = "goodsInfo.goods?goodsNum=${list.goodsNum }">${list.goodsNum }</a></th>
			<th>${list.goodsName }</th>
			<th>${list.goodsPrice }</th>
		</tr>
		<c:set var="i" value = "${i + 1 }"></c:set>
		
	</c:forEach>
</table>
</body>
</html>