<%--
  ���[�U���ǉ����
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>���j�o�d�탆�[�U���ǉ�</title>
</head>

<body>
<center>

  <h1> ���j�o�d��@���[�U���ǉ� </h1>
  <br><hr><br>

  �ǉ����郆�[�U������͂��Ă��������B<br><br>

  <form action="/univelec/control" method="POST">
  <table border="1">
    <tr>
      <th>����</th>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <th>����</th>
      <td><input type="text" name="kana"></td>
    </tr>
    <tr>
      <th>�d�b�ԍ�</th>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <th>���[���A�h���X</th>
      <td><input type="text" name="mail"></td>
    </tr>
    <tr>
      <th>�p�X���[�h</th>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <th>���[�U����</th>
      <td>�I�y���[�^ <input type="checkbox" name="privilege"></td>
    </tr>
  </table>

  <br>
  <input type="hidden" name="action" value="p401-add">
  <input type="submit" value="�ǉ�"><br>

  </form>

</center>
</body>
</html>