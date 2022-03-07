<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Employee" %>
<%@ page import="model.EmployeeList" %>
<%
EmployeeList el=(EmployeeList)request.getAttribute("el");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データベース</title>
</head>
<body>
<%
for(Employee e:el.getEl()){
%>
<p><%=e.getId() %></p>
<p><%=e.getName() %></p>
<p><%=e.getAge() %></p>

<%
}


%>

</body>
</html>