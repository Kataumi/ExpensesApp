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
<link rel="stylesheet" type="text/css" href="CSS/result.css">
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>
<body>
<div class ="message-container">
<p>ログインに成功しました。</p>
<p>ようこそ、${user.name}さん</p>
<a href=ToMain>メイン画面へ</a>
</div>

</body>
</html>