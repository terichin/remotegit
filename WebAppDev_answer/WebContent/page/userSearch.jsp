<%--
  ���[�U���ꗗ���
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>���j�o�d�탆�[�U���ꗗ</title>
</head>

<body>
<center>

  <h1> ���j�o�d��@���[�U���ꗗ </h1>
  <br><hr><br>

  �o�^����ύX����ꍇ�̓��[�U�R�[�h����͂��A�I���{�^�����������Ă��������B<br>
  <br>

  <table border="1">
    <tr>
      <th>���[�U�R�[�h</th>
      <th>����</th>
      <th>�d�b�ԍ�</th>
      <th>���[���A�h���X</th>
    </tr>

    <c:forEach items="${user_list}" var="dto">
      <tr>
        <td>${dto.id}</td>
        <td>${dto.name}</td>
        <td>${dto.phone}</td>
        <td>${dto.mail}</td>
      </tr>
    </c:forEach>
  </table>
<% session.removeAttribute("user_list"); %>

  <br>
  <form action="/univelec/control" method="POST">
    ���[�U�R�[�h�F<input type="text" name="id">
    <input type="hidden" name="action" value="p301-select">
    <input type="submit" value="�I��">
  </form>

</center>
</body>
</html>
