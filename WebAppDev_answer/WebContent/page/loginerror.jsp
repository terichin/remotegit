<%--
  エラー画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>ユニバ電器エラー</title>
</head>

<%
    // エラーが発生したのでセッションを切断する。
    if (session != null) {
        session.invalidate();
    }
%>

<body>
<center>

  <h1> ログインしていません。</h1>
  <h1> ログイン画面に戻って再度ログインし直して下さい。 </h1>
  <br><hr><br>

  <form action="/univelec/control" method="GET">
    <input type="submit" value="ログイン画面へ戻る">
  </form>

</center>
</body>
</html>
