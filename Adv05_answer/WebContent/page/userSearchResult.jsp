<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>���[�U��񌟍�����</title>
</head>

<body>
<center>

  <h1> ���[�U��񌟍����� </h1>
  <br><hr><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <th>����</th>
    </tr>

    <tr>
      <td>${emp_dto.id}</td>
      <td>${emp_dto.name}</td>
    </tr>
  </table>
<% session.removeAttribute("emp_dto"); %>

<br>
  <form action="/advance05/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="���j���[�֖߂�">
  </form>
</center>
</body>
</html>