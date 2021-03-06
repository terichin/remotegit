<%-- 全従業員情報を一覧表示するJSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%-- ArrayListを使用するのでimportします --%>
<%@ page import="java.util.*" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html>
<head><title>AllEmployeeFind.jsp</title></head>
<body>
<%-- DBから従業員情報のリストを取得します --%>
<%
	// DAOを使用してDBから値を取得する
	NewEmployeeDAO dao = new NewEmployeeDAO();
	ArrayList<EmployeeDTO> list = null;
	try {
		list = dao.getAllEmployee();
%>
<%-- 表のヘッダ部分を表示します --%>
<table border="1">
<tr>
<th>ID</th>
<th>氏名</th>
<th>パスワード</th>
</tr>
<%-- 表の各要素を表示します --%>
<%
		for (int i = 0; i < list.size(); i++) {
			EmployeeDTO dto = list.get(i);
%>
<tr>
  <td><% out.print(dto.getId()); %></td>
  <td><% out.print(dto.getName()); %></td>
  <td><% out.print(dto.getPassword()); %></td>
</tr>
<%
		}
%>
<%-- DBからの情報取得失敗時の処理 --%>
<%
	} catch (DAOException e) {
		// 取得失敗
		e.printStackTrace();
		out.print("従業員情報の取得に失敗しました。");
	}
%>

</table>
</body>
</html>