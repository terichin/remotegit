<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>�d�b�ԍ��ꗗ</title>
</head>

<body>
<center>

  <h1> �d�b�ԍ��ꗗ </h1>
  <br><hr><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <th>�����ԍ�</th>
      <th>�g�єԍ�</th>
    </tr>

    <c:forEach items="${contact_list}" var="dto">
      <tr>
        <td>${dto.id}</td>
        <td>${dto.extension}</td>
        <td>${dto.mobile}</td>
      </tr>
    </c:forEach>
  </table>
<% session.removeAttribute("emp_list"); %>

  <br>
  <form action="/advance05/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="���j���[�֖߂�">
  </form>

</center>
</body>
</html>