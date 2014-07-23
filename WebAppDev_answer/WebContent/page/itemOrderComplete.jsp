<%--
  注文完了画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>ユニバ電器商品注文完了</title>
</head>

<body>
<center>

  <h1> ユニバ電器　商品注文完了 </h1>
  <br><hr><br>


  ご注文ありがとうございました。<br>
  下記ご注文を注文番号<b> ${order_dto.no} </b>で受け付けました。<br>
  <br>

  <table border="1">
    <tr>
      <th>商品番号</th>
      <td>${item_dto.no}</td>
    </tr>
    <tr>
      <th>商品名</th>
      <td>${item_dto.name}</td>
    </tr>
    <tr>
      <th>価格</th>
      <td>\ ${item_dto.price}</td>
    </tr>
    <tr>
      <th>数量</th>
      <td>${order_dto.quantity}</td>
    </tr>
  </table>

<%
  session.removeAttribute("item_dto");
  session.removeAttribute("order_dto");
%>

  <br>
  <form action="/univelec/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="メニューへ戻る">
  </form>

</center>
</body>
</html>
