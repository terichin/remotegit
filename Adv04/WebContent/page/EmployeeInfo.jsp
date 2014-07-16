<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>EmployeeInfo.jsp</title></head>
<body>
<h2>

<%
	try {
		// 入力パラメータを整数値に変換する
		String strId = request.getParameter("ID");
		int id = Integer.parseInt(strId);
		// DAOを使用してDBから値を取得する
		EmployeeInfoDAO dao = new EmployeeInfoDAO();
		EmployeeInfoDTO dto = null;
		try {
			dto = dao.getEmployeeInfo(id);
		} catch (DAOException e) {
			// エラー発生(取得失敗)
			e.printStackTrace();
		}

		if (dto != null) {
%>
<table border="1">
<tr>
<th>ID</th>
<th>氏名</th>
<th>パスワード</th>
<th>内線番号</th>
<th>携帯番号</th>
</tr>
<tr>
<td><% out.println(dto.getId()); %></td>
<td><% out.println(dto.getUserName()); %></td>
<td><% out.println(dto.getPassword()); %></td>
<td><% out.println(dto.getExtension()); %></td>
<td><% out.println(dto.getMobile()); %></td>
</tr>
</table>
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
