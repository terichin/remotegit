<%--
  ���i�������
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>���j�o�d�폤�i����</title>
</head>

<body>
<center>

  <h1> ���j�o�d��@���i���� </h1>
  <br><hr><br>

  <form action="/univelec/control" method="POST">
  <table border="1">
    <tr>
      <th>���i�ԍ�</th>
      <td>${item_dto.no}</td>
    </tr>
    <tr>
      <th>���i��</th>
      <td>${item_dto.name}</td>
    </tr>
    <tr>
      <th>���i</th>
      <td>\ ${item_dto.price}</td>
    </tr>
  </table>

  <br>
  ���ʁF<input type="text" name="quantity">
  <input type="hidden" name="action" value="p102-order">
  <input type="submit" value="����"><br>
  </form>

</center>
</body>
</html>
