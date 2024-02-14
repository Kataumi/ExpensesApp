<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Data"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿の編集</title>
</head>
<body>
	<h1>家計簿の検索結果</h1>

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
			<td><a href="EditServlet?id=<%=data.getId()%>">編集する</a></td>
			<td><a href="ToDelete?id=<%=data.getId()%>">削除する</a></td>
		</tr>
		<%
}
%>
	</table>
	<p>
		<a href=MainServlet>メイン画面へ戻る</a>
	</p>

</body>
</html>