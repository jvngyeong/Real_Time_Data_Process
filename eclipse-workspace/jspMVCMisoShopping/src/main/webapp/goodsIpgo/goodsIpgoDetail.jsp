<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function ipgoUpdate(){
	location.href="goodsIpgoUpdate.ipgo?ipgoNum=${dto.ipgoNum}";
}
function ipgoDelete(){
	location.href="goodsIpgoDelete.ipgo?ipgoNum=${dto.ipgoNum}";
}
</script>
</head>
<body>
	<ul>
		<li><a href = "<c:url value = '/' />">홈으로 이동</a></li>
		<li><a href = "goodsList.goods">상품 리스트</a></li>
		<li><a href="goodsWrite.goods">상품 추가</a></li>
		<li><a href="goodsIpgo.ipgo">상품 입고</a></li>
		<li><a href="goodsIpgoList.ipgo">상품 입고 현황</a></li>
	</ul>
입고번호 : ${dto.ipgoNum } <br />
상품번호 : ${dto.goodsNum }<br />
상품명 : ${goodsName }<br />
입고일 : ${dto.ipgoDate }<br />
입고 수량 : ${dto.ipgoQty }<br />
제조일 : ${dto.madeDate }<br />
가격 : ${dto.ipgoPrice }<br />
등록한 사원 : ${dto.empNum }<br />
<button type="button" onclick="ipgoUpdate()">입고 수정</button> | 
<button type="button" onclick="ipgoDelete()">입고 삭제</button>
</body>
</html>