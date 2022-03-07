<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User u=(User)request.getAttribute("u");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果</title>
</head>
<body>
<%=u.getMsg() %><br>

<a href="docoTsubu">戻る</a>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>