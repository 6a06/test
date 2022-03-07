<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.UserList" %>
<%
UserList ul=(UserList)application.getAttribute("ul");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データベース</title>
</head>
<body>
<%
for(User u:ul.getUl()){
%>
<p><%=u.getId() %></p>
<p><%=u.getName() %></p>
<p><%=u.getPass() %></p>

<%
}


%>

</body>
</html>