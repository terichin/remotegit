<%--
  ���i�ꗗ���
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>���j�o�d�폤�i��������</title>
</head>

<body>
<center>
  <h1> ���j�o�d��@���i�������� </h1>
  <br><hr><br>

  �w�����������i�̏��i�ԍ�����͂��A�I���{�^���������Ă��������B<br><br>

  <table border="1">
    <tr>
      <th>���i�ԍ�</th>
      <th>���i��</th>
      <th>���i</th>
    </tr>

    <c:forEach items="${item_list}" var="item">
      <tr>
        <td>${item.no}</td>
        <td>${item.name}</td>
        <td>\ ${item.price}</td>
      </tr>
    </c:forEach>
    <% session.removeAttribute("item_list"); %>
  </table>

  <br>
  <form action="/univelec/control" method="POST">
    ���i�ԍ��F<input type="text" name="itemNo">
    <input type="hidden" name="action" value="p101-select">
    <input type="submit" value="�I��">
  </form>
</center>
</body>
</html>
