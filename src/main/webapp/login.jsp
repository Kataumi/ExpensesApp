<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="CSS/untilLogin.css">
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form action ="GetLogin" method="post">
<p>ログイン</p>
名前<input type ="text" name = "name"><br>
パスワード<input type ="password" name ="password"><br>
<input type ="submit" value="ログイン">
</form>

</body>
</html>