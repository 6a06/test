<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録</title>
</head>
<body>
	ユーザ登録します
	<br>
	<form action="UserAdd" method="post">
		ユーザー名:<input type="text" name="name"><br> パスワード:<input
			type="password" name="pass"><br> <input type="submit"
			name="登録"><br>
	</form>

	<a href="docoTsubu">戻る</a>
<br>

<jsp:include page="footer.jsp"/>
</body>
</html>