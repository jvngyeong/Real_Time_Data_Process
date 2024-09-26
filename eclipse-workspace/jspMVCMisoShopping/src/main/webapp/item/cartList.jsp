<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = 'c' uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type = "text/javascript">
	$(function(){
		$("#checkBoxes").click(function(){
			if($("#checkBoxes").prop("checked")){
				$(":checkbox[name = 'prodCk']").prop("checked", true);
			}
			else{
				$(":checkbox[name = 'prodCk']").prop("checked", false);
			}
			prodChk();
		});
		
		$(":checkbox[name = 'prodCk']").click(function(){
			var checkCnt = $(":checkbox[name = 'prodCk']").length;
			var checked = $(":checkbox[name = 'prodCk']:checked").length;
			if(checkCnt == checked){
				$("#checkBoxes").prop("checked", true);
			} else {
				$("#checkBoxes").prop("checked", false);
			}
			prodChk();
		});
	});
	
	function prodChk(){
		var cnt = $(":checkbox[name='prodCk']:checked").length; // 상품 수
		var totalQty = 0; // 총 상품 수량
		var totalPrice = 0; // 총 상품 금액
		var checkBoxCnt = $(":checkbox[name = 'prodCk']").length;
		for(var idx = 0; idx < checkBoxCnt; idx++){
			if($(":checkbox[name = 'prodCk']")[idx].checked){
				totalPrice += Number($(".realPrice:eq("+idx+")").val());
				totalQty += Number($(".cartQty:eq("+idx+")").text());
			}
		}
		$("#prodCnt").text(cnt);
		$("#totQty").text(totalQty);
		$("#totalPrice").text(totalPrice);
	}
	
	function goodsCartAdd(goodsNum, idx, goodsPrice){
		option = {
			type : "post",
			url : "cart.item",
			data : {"goodsNum" : goodsNum, "cartQty" : 1},
			success : function(){
				$(".cartQty:eq("+idx+")").text(Number($(".cartQty:eq("+idx+")").text()) + 1);
				$(".cartPrice:eq("+idx+")").text(Number($(".cartPrice:eq("+idx+")").text()) + goodsPrice);
			},
			error : err,
			complete : prodChk	//ajax에서 메서드를 실행시킬때는 괄호를 안침!!!!!!!!
		};
		$.ajax(option);
	}
	
	function err(){
		alert("로그아웃 되었습니다. 다시 로그인해주세요.");
		window.open("loginCk.login", "loginCk", "width = 400, height = 400");
	}
	
	function checkQty(goodsNum, idx, goodsPrice){
		var val = Number($(".cartQty:eq("+idx+")").text());
		if(val <= 1) alert("최소 수량은 1개입니다.");
		else{
			$.ajax({
				type : "post",
				url : "cartQtyDown.item",
				data : {"goodsNum" : goodsNum},
				success : function(){
					$(".cartQty:eq("+idx+")").text(Number($(".cartQty:eq("+idx+")").text()) - 1);
					$(".cartPrice:eq("+idx+")").text(Number($(".cartPrice:eq("+idx+")").text()) - goodsPrice);
				},
				error : err,
				complete : prodChk
			});
		}
	}
	
	function itemDel(goodsNum){
		con = confirm("정말 삭제하시겠습니까?");
		if(con){
			location.href = "cartItemsDel.item?goodsNums="+goodsNum;
		}
	}
	
	function itemsDel(){
		if($(":checkbox[name = 'prodCk']:checked").length <= 0){
			alert("선택한 상품이 존재하지 않습니다.");
		}
		else{
			con = confirm("정말 삭제하시겠습니까?");
			var goodsNums = "";
			if(con){
				$(":checkbox[name = 'prodCk']:checked").each(function(){
					goodsNums += $(this).val() + "-";
				});
				location.href = "cartItemsDel.item?goodsNums="+goodsNums;
			}
		}
	}
	
	function goodsCheck(){
		if($(":checkbox[name = 'prodCk']:checked").length <= 0){
			alert("하나 이상의 상품을 선택해야합니다.");
			return false;
		}
		else{
			
		}
	}
</script>
<meta charset="UTF-8">
<title>cartList.jsp</title>
</head>
<body>
	<ul><li><a href = "<c:url value = '/' />">홈으로 이동</a></li></ul>
	<form action = "itemBuy.item" method = "post" onsubmit = "return goodsCheck()">
		<table border = "1" width = "600" align = "center">
			<caption>장바구니입니다.</caption>
			<tr>
				<td>
					<input type = "checkbox" id = "checkBoxes" />
				</td>
				<td>번호</td>
				<td>이미지</td>
				<td>제품 이름</td>
				<td>수량</td>
				<td>합계 금액</td>
				<td><button type = "button" onclick="itemsDel()">선택 삭제</button></td>
			</tr>
			<c:forEach items="${list }" var = "list" varStatus = "idx">
				<tr>
					<td>
						<input type = "checkbox" name = "prodCk" value = "${list.goodsNum }" />
					</td>
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
						<a href = "javascript:checkQty('${list.goodsNum }', ${idx.index }, ${list.goodsPrice })">[ - ]</a>
							<span class = "cartQty">
								${list.cartQty }
							</span>
						<a href = "javascript:goodsCartAdd('${list.goodsNum }', ${idx.index }, ${list.goodsPrice })">[ + ]</a>
					</td>
					<td>
						<span class = "cartPrice">
							<input type = "hidden" class = "realPrice" value="${list.totalPrice }" />
							<fmt:formatNumber value="${list.totalPrice }" type="currency" />원
						</span>
					</td>
					<td>
						<button type = "button" onclick="itemDel('${list.goodsNum }')">삭제</button>
					</td>
				</tr>
			</c:forEach>
			<tr>
	         	<td colspan="7" align="right">
	         	상품수 : <span id="prodCnt">0</span>개<br /> 
	         	총수량 : <span id="totQty">0</span>개 <br /> 
	         	총금액 : <span id="totalPrice">0</span>원 <br />
	         	</td>
	     	</tr>
	  		<tr>
	  			<td colspan = "7" align = "right">
	  				<input type = "submit" value = "구매하기" />
	  			</td>
	  		</tr>
		</table>
	</form>
</body>
</html>