<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsModify.jsp</title>
</head>
<body>
	<ul>
		<li><a href = "<c:url value = '/' />">홈으로 이동</a></li>
		<li><a href = "goodsList.goods">상품 관리</a></li>
		<li><a href="goodsWrite.goods">상품 추가</a></li>
		<li><a href="goodsIpgo.ipgo">상품 입고</a></li>
		<li><a href="goodsIpgoList.ipgo">상품 입고 현황</a></li>
	</ul>

<form action="goodsModify.goods" method="post" >
<table border=1 align="center" width="600">
	<caption> 상품 상세보기</caption>
	<tr><th width="150" >상품번호</th>
		<td><input type="text" name="goodsNum" id = "goodsNum" value="${dto.goodsNum }" readonly="readonly"></td></tr>
	<tr><th width="150" >상품명</th>
		<td><input type="text" name="goodsName" id = "goodsName" value="${dto.goodsName }"></td></tr>
	<tr><th>상품가격</th>
		<td><input type="text" name="goodsPrice" id = "goodsPrice" value="${dto.goodsPrice }"></td></tr>
	<tr><th>상품설명</th>
		<td><textarea rows="10" cols="45" name="goodsContent" id = "goodsContent">${dto.goodsContent }</textarea></td></tr>
	<tr><th>조회수</th>
		<td><input type="text" name="visitCount" id = "visitCount" value="${dto.visitCount }" readonly="readonly"></td></tr>
	<tr><th>등록한 사원</th>
		<td><input type="text" name="empNum" id = "empNum" value="${dto.empNum }" readonly="readonly"></td></tr>
	<tr><th>등록일</th>
		<td><input type="text" name="goodsRegist" id = "goodsRegist" value="${dto.goodsRegist }" readonly="readonly"></td></tr>
	<tr><th>마지막 수정 사원</th>
		<td><input type="text" name="updateEmpNum" id = "updateEmpNum" value="${dto.updateEmpNum }" readonly="readonly"></td></tr>
	<tr><th>마지막 수정일</th>
		<td><input type="text" name="goodsUpdateDate" id = "goodsUpdateDate" value="${dto.goodsUpdateDate }" readonly="readonly"></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="수정완료" />
		<button type="button" onclick="">수정취소</button> 
		<button type="button" onclick="">상품목록</button></th></tr>
</table>
</form>
</body>
</html>