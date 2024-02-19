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
<link rel="stylesheet" type="text/css" href="CSS/create.css">
<meta charset="UTF-8">
<title>家計簿アプリ　作成画面</title>
</head>
<body>
<p>日付、用途、金額を入力してください</p>
<p>後から編集できます</p>
<form action="GetCreate" method="post">
<div class="input-group">
<div>日付：<input type ="date" name = "day"></div>
<div>用途：<input type ="text" name = "purpose"></div>
<div>金額：<input type ="text" name = "price">円</div>
</div>
<input type="hidden" name="user_id" value="${user_id}">
<input type="submit" value="登録する">
<a href=ToMain>メイン画面へ戻る</a>
</form>


</body>
</html>