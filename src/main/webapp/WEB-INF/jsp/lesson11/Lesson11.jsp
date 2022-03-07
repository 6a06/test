<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int count=(Integer)application.getAttribute("count");
System.out.println("JSPを起動");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
訪問回数<%=count %><br>
<a href="Losson11">戻る</a>
</body>
</html>