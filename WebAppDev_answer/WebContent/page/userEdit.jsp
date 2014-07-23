<%--
  ユーザ情報変更画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>ユニバ電器ユーザ情報変更</title>
</head>

<body>
<center>

  <h1> ユニバ電器　ユーザ情報変更 </h1>
  <br><hr><br>

  下記ユーザ情報を修正します。<br>
  削除する場合は削除ボタンを押してください。<br><br>

  <form action="/univelec/control" method="POST">
  <table border="1">
    <tr>
      <th>ユーザコード</th>
      <td>${user_dto.id}</td>
    </tr>
    <tr>
      <th>氏名</th>
      <td><input type="text" name="name" value="${user_dto.name}"></td>
    </tr>
    <tr>
      <th>かな</th>
      <td><input type="text" name="kana" value="${user_dto.kana}"></td>
    </tr>
    <tr>
      <th>電話番号</th>
      <td><input type="text" name="phone" value="${user_dto.phone}"></td>
    </tr>
    <tr>
      <th>メールアドレス</th>
      <td><input type="text" name="mail" value="${user_dto.mail}"></td>
    </tr>
    <tr>
      <th>パスワード</th>
      <td><input type="password" name="password" value="${user_dto.password}"></td>
    </tr>
    <tr>
      <th>ユーザ権限</th>
      <td>
        オペレータ
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
  <input type="submit" value="変更"><br>
  </form>

  <form action="/univelec/control" method="POST">
  <input type="hidden" name="action" value="p302-delete">
  <input type="submit" value="削除"><br>
  </form>

</center>
</body>
</html>
