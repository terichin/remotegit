<%-- �S�]�ƈ������ꗗ�\������JSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- JSTL���g������taglib�f�B���N�e�B�u���w�肵�܂� --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>AllEmployeeFind.jsp</title></head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>����</th>
<th>�p�X���[�h</th>
</tr>
<%-- �\�̊e�v�f��\�����܂� --%>
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