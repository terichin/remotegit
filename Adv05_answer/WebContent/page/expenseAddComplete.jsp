<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>�o��o�^����</title>
</head>

<body>
<center>

  <h1> �o��o�^���� </h1>
  <br><hr><br>

  ���L�o�����o�^���܂����B<br><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <td>${expense_dto.id}</td>
    </tr>
    <tr>
      <th>���t</th>
      <td>${expense_dto.useDate}</td>
    </tr>
    <tr>
      <th>�p�r</th>
      <td>${expense_dto.use}</td>
    </tr>
    <tr>
      <th>��p</th>
      <td>${expense_dto.cost}</td>
    </tr>
  </table>
<% session.removeAttribute("expense_dto"); %>

  <br>
  <form action="/advance05/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="���j���[�֖߂�">
  </form>

</center>
</body>
</html>