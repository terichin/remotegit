<%--
  ユーザ情報追加画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>ユニバ電器ユーザ情報追加</title>
</head>

<body>
<center>

  <h1> ユニバ電器　ユーザ情報追加 </h1>
  <br><hr><br>

  追加するユーザ情報を入力してください。<br><br>

  <form action="/univelec/control" method="POST">
  <table border="1">
    <tr>
      <th>氏名</th>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <th>かな</th>
      <td><input type="text" name="kana"></td>
    </tr>
    <tr>
      <th>電話番号</th>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <th>メールアドレス</th>
      <td><input type="text" name="mail"></td>
    </tr>
    <tr>
      <th>パスワード</th>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <th>ユーザ権限</th>
      <td>オペレータ <input type="checkbox" name="privilege"></td>
    </tr>
  </table>

  <br>
  <input type="hidden" name="action" value="p401-add">
  <input type="submit" value="追加"><br>

  </form>

</center>
</body>
</html>
