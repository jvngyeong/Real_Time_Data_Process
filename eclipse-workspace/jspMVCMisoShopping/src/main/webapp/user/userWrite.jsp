<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userWrite.jsp</title>
<script src = "https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script src = "https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type = "text/javascript" src = "js/daumAddressScript.js"></script>
<script type = "text/javascript">
	//function pwCon(){
		//var pw = document.getElementById("userPw").value;
		//var pwCon = document.getElementById("userPwCon").value;
		//if(pw != pwCon){
		//	alert("비밀번호 확인이 틀렸습니다.");
		//	event.preventDefault();
		//}
	//}
	$(function(){
		$("#frm").submit(function(){
			if ($("#userPw").val() != $("#userPwCon").val()){
				alert("비밀번호 확인이 틀렸습니다.");
				$("#userPw").val("");
				$("#userPwCon").val("");
				$("#userPw").focus();
				return false;
			}
		});
		$("#userId").bind("click", function(){
			$("#userId").val("");
			window.open("idCheck.nhn", "아이디 검색", "width = 400, height = 200, left = 130, top = 150");
		});
	});
</script>
</head>
<body>
<form action = "userRegist.nhn" method = "post" id = "frm">
	<table border = "1" align = "center">
	<caption>회원 가입 페이지</caption>
		<tr>
			<td>*아이디</td>
			<td><input type = "text" name = "userId" id = "userId" required="required"  value = "${userId }" readonly><a href = "idCheck.nhn">아이디 중복확인</a></td>
		</tr>
		<tr>
			<td>*비밀번호</td>
			<td><input type = "password" name = "userPw" id = "userPw" required="required"></td>
		</tr>
		<tr>
			<td>*비밀번호확인</td>
			<td><input type = "password" name = "userPwCon" id = "userPwCon" required="required"></td>
		</tr>
		<tr>
			<td colspan = "2">*회원기본정보</td>
		</tr>
		<tr>
			<td>*회원이름</td>
			<td><input type = "text" name = "userName" required="required"></td>
		</tr>
		<tr>
			<td>*회원 연락처1</td>
			<td><input type = "tel" name = "userPhone1" required="required"></td>
		</tr>
		<tr>
			<td>*회원 연락처2</td>
			<td><input type = "tel" name = "userPhone2" required="required"></td>
		</tr>
		<tr>
			<td>*회원 주소</td>
			<td>
			<input type = "text" name = "userAddr" id = "sample4_roadAddress" required="required" readonly>
			<button type = "button" onclick="execDaumPostcode();">우편번호 검색</button>	
			</td>
		</tr>
		<tr>
			<td>*회원 상세주소</td>
			<td><input type = "text" name = "userAddrDetail" required="required"></td>
		</tr>
		<tr>
			<td>*회원 우편번호</td>
			<td><input type = "text" name = "userPost" id = "sample4_postcode" required="required" readonly></td>
		</tr>
		<tr>
			<td>*회원 이메일</td>
			<td><input type = "email" name = "userEmail" required="required"></td>
		</tr>
		<tr>
			<td>*회원 생년월일</td>
			<td><input type = "Date" name = "userBirth" required="required"></td>
		</tr>
		<tr>
			<td>*성별</td>
			<td>
				<input type = "radio" name = "gender" value = "M" checked="checked"/> 남자
				<input type = "radio" name = "gender" value = "F" /> 여자
			</td>
		</tr>
		<tr align="center">
			<td colspan = "2"><input type = "submit" value = "회원가입" />
			<button type = "submit" onclick = "javascript:location.href='index.jsp'">회원가입 취소</button></td>
		</tr>
	</table>
</form>
</body>
</html>