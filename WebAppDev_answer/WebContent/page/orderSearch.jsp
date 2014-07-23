<%--
  注文履歴検索条件入力画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>ユニバ電器注文履歴検索条件入力</title>
</head>

<body>
<center>

  <h1> ユニバ電器　注文履歴検索条件入力 </h1>
  <br><hr><br>

  <form action="/univelec/control" method="POST">
    ユーザコード：<input type="text" name="id"><br><br>
    <input type="hidden" name="action" value="p211-search">
    <input type="submit" value="検索">
  </form>

</center>
</body>
</html>
