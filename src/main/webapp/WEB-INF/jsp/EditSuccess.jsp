<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新成功</title>
</head>
<body>
	<h1>家計簿の編集が完了しました</h1>
	<p>日付：${data.day }</p>
	<p>用途：${data.purpose }</p>
	<p>金額：${data.price }円</p>
	<p><a href=ToView>リストへ戻る</a></p>
	<a href=ToMain>メイン画面へ戻る</a>

</body>
</html>