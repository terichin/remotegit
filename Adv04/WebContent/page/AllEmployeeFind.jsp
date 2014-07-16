<%-- 全従業員情報を一覧表示するJSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- JSTLを使う時はtaglibディレクティブを指定します --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>AllEmployeeFind.jsp</title></head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>氏名</th>
<th>パスワード</th>
</tr>
<%-- 表の各要素を表示します --%>
<c:forEach items="${employee_list}" var="dto">
  <tr>
  <td>${dto.id}</td>
  <td>${dto.name}</td>
  <td>${dto.password}</td>
  </tr>
</c:forEach>
<% session.removeAttribute("employee_list"); %>
</table>
</body>
</html>