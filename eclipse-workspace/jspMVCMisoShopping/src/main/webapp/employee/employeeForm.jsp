<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeForm.jsp</title>
</head>
<body>
직원 등록 페이지입니다.<br>
<form action = "employeeRegist.emp" method = "post">
직원번호 : <input type = "text" name = "empNum" value = ${empNum } readonly /><br>
아이디 : <input type = "text" name = "empId" /><br>
비밀번호 : <input type = "password" name = "empPw" /><br>
이름 : <input type = "text" name = "empName" /><br>
주소 : <input type = "text" name = "empAddr" /><br>
상세주소 : <input type = "text" name = "empAddrDetail" /><br>
우편번호 : <input type = "text" name = "empPost" /><br>
전화번호 : <input type = "text" name = "empPhone" /><br>
주민번호 : <input type = "text" name = "empJumin" /><br>
이메일 : <input type = "email" name = "empEmail" /><br>
고용일 : <input type = "date" name = "empHireDate" /><br>
사진 : <input type = "file" name = "empImage" /><br>
<input type = "submit" value = "등록" />
</form>

</body>
</html>