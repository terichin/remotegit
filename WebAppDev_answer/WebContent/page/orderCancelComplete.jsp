<%--
  注文キャンセル完了画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>ユニバ電器商品注文キャンセル完了</title>
</head>

<body>
<center>

  <h1> ユニバ電器　注文キャンセル完了 </h1>
  <br><hr><br>

  下記注文のキャンセルを完了しました。<br><br>

  <table border="1">
    <tr>
      <th>注文番号</th>
      <td>${order_dto.no}</td>
    </tr>
    <tr>
      <th>日付</th>
      <td>${order_dto.orderDate}</td>
    </tr>
    <tr>
      <th>商品名</th>
      <td>${order_dto.itemName}</td>
    </tr>
    <tr>
      <th>数量</th>
      <td>${order_dto.quantity}</td>
    </tr>

  </table>
<% session.removeAttribute("order_dto"); %>

  <br>
  <form action="/univelec/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="メニューへ戻る">
  </form>

</center>
</body>
</html>
