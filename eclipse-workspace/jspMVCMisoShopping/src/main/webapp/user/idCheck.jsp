<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ='c' uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type = "text/javascript">
	$(function(){
		$("#btn").click(function(){
			var userId = $("#userId").val();
			//부모 창에서 ID가 userID인 요소를 찾아서 val값을 할당해줌
			$(opener.document).find("#userId").val(userId);
			window.self.close();
		});
	});
</script>
</head>
<body>
	<form action = "idCheck.nhn" method = "post">
		검색 : <input type = "search" name = "userId" id = "userId" value = "${userId }"/><br />
		<input type = "submit" value = "아이디 검색" />
		<c:if test="${empty auth }">
			<div>사용 가능한 아이디입니다.</div>
			<div><button type = "button" id = "btn">아이디 사용</button></div>
		</c:if>
		<c:if test="${!empty auth }">
			<div>사용중인 아이디입니다.</div>
		</c:if>
	</form>
</body>
</html>