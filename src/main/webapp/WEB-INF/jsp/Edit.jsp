<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿を編集する</title>
</head>
<body>
	<p>日付で検索する</p>
	<form action="SeartchServlet" method="post">
		日付：<input type="date" name="day"><br>
		<input type="submit" value="検索する">
	</form>

	<p>用途で検索する</p>
	<form action="SeartchServlet" method="post">
		用途：<input type="text" name="purpose"><br>
		 <input type="submit" value="検索する">
	</form>

</body>
</html>