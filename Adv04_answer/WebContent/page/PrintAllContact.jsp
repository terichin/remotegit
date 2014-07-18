<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>PrintAllContact.jsp</title></head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>ì‡ê¸î‘çÜ</th>
<th>ågë—î‘çÜ</th>
</tr>
<c:forEach items="${contact_list}" var="dto">
  <tr>
  <td>${dto.id}</td>
  <td>${dto.extension}</td>
  <td>${dto.mobile}</td>
  </tr>
</c:forEach>

<% session.removeAttribute("contact_list"); %>

</table>
</body>
</html>
