<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type = "text/javascript">
	$(function(){
		$("#cartBtn").click(function(){
			if(${!empty auth}){
				$.ajax({
					type : "post",
					url : "cart.item",
					data : {"goodsNum" : "${dto.goodsNum}" , "cartQty" : $("#cartQty").val()},
					success : function(){
						con = confirm("장바구니로 이동하시겠습니까?");
						if(con){
							location.href = "cartList.item";
						}
						else{
							document.location.reload();
						}
					},
					error : function(){
						alert("로그아웃 되었습니다. 다시 로그인해주세요.");
						window.open("loginCk.login", "loginCk", "width = 400, height = 400");
					}
				});
			} 
			else {
				window.open("loginCk.login", "loginCk", "width = 400, height = 400");
			}
		});
		
		
		$("#wish").click(function(){
			//ajax는 JQuery에 포함되어있으며, ajax 메서드에 값을 넣을때는 JSON 형식(키 : 값)으로 넣어야함.
			$.ajax({
				type : "post",
				url : "wishItem.item",
				data : {"goodsNum":"${dto.goodsNum }"},
				success : function(){
					if($("#wish").attr("src") == "images/hart1.jpg"){
						$("#wish").attr("src", "images/hart.jpg");
					}
					else{
						$("#wish").attr("src", "images/hart1.jpg");
					}
				},
				error : function(){
					alert("로그인이 필요합니다.");
					location.href = "<c:url value = '/' />";
					return false;
				}
			}); 
		});
	});
</script>
<meta charset="UTF-8">
<title>detailView.jsp</title>
</head>
<body>
<ul><li><a href = "<c:url value = '/' />">홈으로 이동</a></li></ul>
	<table width="800" align="center">
		<caption>${dto.goodsName } 상품정보입니다.</caption>
		<tr>
			<td rowspan="5">
				<img src="goods/upload/${dto.goodsMainImage }" height="200" /></td>
			<td>${dto.goodsName }</td>
		</tr>
		<tr>
			<td>${dto.goodsPrice }원</td>
		</tr>
		<tr>
			<td>조회수 : ${dto.visitCount }</td>
		</tr>
		<tr>
			<td>
				수량 : <input type="number" min="1" step="1" value="1" id="cartQty" />
			</td>
		</tr>
		<tr>
			<td><button type="button" id="cartBtn">장바구니</button> |
				<button type="button" id="buyItem">바로구매</button> | 
				<c:if test="${empty isTrue }">
					<img src="images/hart1.jpg" width="20" id="wish" />
				</c:if>
				<c:if test="${!empty isTrue }">
					<img src="images/hart.jpg" width="20" id="wish" />
				</c:if>
				찜
				
			</td>
		</tr>
		<tr>
			<td colspan="2"><span id="descript">제품 상세 설명</span> | 
			<span id="review">리뷰</span> | <span id="inquire" onclick="">상품문의</span></td>
		</tr>
		<tr>
			<td colspan="2"><div id="content"></div></td>
		</tr>
	</table>
</body>
</html>