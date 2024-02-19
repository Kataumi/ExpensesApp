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
<title>家計簿の登録</title>
</head>
<body>
<div class ="message-container">
		<p>家計簿の登録が完了しました</p>
		<p>日付：${data.day}</p>
		<p>用途：${data.purpose}</p>
		<p>金額：${data.price}円</p>
		<p><a href=ToMain>メイン画面へ戻る</a></p>
</div>

</body>
</html>