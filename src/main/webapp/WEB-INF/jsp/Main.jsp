<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.MutterList"%>
<%
MutterList ml = (MutterList) session.getAttribute("ml");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン</title>
</head>
<body>
	<p><a href="DocoTsubuUser">${u.name }</a>のメイン画面です
	</p>
	<form action="docoTsubuMain" method="post">
		つぶやきを入力<input type="text" name="tweet"><input type="submit"
			name="つぶやき">
	</form>
	<br> つぶやき
	<br>
	<%= ml.open()  %>
	<a href="docoTsubuMain">更新</a>
	<br>
	<a href="docoTsubu?action=logout">ログアウト</a>
<br>

<jsp:include page="footer.jsp"/>
</body>
</html>