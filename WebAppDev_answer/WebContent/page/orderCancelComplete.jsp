<%--
  �����L�����Z���������
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>���j�o�d�폤�i�����L�����Z������</title>
</head>

<body>
<center>

  <h1> ���j�o�d��@�����L�����Z������ </h1>
  <br><hr><br>

  ���L�����̃L�����Z�����������܂����B<br><br>

  <table border="1">
    <tr>
      <th>�����ԍ�</th>
      <td>${order_dto.no}</td>
    </tr>
    <tr>
      <th>���t</th>
      <td>${order_dto.orderDate}</td>
    </tr>
    <tr>
      <th>���i��</th>
      <td>${order_dto.itemName}</td>
    </tr>
    <tr>
      <th>����</th>
      <td>${order_dto.quantity}</td>
    </tr>

  </table>
<% session.removeAttribute("order_dto"); %>

  <br>
  <form action="/univelec/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="���j���[�֖߂�">
  </form>

</center>
</body>
</html>
