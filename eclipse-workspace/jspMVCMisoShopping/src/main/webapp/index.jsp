<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>

</head>
<body>
	안녕하세요. 미소쇼핑몰입니다.
	<br>
	<br>
	<c:if test="${!empty auth }">
		<ul>
		<!-- 직원이 봐야할 View -->
		<c:if test ="${auth.grade == 'emp' }">
		<li><a href="memberList.mem">회원 목록</a></li>
		<li><a href="employeeList.emp">직원 목록</a></li>
		<li><a href = "empMyPage.my">직원 내 정보 보기</a>
		<li><a href = "goodsList.goods">상품 리스트</a></li>
		<li><a href="memPurchaseList.deli">회원구매정보</a></li>
		<li><a href="inquire.inq">상품문의</a></li>
		</c:if>
		<c:if test ="${auth.grade == 'mem' }">
		<!-- 회원이 봐야할 View -->
		<li><a href = "memberMyPage.my">내 정보 보기</a>
		</c:if>
		<li><a href = "cartList.item">장바구니로 이동</a></li>
		<li><a href = "logout.login">로그아웃</a></li>
		</ul>
	</c:if>

	<c:if test="${empty auth }">
		<form action="login.login" method="post">
			<table border="1" align="center">
				<tr>
					<td colspan="2">로그인 유지 | 아이디 저장</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="userId" placeholder="아이디">
						<div style = "color : red">${errId }</div>
					</td>
					<td rowspan="2"><input type="submit" value="로그인"></td>
				</tr>
				<tr>
					<td>
						<input type="text" name="userPw" placeholder="비밀번호">
						<div style = "color : red">${errPw }</div>
					</td>
				</tr>
				<tr>
					<td colspan="2"><a href="idInquiry.help">아이디</a> / <a
						href="pwInquiry.help">비밀번호 찾기</a> | <a href="userAgree.nhn">회원가입</a></td>
				</tr>
			</table>
		</form>
	</c:if>
	
	<table width = "600" align = "center">
	<tr>
		<c:forEach items="${list }" var = "dto" varStatus = "idx">
			<td>
				<a href = "detailView.item?goodsNum=${dto.goodsNum }">
					<img src = "goods/upload/${dto.goodsMainImage }" width = "300" height = "150"/><br />
					${dto.goodsName }<br />
					${dto.goodsPrice }<br />
				</a>
			</td>
			<c:if test="${idx.count % 3 == 0 }">
				</tr><tr>
			</c:if>
		</c:forEach>
	</tr>
	</table>
</body>
</html>