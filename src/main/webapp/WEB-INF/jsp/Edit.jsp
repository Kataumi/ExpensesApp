<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿を編集</title>
</head>
<body>
<h1>家計簿を編集する</h1>
<form action="GetEdit" method="post">
<input type="hidden" name="id" value="${data.id}">
日付：<input type ="date" name = "day" value="${data.day}"><br>
用途：<input type ="text" name = "purpose" value="${data.purpose}"><br>
金額：<input type ="text" name = "price" value="${data.price}">円<br>
<input type="submit" value="更新する">
</form>

</body>
</html>