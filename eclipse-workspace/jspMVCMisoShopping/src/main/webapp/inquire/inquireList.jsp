<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inquire/inquireList.jsp</title>
<script type="text/javascript">
	$(function(){
		$("#inquire1").click(function(){
			window.open("inquireWrite.inq?goodsNum=${goodsNum}", "문의하기", "width=700, height=650, top=100, left=100");
		});
	});

	function answerOpen(inquireNum){
		if($("#inqBtn"+inquireNum).text() == '답변 열기'){
			$("#inqBtn"+inquireNum).text('답변 닫기');
			$("#inq"+inquireNum).css("display","");
		}
		else {
			$("#inqBtn"+inquireNum).text('답변 열기');
			$("#inq"+inquireNum).css("display","none");
		}
	}
</script>
</head>
<body>
	<table width="800" align="center" border="1">
		<tr>
			<td colspan="3" align="right">
				<button type="button" id="inquire1">문의 하기</button>
			</td>
		</tr>
		<tr>
			<th width="15%">답변 상태</th>
			<th>작성자</th>
			<th>질문일자</th>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<th><c:if test="${empty list.inquireAnswer}">
						답변 대기
					</c:if> <c:if test="${!empty list.inquireAnswer}">
						답변 완료
					</c:if></th>
				<th>${list.memberNum }</th>
				<th>${list.inquireDate }</th>
			</tr>
			<tr>
				<td>${list.inquireSubject }</td>
				<td colspan='2'>${fn:replace(list.inquireContents, newLine, '<br />')}
				<c:if test="${!empty list.inquireAnswer}">
					<button type = "button" style = "float:right" id = "inqBtn${list.inquireNum}" onclick = "answerOpen('${list.inquireNum}')">답변 열기</button>
				</c:if>				
					<c:if test="${memberNum == list.memberNum}">
						<span style="float: right;">
							<button onclick="inquireUpdate(${list.inquireNum})">수정</button>
							<button onclick="inquireDelete(${list.inquireNum})">삭제</button>
						</span>
					</c:if>
				</td>
			</tr>
			<c:if test="${!empty list.inquireAnswer}">
				<tr style = "display:none" id = "inq${list.inquireNum }">
					<th>답변</th>
					<th colspan='2'>
					${fn:replace(list.inquireAnswer, newLine, '<br />') }
					</th>
				</tr>
			</c:if>
		</c:forEach>
		<tr>
			<th>제목</th>
			<th colspan='2'>내용</th>
		</tr>
	</table>
</body>
</html>