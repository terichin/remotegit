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

  <h1> 画面からの入力情報に不備があります。</h1>
  <h1> 入力情報を再度確認して下さい。 </h1>
  <br><hr><br>

  <form action="/univelec/control" method="GET">
    <input type="submit" value="ログイン画面へ戻る">
  </form>

</center>
</body>
</html>
