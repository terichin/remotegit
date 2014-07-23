<%--
  注文キャンセル画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>ユニバ電器商品注文キャンセル</title>
</head>

<body>
<center>

  <h1> ユニバ電器　注文キャンセル </h1>
  <br><hr><br>

  下記注文をキャンセルします。<br><br>

  <form action="/univelec/control" method="POST">
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

  <br>
  <input type="hidden" name="action" value="p202-cancel">
  <input type="submit" value="注文キャンセル"><br>

  </form>

</center>
</body>
</html>
