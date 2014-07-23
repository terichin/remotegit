<%--
  ログイン画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>ユニバ電器ログイン</title>
</head>

<body>
<center>

  <h1> ユニバ電器　ログイン </h1>
  <br><hr><br>

  <form action="/univelec/control" method="POST">
    ユーザコード：<input type="text" name="id"><br>
    パスワード　：<input type="password" name="password"><br><br>
    <input type="hidden" name="action" value="p001-login">
    <input type="submit" value="ログイン">
  </form>

</center>
</body>
</html>
