<%--
  ���O�C�����
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>���j�o�d�탍�O�C��</title>
</head>

<body>
<center>

  <h1> ���j�o�d��@���O�C�� </h1>
  <br><hr><br>

  <form action="/univelec/control" method="POST">
    ���[�U�R�[�h�F<input type="text" name="id"><br>
    �p�X���[�h�@�F<input type="password" name="password"><br><br>
    <input type="hidden" name="action" value="p001-login">
    <input type="submit" value="���O�C��">
  </form>

</center>
</body>
</html>
