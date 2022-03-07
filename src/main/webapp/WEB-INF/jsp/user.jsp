<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.MutterList" %>
<%
User u=(User)session.getAttribute("u");
MutterList ml=(MutterList)session.getAttribute("ml");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>ユーザー名：<%=u.getName() %></p>
フォローリスト:<%=u.getFollow().getFl().size() %><br>
フォロワーリスト:<%=u.getFollower().getFl().size() %><br>
あなたのツイート
タイムライン<br>
<%=ml.open(u) %><br>

	<a href="docoTsubuMain">メインへ</a>
<br>

<jsp:include page="footer.jsp"/>
</body>
</html>