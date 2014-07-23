<%--
  ユーザ情報削除完了画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>ユニバ電器ユーザ情報削除完了</title>
</head>

<body>
<center>

  <h1> ユニバ電器　ユーザ情報削除完了 </h1>
  <br><hr><br>

  下記ユーザ情報を削除しました。<br><br>

  <table border="1">
    <tr>
      <th>ユーザコード</th>
      <td>${user_dto.id}</td>
    </tr>
    <tr>
      <th>氏名</th>
      <td>${user_dto.name}</td>
    </tr>
    <tr>
      <th>かな</th>
      <td>${user_dto.kana}</td>
    </tr>
    <tr>
      <th>電話番号</th>
      <td>${user_dto.phone}</td>
    </tr>
    <tr>
      <th>メールアドレス</th>
      <td>${user_dto.mail}</td>
    </tr>
    <tr>
      <th>ユーザ権限</th>
      <td>
        <c:if test="${user_dto.privilege == 1}">
          オペレータ
        </c:if>
        <c:if test="${user_dto.privilege != 1}">
          一般ユーザ
        </c:if>
      </td>
    </tr>
  </table>
<% session.removeAttribute("user_dto"); %>

  <br>
  <form action="/univelec/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="メニューへ戻る">
  </form>

</center>
</body>
</html>
