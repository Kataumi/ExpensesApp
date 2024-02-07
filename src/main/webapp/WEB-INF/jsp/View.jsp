<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Data"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>閲覧する</title>
</head>
<body>
	<p>あなたが登録した家計簿を表示します</p>
	<p><a href=MainServlet>メイン画面へ戻る</a></p>
	
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
			
			
			<!-- [?id=<=data.getId()>]はクエリパラメーター
			 サーバーに送りたいデータを指定するために追加する文字列。
			 この場合、EditServletにdata.getId()という値をidと名付けて送っている-->
		</tr>
		<%
}
%>

	</table>
</body>
</html>