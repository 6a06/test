<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>ログイン失敗</p>
<p>${u.msg }</p>
<a href="docoTshubuPass">パスワードを忘れた</a><br>
<a href="docoTsubu">戻る</a>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>