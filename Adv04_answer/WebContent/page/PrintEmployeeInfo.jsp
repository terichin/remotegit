<%@ page contentType="text/html; charset=Windows-31J" %>

<html>
<head><title>PrintEmployeeInfo.jsp</title></head>
<body>
<h2>
<table border="1">
<tr>
<th>ID</th>
<th>����</th>
<th>�p�X���[�h</th>
<th>�����ԍ�</th>
<th>�g�єԍ�</th>
</tr>
<tr>
<td>${employeeinfo_dto.id}</td>
<td>${employeeinfo_dto.userName}</td>
<td>${employeeinfo_dto.password}</td>
<td>${employeeinfo_dto.extension}</td>
<td>${employeeinfo_dto.mobile}</td>
</tr>
</table>

<% session.removeAttribute("employeeinfo_dto"); %>

</h2>
</body>
</html>