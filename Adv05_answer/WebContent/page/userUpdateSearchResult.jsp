<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>���[�U���X�V���</title>
</head>

<body>
<center>

  <h1> ���[�U���X�V��� </h1>
  <br><hr><br>

  <form action="/advance05/control" method="POST">
  <table border="1">
    <tr>
      <th>����</th>
      <td><input type="text" name="name" value="${emp_dto.name}"></td>
    </tr>
    <tr>
      <th>�p�X���[�h</th>
      <td><input type="password" name="password"></td>
    </tr>
  </table>

  <br>
  <input type="hidden" name="action" value="renew">
  <input type="hidden" name="EMPID" value="${emp_dto.id}">
  <input type="submit" value="�X�V"><br>

  </form>

<% session.removeAttribute("emp_dto"); %>

</center>
</body>
</html>