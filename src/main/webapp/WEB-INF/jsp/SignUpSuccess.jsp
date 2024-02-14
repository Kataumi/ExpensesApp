<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.User"%>
<%User user = (User) session.getAttribute("user");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録完了</title>
</head>
<body>
	<h1>新規登録しました。</h1>
		<p>名前：${user.name }</p>
		<p>パスワード：${user.password }</p>
		<a href="LoginServlet">ログインする</a>
	</form>
</body>
</html>