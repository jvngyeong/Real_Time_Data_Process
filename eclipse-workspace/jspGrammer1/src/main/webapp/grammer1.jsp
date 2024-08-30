<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
형변환<br/>
<%=(char)65 %><br>
<%=(int)'A' %><br>
<%
	int i = 10;
	out.print(i + "<br>");
	long l = 210000000;
	l = 21000000000L;
	out.print(l + "<br>");
	float f = 0.5f;	//8byte
	out.print(f + "<br>");
	double d = 0.5;
	boolean bl = false;
	out.print(bl + "<br>");
	String str = "10";
	String str1 = "20";
	out.print(Integer.parseInt(str) + Integer.parseInt(str1) + "<br>");
	
	Integer i1 = 10;	//boxing
	i = i1;		//unboxing
%>

배열<br>
<% 
	int[] arrayInt = new int[3];
	arrayInt[0] = 10;
	arrayInt[1] = 20;
	arrayInt[2] = 30;
	
	for(int val : arrayInt){
		out.print(val);
	}
%>

<%
	out.print("<table>");
	int tr = 1;
	while(tr<=9){
		out.print("<tr>");
		int td = 1;
		while(td<=9){
			out.print("<td>" +td+ "</td>");
			td++;
		}
		out.print("</tr>");
		tr++;
	}
	out.print("</table>");
%>

<%
	int num = 12/3;

	switch(num){
	case 1: out.print("1");break;
	case 2: out.print("2");break;
	case 3: out.print("3");break;
	case 4: out.print("4");break;
	default : out.print("숫자");
	}
%>
문자열 메서드<br>
<%
	// 문자열에도 index가 있음
	String str2 = "first string";
//				   01234 5678910
	String str3 = "second string";
%>

str2 = <%=str2 %><br>
ing의 인덱스 번호를 출력 : <%= str2.indexOf("ing") %><br>
'a'의 인덱스 번호를 출력 : <%= str2.indexOf('a') %>
index 3 이후에 있는 's'의 index : <%= str2.indexOf('s', 3) %>
두 번째 's' index는 : <%= str2.indexOf('s', str2.indexOf('s') + 1) %>
str2의 글자 갯수 : <%= str2.length() %>
4번째 index에 있는 문자 : <%= str2.charAt(4) %>
6번 index부터 3글자 : <%= str2.substring(6, 9) %>
</body>
</html>