<%@ page contentType="text/html; charset=Windows-31J" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>EmployeeFind.jsp</title></head>
<body>
<h2>

<%-- EL�\���ŃZ�b�V��������DTO���擾���A�ۑ�����Ă������\�����܂� --%>
<table border="1">
<tr>
<th>ID</th>
<th>����</th>
<th>�p�X���[�h</th>
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