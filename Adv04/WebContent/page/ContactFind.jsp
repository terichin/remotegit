<%-- IDを受け取って指定の従業員情報を取得・表示するJSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- DAO/DTOを使用するのでimportを実行します --%>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>ContactFind.jsp</title></head>
<body>
<h2>

<%-- DAO/DTOを使用してDBから情報を取得します --%>
<%
	try {
		// 入力パラメータを整数値に変換する
		String strId = request.getParameter("CONTACTID");
		int id = Integer.parseInt(strId);
		// DAOを使用してDBから値を取得する
		NewContactDAO dao = new NewContactDAO();
		ContactDTO dto = null;
		try {
			dto = dao.getContact(id);
		} catch (DAOException e) {
			// エラー発生(取得失敗)
			e.printStackTrace();
		}
%>	

<%-- 取得に成功した場合の処理 --%>
<%
		if (dto != null) {
%>
<table border="1">
<tr>
<th>ID</th>
<th>内線番号</th>
<th>携帯番号</th>
</tr>
<tr>
<td><%= dto.getId() %></td>
<td><%= dto.getExtension() %></td>
<td><%= dto.getMobile() %></td>
</tr>
</table>
<%-- 取得に失敗した/入力値の取得に失敗した場合の処理 --%>
<%
		} else {
			out.println("指定のIDが見つかりません。");
		}
	} catch (NumberFormatException e) {
		out.println("IDには整数を入力してください。");
	}
%>
</h2>
</body>
</html>
