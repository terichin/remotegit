<%@ page contentType="text/html; charset=Windows-31J" %>

<html>
<head><title>PrintContact.jsp</title></head>
<body>
<h2>

<table border="1">
<tr>
<th>ID</th>
<th>内線番号</th>
<th>携帯番号</th>
</tr>
<tr>
<td>${contact_dto.id}</td>
<td>${contact_dto.extension}</td>
<td>${contact_dto.mobile}</td>
</tr>
</table>

<% session.removeAttribute("contact_dto"); %>

</h2>
</body>
</html>