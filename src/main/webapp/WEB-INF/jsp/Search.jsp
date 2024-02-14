<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿を検索する</title>
</head>
<body>

	<p>IDで検索する</p>
	<form action="SeartchServlet" method="post">
		ID：<input type="text" name="id"><br>
		<input type="hidden" name="user_id" value="${user_id}">
		<input type="submit" value="検索する">
	</form>
	
	<p>日付で検索する</p>
	<form action="SeartchServlet" method="post">
		日付：<input type="date" name="day"><br>
		<input type="hidden" name="user_id" value="${user_id}">
		<input type="submit" value="検索する">
	</form>

	<p>用途で検索する</p>
	<form action="SeartchServlet" method="post">
		用途：<input type="text" name="purpose"><br>
		<input type="hidden" name="user_id" value="${user_id}">
		 <input type="submit" value="検索する">
	</form>
	
	<p>金額で検索する</p>
	<form action="SeartchServlet" method="post">
		金額：<input type="text" name="price"><br>
		<input type="hidden" name="user_id" value="${user_id}">
		<input type="submit" value="検索する">
	</form>
	
	<p><a href=MainServlet>メイン画面へ戻る</a></p>

</body>
</html>