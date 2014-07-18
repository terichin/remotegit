<%-- 全従業員情報を一覧表示するJSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%-- ArrayListを使用するのでimportします --%>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>AllContactFind.jsp</title></head>
<body>
<%-- DBから従業員情報のリストを取得します --%>
<%
	NewContactDAO dao = new NewContactDAO();
	ArrayList<ContactDTO> list = null;
	try {
		list = dao.getAllContact();
%>
<%-- 表のヘッダ部分を表示します --%>
<table border="1">
<tr>
<th>ID</th>
<th>内線番号</th>
<th>携帯番号</th>
</tr>
<%-- 表の各要素を表示します --%>
<%
		for (int i = 0; i < list.size(); i++) {
			ContactDTO dto = list.get(i);
%>
<tr>
<td><% out.println(dto.getId()); %></td>
<td><% out.println(dto.getExtension()); %></td>
<td><% out.println(dto.getMobile()); %></td>
</tr>
<%
		}
%>
<%-- DBからの情報取得失敗時の処理 --%>
<%
	} catch (DAOException e) {
		// 取得失敗
		e.printStackTrace();
		out.print("連絡先情報の取得に失敗しました。");
	}
%>

</table>
</body>
</html>
