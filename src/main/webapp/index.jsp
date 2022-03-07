<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<p>ログインIDを入力してください<br></p>
<form action="docoTsubu" method="post">
名前：<input type="text" name="name"><br>
ID：<input type="password" name="pass"><br>
<input type="submit" name="ログイン">
</form>
<br><br>
<a href="UserAdd">ユーザ登録</a><br>
<a href="docoTshubuPass">パスワードを忘れた</a>

<br>

<jsp:include page="WEB-INF/jsp/footer.jsp"/>
</body>
</html>