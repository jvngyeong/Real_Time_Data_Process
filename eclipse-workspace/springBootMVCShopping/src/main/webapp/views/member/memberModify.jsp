<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br> 
	<form action = "memberUpdate.mem" method = "post">
		회원번호 : <input type = "text" name = "memberNum" value = ${attDTO.memberNum } readonly />
	<br> 이름 : <input type = "text" name = "memberName" value = ${attDTO.memberName } />
	<br> 아이디 : <input type = "text" name = "memberId" value = ${attDTO.memberId } />
	<br> 주소 : <input type = "text" name = "memberAddr" value = ${attDTO.memberAddr } />
	<br> 상세주소 : <input type = "text" name = "memberAddrDetail" value = ${attDTO.memberAddrDetail } />
	<br> 우편번호 : <input type = "text" name = "memberPost" value = ${attDTO.memberPost } />
	<br> 연락처 1 : <input type = "tel" name = "memberPhone1" value = ${attDTO.memberPhone1 } />
	<br> 연락처 2 : <input type = "tel" name = "memberPhone2" value = ${attDTO.memberPhone2 } />
	<br> 성별 : 
	<input type = "radio" name="gender" value = "M" ${attDTO.gender == 'M' ? 'checked': ''} /> 남자
	<input type = "radio" name="gender" value = "F" ${attDTO.gender == 'F' ? 'checked' : '' } /> 여자
	<br> 등록일 : <input type = "date" name = "memberRegist" value = ${attDTO.memberRegist } readonly />
	<br> 생년월일 : <input type = "date" name = "memberBirth" value = ${attDTO.memberBirth } />
	<br> 이메일 : <input type = "text" name = "memberEmail" value = ${attDTO.memberEmail } />
	<br> <input type = "submit" value = "수정" /> <input type = "button" onclick="javascript:location.href = 'memberList.mem'" value = "회원 리스트로 이동"/>
	</form>

</body>
</html>