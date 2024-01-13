<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>
<body>
<h1>ログインに成功しました。</h1>
<p>名前：${user.name }</p>
<p>パスワード：${user.password }</p>
<a href=MainServlet>メイン画面へ</a>

</body>
</html>