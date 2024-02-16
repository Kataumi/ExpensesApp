<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿を登録</title>
</head>
<body>
<h1>家計簿の登録をする</h1>
<p><a href=ToMain>メイン画面へ戻る</a></p>
<form action="GetCreate" method="post">
日付：<input type ="date" name = "day"><br>
用途：<input type ="text" name = "purpose"><br>
金額：<input type ="text" name = "price">円<br>
<input type="hidden" name="user_id" value="${user_id}">
<input type="submit" value="登録する">
</form>

</body>
</html>