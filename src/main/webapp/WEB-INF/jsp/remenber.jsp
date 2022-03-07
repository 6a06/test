<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード再発行</title>
</head>
<body>
<form action="docoTshubuPass" method="post">
ユーザ名:<input type="text" name="name"><br>
<input type="submit" name="送信">
</form>
<a href="docoTsubu">戻る</a>

<br>
<jsp:include page="footer.jsp"/>
</body>
</html>