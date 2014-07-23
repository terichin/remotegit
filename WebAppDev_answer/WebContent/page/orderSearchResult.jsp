<%--
  ��������\�����
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>���j�o�d�풍������\��</title>
</head>
<body>
<center>

  <h1> ���j�o�d��@��������\�� </h1>
  <br><hr><br>

  ���[�U�R�[�h ${order_id} �l�̂����p�����ł��B<br>
  �����L�����Z���́A�����ԍ�����͂��đI���{�^���������Ă��������B<br>
  <br>

  <table border="1">
    <tr>
      <th>�����ԍ�</th>
      <th>������</th>
      <th>���i��</th>
      <th>����</th>
    </tr>

    <c:forEach items="${order_list}" var="order">
      <tr>
        <td>${order.no}</td>
        <td>${order.orderDate}</td>
        <td>${order.itemName}</td>
        <td>${order.quantity}</td>
      </tr>
    </c:forEach>
  </table>
<%
session.removeAttribute("order_id");
session.removeAttribute("order_list");
%>

  <br>
  <form action="/univelec/control" method="POST">
    �����ԍ��F<input type="text" name="no">
    <input type="hidden" name="action" value="p201-select">
    <input type="submit" value="�I��">
  </form>

</center>
</body>
</html>
