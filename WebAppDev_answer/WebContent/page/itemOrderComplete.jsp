<%--
  �����������
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>���j�o�d�폤�i��������</title>
</head>

<body>
<center>

  <h1> ���j�o�d��@���i�������� </h1>
  <br><hr><br>


  ���������肪�Ƃ��������܂����B<br>
  ���L�������𒍕��ԍ�<b> ${order_dto.no} </b>�Ŏ󂯕t���܂����B<br>
  <br>

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
    <tr>
      <th>����</th>
      <td>${order_dto.quantity}</td>
    </tr>
  </table>

<%
  session.removeAttribute("item_dto");
  session.removeAttribute("order_dto");
%>

  <br>
  <form action="/univelec/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="���j���[�֖߂�">
  </form>

</center>
</body>
</html>
