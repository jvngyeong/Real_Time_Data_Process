<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeList.jsp</title>
</head>
<body>
	직원 목록입니다.
	<br>
	<a href="employeeWrite.emp">직원 등록 페이지</a>	<br />
	직원 수 : ${list.size() }
	<table border="1">
		<tr>
			<td>직원번호</td>
			<td>이름</td>
			<td>아이디</td>
			<td>고용일</td>
		</tr>
		<c:forEach items = "${list }" var = "list">
			<tr>
				<td><a href = "employeeDetail.emp?empNum=${list.empNum }">${list.empNum }</a></td>
				<td><a href = "employeeDetail.emp?empnum=${list.empNum }">${list.empName }</a></td>
				<td>${list.empId }</td>
				<td>${list.empHireDate }</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href = "index.jsp">메인화면으로 돌아가기</a>
</body>
</html>