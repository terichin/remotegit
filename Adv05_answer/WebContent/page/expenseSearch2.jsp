<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>�o��ꗗ</title>
</head>

<body>
<center>

  <h1> �o��ꗗ </h1>
  <br><hr><br>

  <table border="1">
    <tr>
      <th>���t</th>
      <th>�p�r</th>
      <th>��p</th>
    </tr>

    <c:forEach items="${expense_list}" var="dto">
      <tr>
        <td>${dto.useDate}</td>
        <td>${dto.use}</td>
        <td>${dto.cost}</td>
      </tr>
    </c:forEach>
  </table>
<% session.removeAttribute("expense_list"); %>

  <br>
  <form action="/advance05/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="���j���[�֖߂�">
  </form>

</center>
</body>
</html>
