<%@ page contentType="text/html; charset=Windows-31J" %>

<html>
<head><title>PrintContact.jsp</title></head>
<body>
<h2>

<table border="1">
<tr>
<th>ID</th>
<th>“àü”Ô†</th>
<th>Œg‘Ñ”Ô†</th>
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