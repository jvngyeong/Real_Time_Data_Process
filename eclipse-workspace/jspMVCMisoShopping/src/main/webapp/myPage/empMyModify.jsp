<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empMyModify.jsp</title>
</head>
<body>
	<ul>
		<li><a href = "<c:url value = '/' />">홈으로 이동</a></li>
		<li><a href = "empMyPage.my">내 정보 보기</a></li>
		<li><a href = "empUpdate.my">내 정보 수정</a></li>
		<li><a href = "empPwModify.my">비밀번호 변경</a></li>
		<li><a href = "goodsList.goods">상품 리스트</a></li>
	</ul>
	
	<form action = "empModify.my" method = "post">
	직원번호 : <input type = "text" name = "empNum" value = "${dto.empNum }" readonly="readonly" /><br />
	아이디 : <input type = "text" name = "empId" value = "${dto.empId }" /><br />
	현재 비밀번호 : <input type = "text" name = "empPw"/><span>${errPw }</span><br />
	이름 : <input type = "text" name = "empName" value = "${dto.empName }" /><br />
	주소 : <input type = "text" name = "empAddr" value = "${dto.empAddr }" /><br />
	상세주소 : <input type = "text" name = "empAddrDetail" value = "${dto.empAddrDetail }" /><br />
	우편번호 : <input type = "text" name = "empPost" value = "${dto.empPost }" /><br />
	전화번호 : <input type = "text" name = "empPhone" value = "${dto.empPhone }" /><br />
	주민번호 : <input type = "text" name = "empJumin" value = "${dto.empJumin }" /><br />
	이메일 : <input type = "email" name = "empEmail" value = "${dto.empEmail }" /><br />
	고용일 : <input type = "date" name = "empHireDate" value = "${dto.empHireDate }" /><br />
	직원 이미지 : <img alt="" src="${dto.empImage }" /><br />
	<br> <input type = "submit" value = "수정" />
	</form>
</body>
</html>