<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>���[�U�X�V����</title>
</head>

<body>
<center>

  <h1> ���[�U�X�V���� </h1>
  <br><hr><br>

  ���L���[�U�����X�V���܂����B<br><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <td>${emp_dto.id}</td>
    </tr>
    <tr>
      <th>����</th>
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