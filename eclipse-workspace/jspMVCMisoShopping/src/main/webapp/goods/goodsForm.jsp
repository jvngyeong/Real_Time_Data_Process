<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsForm.jsp</title>
</head>
<body>
	<ul>
		<li><a href = "<c:url value = '/' />">홈으로 이동</a></li>
		<li><a href = "goodsList.goods">상품 리스트</a></li>
		<li><a href="goodsWrite.goods">상품 추가</a></li>
		<li><a href="goodsIpgo.ipgo">상품 입고</a></li>
		<li><a href="goodsIpgoList.ipgo">상품 입고 현황</a></li>
	</ul>
	
<form action="goodsRegist.goods" method="POST">
<table border = "1" width ="600" align="center">
	<tr><th width="100">상품번호</th>
		<td><input type="text" name="goodsNum" readonly="readonly" value = "${maxNum }"/>번호자동부여</td></tr>
	<tr><th>상품명</th>
		<td><input type="text" name="goodsName"/></td></tr>
	<tr><th>상품가격</th>
		<td><input type="number" name="goodsPrice"/></td></tr>
	<tr><th>상품설명</th>
		<td><textarea rows="10" cols="50" name="goodsContent"></textarea></td></tr>
	<tr><th colspan="2"><input type="submit" value="상품등록" /></th></tr>
</table>	
</form>
</body>
</html>