<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Data"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="CSS/searchResult.css">
<meta charset="UTF-8">
<title>家計簿アプリ 検索結果画面</title>
</head>
<body>
	
	<p>検索結果</p>
	<table>
		<tr>
			<th>番号</th>
			<th>日付</th>
			<th>用途</th>
			<th>金額</th>
		</tr>
		<%
		List<Data> list = (List<Data>) request.getAttribute("dataList");
		%>
		<%
		for (Data data : list) {
		%>
		<tr>
			<td><%=data.getId()%></td>
			<td><%=data.getDay()%></td>
			<td><%=data.getPurpose()%></td>
			<td><%=data.getPrice()%>円</td>
			<td><a href="ToEdit?id=<%=data.getId()%>">編集する</a> 
			<a href="ToDelete?id=<%=data.getId()%>">削除する</a></td>
		</tr>
		<%}%>
	</table>
		<a class="main-button" href=ToSearch>検索画面へ戻る</a>
		<a class="main-button" href=ToMain>メイン画面へ戻る</a>
	
</body>
</html>