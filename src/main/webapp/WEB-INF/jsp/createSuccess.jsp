<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.Data"%>
<%Data data = (Data) session.getAttribute("data");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿の登録</title>
</head>
<body>
		<h1>家計簿の登録が完了しました</h1>
		<p>日付：${data.day }</p>
		<p>用途：${data.purpose }</p>
		<p>金額：${data.price }円</p>
		<a href=MainServlet>メイン画面へ戻る</a>

</body>
</html>