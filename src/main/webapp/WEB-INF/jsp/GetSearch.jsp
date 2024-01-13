<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Data"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿の編集</title>
</head>
<body>
<h1>家計簿の編集をする</h1>

<p>検索結果はこちらです</p>
家計簿リスト：${sessionScope.dataList}
<input type="submit" value="編集する">

</body>
</html>