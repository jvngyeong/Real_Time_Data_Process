<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsIpgoUpdate.jsp</title>
</head>
<body>
	<ul>
		<li><a href = "<c:url value = '/' />">홈으로 이동</a></li>
		<li><a href = "goodsList.goods">상품 리스트</a></li>
		<li><a href="goodsWrite.goods">상품 추가</a></li>
		<li><a href="goodsIpgo.ipgo">상품 입고</a></li>
		<li><a href="goodsIpgoList.ipgo">상품 입고 현황</a></li>
	</ul>
<form action="goodsIpgoModify.ipgo" method="post">
입고번호 : <input type="text" name="ipgoNum" readonly="readonly" 
				value="${dto.ipgoNum }"/><br />
상품번호 : <input type="text" name="goodsNum" readonly="readonly" 
				value="${dto.goodsNum }"/><br />
상품명 : <input type="text" name="goodsName" readonly="readonly" 
				value="${goodsName }" /><br />
입고일 : <input type="date" name="ipgoDate" value="${dto.ipgoDate }" /><br />
입고 수량 : <input type="number" name="ipgoQty" value="${dto.ipgoQty }"/><br />
제조일 : <input type="datetime-local" name="madeDate" value="${madeDate }"/><br />
가격 : <input type="number" name="ipgoPrice" value="${dto.ipgoPrice }"/><br />
등록한 사원 : <input type="text"  value="${dto.empNum }" readonly="readonly"/><br />
<input type="submit" value="수정완료" />
</form>
</body>
</html>