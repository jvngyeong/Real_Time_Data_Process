<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeDetail.jsp</title>
</head>
<body>
	직원번호 :	${dto.empNum }<br />
	아이디 : ${dto.empId }<br />
	비밀번호 : ${dto.empPw }<br />
	이름 : ${dto.empName }<br />
	주소 : ${dto.empAddr }<br />
	상세주소 : ${dto.empAddrDetail }<br />
	우편번호 : ${dto.empPost }<br />
	전화번호 : ${dto.empPhone }<br />
	주민번호 : ${dto.empJumin }<br />
	이메일 : ${dto.empEmail }<br />
	고용일 : ${dto.empHireDate }<br />
	직원 이미지 : <img alt="" src="${dto.empImage }" /><br />
	<a href = "employeeModify.emp?empNum=${dto.empNum }">수정</a> |
	<a href = "employeeDelete.emp?empNum=${dto.empNum }">삭제</a>
</body>
</html>