<%--
  ���[�U���폜�������
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>���j�o�d�탆�[�U���폜����</title>
</head>

<body>
<center>

  <h1> ���j�o�d��@���[�U���폜���� </h1>
  <br><hr><br>

  ���L���[�U�����폜���܂����B<br><br>

  <table border="1">
    <tr>
      <th>���[�U�R�[�h</th>
      <td>${user_dto.id}</td>
    </tr>
    <tr>
      <th>����</th>
      <td>${user_dto.name}</td>
    </tr>
    <tr>
      <th>����</th>
      <td>${user_dto.kana}</td>
    </tr>
    <tr>
      <th>�d�b�ԍ�</th>
      <td>${user_dto.phone}</td>
    </tr>
    <tr>
      <th>���[���A�h���X</th>
      <td>${user_dto.mail}</td>
    </tr>
    <tr>
      <th>���[�U����</th>
      <td>
        <c:if test="${user_dto.privilege == 1}">
          �I�y���[�^
        </c:if>
        <c:if test="${user_dto.privilege != 1}">
          ��ʃ��[�U
        </c:if>
      </td>
    </tr>
  </table>
<% session.removeAttribute("user_dto"); %>

  <br>
  <form action="/univelec/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="���j���[�֖߂�">
  </form>

</center>
</body>
</html>
