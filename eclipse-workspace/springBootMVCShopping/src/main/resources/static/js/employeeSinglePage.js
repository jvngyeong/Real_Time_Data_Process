/**
 * 
 */
$(function(){
	$.ajax({
		type : "post",
		url : "/myPage/empMyPage",
		success : function(result){	//여기서 result는 empMyPage 주소로 가서 실행된 메서드의 반환 값 ModelAndView!
			var enterDate = new Date(result.employeeCommand.empHireDate);
			var enterYear = enterDate.getFullYear();
			var enterMonth = ("0"+(enterDate.getMonth() + 1)).slice(-2);
			var enterDay = ("0"+enterDate.getDate()).slice(-2);

			var item = "";
			
			item += "<table border=1 width=500><tr><th>이름</th><th>";
			item += result.employeeCommand.empName + " </th></tr><tr><th>아이디</th><th>";
			item += result.employeeCommand.empId + "</th></tr><tr><th>주소</th><th>";
			item += result.employeeCommand.empAddr + "</th></tr><tr><th>상세주소</th><th>";
			item += result.employeeCommand.empAddrDetail + "</th></tr><tr><th>우편번호</th><th>";
			item += result.employeeCommand.empPost + "</th></tr><tr><th>연락처</th><th>";
			item += result.employeeCommand.empPhone + "</th></tr><tr><th>주민번호</th><th>";
			item += result.employeeCommand.empJumin + "</th></tr><tr><th>입사일</th><th>";
			item += enterYear+"-"+enterMonth+"-"+enterDay + "</th></tr><tr>";
			item += "<th>이메일</th><th>" + result.employeeCommand.empEmail+"</th>";
			item += "</tr><tr><th>이미지</th><th><img src = '/static/images/tokki.PNG' /></th></tr></table>";
			$("#content").html(item);
		},
		error : function(){
			alert("서버 오류");
		}
	});
});
function empPw(){
	$("#empForm").css("display", "none");
	$("#content").css("display", "block");
	var item = "";
	item += '<form action="empPwPro" method="post" id="frm">';
	item +=	'현재 비밀번호 : <input type="password" name="oldPw" id="oldPw" required="required"><br />';
	item += '새 비밀번호 : <input type="password" name="newPw" id="newPw" required="required"><br />';
	item +=	'<input type="submit" value="변경" />';
	item += '</form>';
	$("#content").html(item);
}
function empModify(){
	$.ajax({
		type : "get",
		url : "/myPage/empModify",
		success : function(result){	//result ==> map
			console.log(result);
			$("#content").css("display", "none");
			$("#empForm").css("display", "block");
			var enterDate = new Date(result.employeeCommand.empHireDate);
			var enterYear = enterDate.getFullYear();
			var enterMonth = ("0"+(enterDate.getMonth() + 1)).slice(-2);
			var enterDay = ("0"+enterDate.getDate()).slice(-2);
			
			$("#empNum").val(result.employeeCommand.empNum);
			$("#empId").val(result.employeeCommand.empId);
			$("#empName").val(result.employeeCommand.empName);
			$("#empAddr").val(result.employeeCommand.empAddr);
			$("#empAddrDetail").val(result.employeeCommand.empAddrDetail);
			$("#empPost").val(result.employeeCommand.empPost);
			$("#empPhone").val(result.employeeCommand.empPhone);
			$("#empJumin").val(result.employeeCommand.empJumin);
			$("#empEmail").val(result.employeeCommand.empEmail);
			$("#empImage").val(result.employeeCommand.empImage);
			$("#empHireDate").val(enterYear+"-"+enterMonth+"-"+enterDay);
		},
		error : function(){
			alert("서버 오류");
		}
	});
}