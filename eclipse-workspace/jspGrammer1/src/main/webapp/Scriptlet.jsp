<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 지시부 -->
<%@ page import = "java.util.Calendar, java.util.Date" %>
<%@ page import = "java.sql.*" %>
    
<!-- 선언. %뒤에 !를 붙임. -->
<%!
	public int calc(int num1, int num2, String opt){
		int result;
		if(opt.equals("+")){
			result = num1+num2;
		}
		else if(opt.equals("-")){
			result = num1-num2;
		}
		else if(opt.equals("*")){
			result = num1 * num2;
		}
		else if(opt.equals("/")){
			if(num2 != 0){
				result = num1 * num2;
			}
			else{
				result = 0;
			}
		}
		else if(opt.equals("%")){
			result = num1 % num2;
		}
		else{
			result =0;
		}
		return result;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 	//Scriptlet
		for(int i = 1; i < 10; i++){
			out.print(i + "<br>");
		}
	
		for(int dan = 1; dan<10; dan++){
			for(int gop = 1; gop<10; gop++){
				out.print(dan + " * " + gop + " = " + dan * gop + "<br>");
			}
		}
	%>
	<hr>
	<%
	for(int dan = 1; dan<10; dan++){
		for(int gop = 1; gop<10; gop++){
			out.print(dan + " * " + gop + " = " + dan * gop + "<br>");
		}
	}
	%>
	
	
	<%	for(int gop=1; gop<=9; gop++){	%>
	<!-- 표현식 -->
	<%= "9 * " + gop + " = " + 9 * gop + "<br/>" %>
	<%}%>
	
	<table border = 1>
	<%
		for(int tr=1; tr<=9; tr++){
			out.print("<tr>");
			for(int td=1; td<=9; td++){
	%>
	<%= "<td>" + td + "</td>" %>
	<%
			}
			out.print("</tr>");
		}
	%>
	</table>
	<%
		int sum = 0;
		for(int i = 1; i<=100; i++){
			sum += i;
			if(i == 100){
				out.print(i+"=");
			}
			else{
				if(i%30 == 0){
					out.print(i+"+"+"<br>");
				}
				else{
					out.print(i+"+");
				}
			}
		}
	%>
	<%=sum %>
	<%="<br><br><br>"%>
	
	<%=calc(3, 5, "+")%>
	
	<%
		Calendar cal = Calendar.getInstance();
	%>
	<%="<br><br><br>오늘 날짜는 " + cal.getTime() %>
</body>
</html>