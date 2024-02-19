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
<title>更新成功</title>
</head>
<body>
<div class ="message-container">
	<p>家計簿の編集が完了しました</p>
	<p>更新後の内容</p>
	<p>日付：${data.day }</p>
	<p>用途：${data.purpose }</p>
	<p>金額：${data.price }円</p>
	<p><a href=ToView>リストへ戻る</a></p>
	<a href=ToMain>メイン画面へ戻る</a>
</div>
</body>
</html>