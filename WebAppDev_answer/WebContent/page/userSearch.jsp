<%--
  ユーザ情報一覧画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>ユニバ電器ユーザ情報一覧</title>
</head>

<body>
<center>

  <h1> ユニバ電器　ユーザ情報一覧 </h1>
  <br><hr><br>

  登録情報を変更する場合はユーザコードを入力し、選択ボタンを押下してください。<br>
  <br>

  <table border="1">
    <tr>
      <th>ユーザコード</th>
      <th>氏名</th>
      <th>電話番号</th>
      <th>メールアドレス</th>
    </tr>

    <c:forEach items="${user_list}" var="dto">
      <tr>
        <td>${dto.id}</td>
        <td>${dto.name}</td>
        <td>${dto.phone}</td>
        <td>${dto.mail}</td>
      </tr>
    </c:forEach>
  </table>
<% session.removeAttribute("user_list"); %>

  <br>
  <form action="/univelec/control" method="POST">
    ユーザコード：<input type="text" name="id">
    <input type="hidden" name="action" value="p301-select">
    <input type="submit" value="選択">
  </form>

</center>
</body>
</html>
