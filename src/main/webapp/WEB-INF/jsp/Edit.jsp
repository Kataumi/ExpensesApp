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
<title>家計簿アプリ　編集画面</title>
</head>
<body>
<p>編集後、下の「更新する」を押してください</p>
<form action="GetEdit" method="post">
<div class="input-group">
<input type="hidden" name="id" value="${data.id}">
<div>日付：<input type ="date" name = "day" value="${data.day}"></div>
<div>用途：<input type ="text" name = "purpose" value="${data.purpose}"></div>
<div>金額：<input type ="text" name = "price" value="${data.price}">円</div>
</div>
<input type="submit" value="更新する">
<a href=ToView>リストへ戻る</a>
<a href=ToMain>メイン画面へ戻る</a>
</form>

</body>
</html>