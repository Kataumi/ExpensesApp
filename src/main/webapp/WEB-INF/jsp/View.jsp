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
	<table>
		<tr>
			<th>ID</th>
			<th>Day</th>
			<th>Purpose</th>
			<th>Price</th>
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
			<td><%=data.getPrice()%></td>
		</tr>
		<%
}
%>

	</table>
</body>
</html>