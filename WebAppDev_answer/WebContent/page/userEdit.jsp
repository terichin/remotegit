<%--
  ���[�U���ύX���
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>���j�o�d�탆�[�U���ύX</title>
</head>

<body>
<center>

  <h1> ���j�o�d��@���[�U���ύX </h1>
  <br><hr><br>

  ���L���[�U�����C�����܂��B<br>
  �폜����ꍇ�͍폜�{�^���������Ă��������B<br><br>

  <form action="/univelec/control" method="POST">
  <table border="1">
    <tr>
      <th>���[�U�R�[�h</th>
      <td>${user_dto.id}</td>
    </tr>
    <tr>
      <th>����</th>
      <td><input type="text" name="name" value="${user_dto.name}"></td>
    </tr>
    <tr>
      <th>����</th>
      <td><input type="text" name="kana" value="${user_dto.kana}"></td>
    </tr>
    <tr>
      <th>�d�b�ԍ�</th>
      <td><input type="text" name="phone" value="${user_dto.phone}"></td>
    </tr>
    <tr>
      <th>���[���A�h���X</th>
      <td><input type="text" name="mail" value="${user_dto.mail}"></td>
    </tr>
    <tr>
      <th>�p�X���[�h</th>
      <td><input type="password" name="password" value="${user_dto.password}"></td>
    </tr>
    <tr>
      <th>���[�U����</th>
      <td>
        �I�y���[�^
        <c:if test="${user_dto.privilege == 1}">
          <input type="checkbox" name="privilege" checked="checked">
        </c:if>
        <c:if test="${user_dto.privilege != 1}">
          <input type="checkbox" name="privilege">
        </c:if>
      </td>
    </tr>
  </table>

  <br>
  <input type="hidden" name="id" value="${user_dto.id}">
  <input type="hidden" name="action" value="p302-edit">
  <input type="submit" value="�ύX"><br>
  </form>

  <form action="/univelec/control" method="POST">
  <input type="hidden" name="action" value="p302-delete">
  <input type="submit" value="�폜"><br>
  </form>

</center>
</body>
</html>
