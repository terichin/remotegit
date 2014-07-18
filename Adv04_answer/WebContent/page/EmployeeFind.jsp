<%@ page contentType="text/html; charset=Windows-31J" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>EmployeeFind.jsp</title></head>
<body>
<h2>

<%-- EL構文でセッションからDTOを取得し、保存されている情報を表示します --%>
<table border="1">
<tr>
<th>ID</th>
<th>氏名</th>
<th>パスワード</th>
</tr>
<tr>
<td>${employee.id}</td>
<td>${employee.name}</td>
<td>${employee.password}</td>
</tr>
</table>
<% session.removeAttribute("employee"); %>
</h2>
</body>
</html>